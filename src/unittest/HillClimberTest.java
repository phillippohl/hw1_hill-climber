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
		//hc.pickRandomSolution();
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
	public void testPickRandomSolution() {
		assertNotNull(hc.getCurrentSolution());
	}
	
	@Test
	public void testGetCurrentSolution() {
		assertNotNull(hc.getCurrentSolution());
	}
	
	@Test
	public void testComputeFitnessValue() {
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
		int expectedDifference = 0;
		
		Set s1 = new Set(5);
		Set s2 = new Set(5);
		
		s1.addValue(1);
		s1.addValue(5);
		s1.addValue(6);
		s1.addValue(7);
		s1.addValue(4);
		s2.addValue(2);
		s2.addValue(0);
		s2.addValue(3);
		s2.addValue(4);
		s2.addValue(1);
		
		/*for (int i = 0; i < s1.getLength(); i++) {
			s1.addValue(hc.getSubsetOne().getValue(i));
		}
		
		for (int j = 0; j < s2.getLength(); j++) {
			s2.addValue(hc.getSubsetTwo().getValue(j));
		}
		
		s1.replaceValue(s2.getValue(s2.getCurrentValueIndex()-1), s1.getCurrentValueIndex()-1);
		s2.replaceValue(s1.getValue(s1.getCurrentValueIndex()-1), s2.getCurrentValueIndex()-1);*/
		
		s1.calculateSum();
		s2.calculateSum();
		expectedDifference = s1.getSum() - s2.getSum();
		
		//System.out.println("expectedDifference: " + expectedDifference);
		
		assertEquals(expectedDifference, hc.computePossibleSolution());
	}
}