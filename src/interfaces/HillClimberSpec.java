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
	void startNeighborhoodSearch();
	void findMinimum();
	void updateSolution(int indexSubsetOne, int indexSubsetTwo);
	void pickRandomSolution();
	int[] getCurrentSolution();
	Set getSubsetOne();
	Set getSubsetTwo();
	int getFitnessValue();
	void computePossibleSolution();
}