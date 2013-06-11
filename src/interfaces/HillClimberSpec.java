/**
 * 
 */
package interfaces;

import core.Set;

/**
 * @author Phillipp Ohl
 * @version 0.1
 */
public interface HillClimberSpec {
	void defineInitialState();
	int computeFitnessValue(Set s1, Set s2);
	void startNeighborhoodSearch() throws Exception;
	void computePossibleSolutions() throws Exception;
	void findMinimum();
	void updateSolution(int indexSubsetOne, int indexSubsetTwo) throws Exception;
	void pickRandomSolution();
	int[] getCurrentSolution() throws Exception;
	Set getSubsetOne();
	Set getSubsetTwo();
	int getFitnessValue();
	int[] getPossibleSolutions();
}