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
		s = new Set(100);
	}
	
	@After
	public void cleanUp() {
		s = null;
	}
	
	@Test
	public void testGetLength() {
		assertEquals(100, s.getLength());
	}
	
	@Test
	public void testSetValue() {
		assertEquals(5, s.getValue(s.addValue(5)));
		assertEquals(15, s.getValue(s.addValue(15)));
	}
}