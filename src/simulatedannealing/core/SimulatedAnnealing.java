/**
 * 
 */
package simulatedannealing.core;

import general.set.Set;
import simulatedannealing.interfaces.SimulatedAnnealingSpec;

/**
 * @author Phillipp Ohl
 * @version 0.1
 */
public class SimulatedAnnealing implements SimulatedAnnealingSpec {

	@Override
	public void defineInitialState() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public int computeFitnessValue(Set s1, Set s2) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public void startNeighborhoodSearch() throws Exception {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void computePossibleSolutions() throws Exception {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void findMinimum() throws Exception {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void updateSolution(int indexSubsetOne, int indexSubsetTwo)
			throws Exception {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void pickRandomSolution() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public int[] getCurrentSolution() throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Set getSubsetOne() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Set getSubsetTwo() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public int getFitnessValue() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int[] getPossibleSolutions() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void printPossibleSolutions() {
		// TODO Auto-generated method stub
		
	}

}