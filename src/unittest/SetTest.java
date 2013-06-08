/**
 * 
 */
package unittest;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import core.Set;

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
		assertEquals(5, s.getValue(s.addValue(5)));
		assertEquals(15, s.getValue(s.addValue(15)));
	}
	
	@Test
	public void testReplaceValue() {
		s.replaceValue(25, 0);
		assertEquals(25, s.getValue(0));
	}
	
	@Test
	public void testDeleteValue() {
		s.deleteValue(0);
		assertEquals(15, s.getValue(0));
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
}