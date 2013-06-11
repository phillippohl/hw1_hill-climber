/**
 * 
 */
package core;

import io.BasicInput;

import java.io.IOException;

/**
 * @author Phillipp Ohl
 * @version 0.1
 */
public class HillClimberImplementation {

	private static HillClimber hc;
	private static int parentSetLength;

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		try {
			getInitialInformation();
			Set parent = new Set(parentSetLength);
			hc = new HillClimber(parent);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		hc.defineInitialState();
		
		
		try {
			hc.pickRandomSolution();
			System.out.println("Random pick subset1: " + hc.getCurrentSolution()[0] + '\n' + "Random pick subset2: " + hc.getCurrentSolution()[1]);
		} catch (Exception e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		
		try {
			hc.startNeighborhoodSearch();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	private static void getInitialInformation() throws IOException {
		parentSetLength = (int) BasicInput.getIntegerInput("Specify the parent set's length (only 100, 500 and 1000 are permitted): ");
	}
}