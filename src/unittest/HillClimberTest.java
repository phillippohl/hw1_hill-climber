/**
 * 
 */
package unittest;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import core.HillClimber;
import core.Set;

/**
 * @author Phillipp Ohl
 * @version 0.1
 */
public class HillClimberTest {

	private HillClimber hc;
	Set parentSet = new Set(10);

	@Before
	public void initialize() {
		hc = new HillClimber(parentSet);
		hc.defineInitialState();
		hc.pickRandomSolution();
	}
	
	@After
	public void cleanUp() {
		hc = null;
	}
	
	@Test
	public void testDefineInitialState() {
		assertEquals(5, hc.getSubsetOne().getLength());
	}
	
	@Test
	public void testPickRandomSolution() throws Exception {
		assertNotNull(hc.getCurrentSolution());
	}
	
	@Test
	public void testGetCurrentSolution() throws Exception {
		assertNotNull(hc.getCurrentSolution());
	}
	
	@Test
	public void testComputeFitnessValue() throws Exception {
		int expectedDifference = 0;
		
		for (int i = 0; i <  hc.getSubsetOne().getLength(); i++) {
			expectedDifference += hc.getSubsetOne().getValue(i) - hc.getSubsetTwo().getValue(i);
		}
			
		hc.computeFitnessValue(hc.getSubsetOne(), hc.getSubsetTwo());
		assertEquals(expectedDifference, hc.getFitnessValue());
	}
	
	@Test
	public void testUpdateSolution() throws Exception {	
		for (int i = 0; i < hc.getSubsetOne().getLength(); i++) {
			hc.getSubsetOne().replaceValue(i+2, i);
		}
		
		for (int i = 0; i < hc.getSubsetTwo().getLength(); i++) {
			hc.getSubsetTwo().replaceValue(i, i);
		}
		
		hc.updateSolution(3, 2);
		
		assertEquals(2, hc.getSubsetOne().getValue(3));
		assertEquals(5, hc.getSubsetTwo().getValue(2));
	}
	
	@Test
	public void testComputePossibleSolution() throws Exception {
		int[] expectedArray = new int[8];
		
		expectedArray[0] = 4;
		expectedArray[1] = 6;
		expectedArray[2] = 8;
		expectedArray[3] = 2;
		expectedArray[4] = 6;
		expectedArray[5] = 0;
		expectedArray[6] = 2;
		expectedArray[7] = 4;
		
		for (int i = 0; i < hc.getSubsetOne().getLength(); i++) {
			hc.getSubsetOne().replaceValue(i+2, i);
			/*
			 * 0 --> 2
			 * 1 --> 3
			 * 2 --> 4
			 * 3 --> 5
			 * 4 --> 6
			 */
		}
		
		for (int i = 0; i < hc.getSubsetTwo().getLength(); i++) {
			hc.getSubsetTwo().replaceValue(i, i);
			/*
			 * 0 --> 0
			 * 1 --> 1
			 * 2 --> 2
			 * 3 --> 3
			 * 4 --> 4
			 */
		}
		
		hc.setRandomSolution(3, 2);
		
		hc.computePossibleSolutions();
			
		assertArrayEquals(expectedArray, hc.getPossibleSolutions());
	}
	
	@Test
	public void testFindMinimum() {
		int expectedDifference = 0;
		
		for (int i = 0; i < hc.getSubsetOne().getLength(); i++) {
			hc.getSubsetOne().replaceValue(i+2, i);
		}
		
		for (int i = 0; i < hc.getSubsetTwo().getLength(); i++) {
			hc.getSubsetTwo().replaceValue(i, i);
		}
		
		/*for (int i = 0; i < s1.getLength(); i++) {
			s1.addValue(hc.getSubsetOne().getValue(i));
		}
		
		for (int j = 0; j < s2.getLength(); j++) {
			s2.addValue(hc.getSubsetTwo().getValue(j));
		}
		
		s1.replaceValue(s2.getValue(s2.getCurrentValueIndex()-1), s1.getCurrentValueIndex()-1);
		s2.replaceValue(s1.getValue(s1.getCurrentValueIndex()-1), s2.getCurrentValueIndex()-1);*/
		
		hc.getSubsetOne().calculateSum();
		hc.getSubsetTwo().calculateSum();
		expectedDifference = hc.getSubsetOne().getSum() - hc.getSubsetTwo().getSum();
		
		//System.out.println("expectedDifference: " + expectedDifference);
		
		//assertEquals(expectedDifference, hc.computePossibleSolutions());
	}
}