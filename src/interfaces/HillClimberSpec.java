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
	void computeFitnessValue(Set s1, Set s2);
	void startNeighborhoodSearch();
	void findMinimum();
	void updateSolution();
	void pickRandomSolution();
	int[] getCurrentSolution();
	Set getSubsetOne();
	Set getSubsetTwo();
	int getFitnessValue();
}