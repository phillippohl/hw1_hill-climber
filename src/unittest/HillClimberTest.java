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
	Set parentSet = new Set(2);

	@Before
	public void initialize() {
		hc = new HillClimber(parentSet);
	}
	
	@After
	public void cleanUp() {
		hc = null;
	}
	
	@Test
	public void testDefineInitialState() {
		hc.defineInitialState();
		assertEquals(1, hc.getSubsetOne().getLength());
	}
}