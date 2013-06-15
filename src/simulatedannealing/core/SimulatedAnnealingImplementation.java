/**
 * 
 */
package simulatedannealing.core;

import general.set.Set;
import simulatedannealing.gui.OutputPane;

import java.io.IOException;

/**
 * @author Phillipp Ohl
 * @version 0.1
 */
public class SimulatedAnnealingImplementation extends Thread {

	static OutputPane gui;
	private static SimulatedAnnealing sa;
	private static int parentSetLength;

	/**
	 * @param args
	 */
	public static void main(String[] args) {	
		gui = new OutputPane();
	}
	
	public static void startAlgorithm() {
		try {
			getInitialInformation();
			Set parent = new Set(parentSetLength);
			sa = new SimulatedAnnealing(parent);
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		sa.defineInitialState();
				
		try {
			sa.pickRandomSolution();
			System.out.println("Random pick subset1: " + sa.getCurrentSolution()[0] + '\n' + "Random pick subset2: " + sa.getCurrentSolution()[1]);
		} catch (Exception e1) {
			e1.printStackTrace();
		}
		
		try {
			startNeighborhoodSearch();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	private static void getInitialInformation() throws IOException {
		parentSetLength = gui.getSizeOfParentSet();	
	}
	
	private static void startNeighborhoodSearch() throws Exception {
		new Thread() {
			@Override public void run() {
				try {
			  		do {
			  			Thread.sleep(20);
			  			
			  			sa.computePossibleSolutions();
						
						setLabels();
						sa.printPossibleSolutions();
						
						if (sa.getPending() == 90) {
							break;
						}
						
						sa.findMinimum();	
						
						if (sa.getReachedLocalMinimum() == true) {
							gui.showLocalMinimumDialog();
						}	
						if (sa.getFitnessValue() == 0) {
							gui.showGlobalMinimumDialog();
						}		
						
						if (sa.getAcceptedValues() >= 25) {
							sa.coolingTemperature();
							System.out.println("Current temperature = " + sa.getTemperature());
							sa.resetAcceptedValues();
						}					
					} while(sa.getPending() < 100);
				} catch ( InterruptedException e ) { e.printStackTrace(); } catch (Exception e) {
				  e.printStackTrace();
				}
			}
	    }.start();
	}
	
	private static void setLabels() {
		int[] labelInput = sa.getPossibleSolutions();
		gui.setLabels(labelInput[0], labelInput[1], labelInput[2], labelInput[3], labelInput[4], labelInput[5], labelInput[6], labelInput[7]);
		gui.setCurrentSolutionLabel(sa.getFitnessValue());
	}
}