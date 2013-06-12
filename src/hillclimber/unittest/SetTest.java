/**
 * 
 */
package hillclimber.unittest;

import static org.junit.Assert.*;
import hillclimber.core.Set;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;


/**
 * @author Phillipp Ohl
 * @version 0.1
 */
public class SetTest {

	private Set s;

	@Before
	public void initialize() {
		s = new Set(2);
		s.addValue(5);
		s.addValue(15);
	}
	
	@After
	public void cleanUp() {
		s = null;
	}
	
	@Test
	public void testGetLength() {
		assertEquals(2, s.getLength());
	}
	
	@Test
	public void testAddValue() {
		try {
			assertEquals(5, s.getValue(s.addValue(5)));
			assertEquals(15, s.getValue(s.addValue(15)));
		} catch (Exception e) {
			e.printStackTrace();
		}	
	}
	
	@Test
	public void testReplaceValue() {
		s.replaceValue(25, 0);
		try {
			assertEquals(25, s.getValue(0));
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	@Test
	public void testDeleteValue() {
		s.deleteValue(0);
		try {
			assertEquals(15, s.getValue(0));
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	@Test
	public void testCalculateSum() {
		s.calculateSum();
		assertEquals(20, s.getSum());
	}
	
	@Test
	public void testGetRandomMember() {
		assertNotNull(s.getRandomMember());
	}
	
	@Test
	public void testGetCopy() {
		Set copy = s.getCopy();
		assertArrayEquals(s.getValues(), copy.getValues());
		assertEquals(s.getLength(), copy.getLength());
		assertEquals(s.getSum(), copy.getSum());
	}
}