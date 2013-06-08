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
	int pickRandomSolution();
	void computeFitnessValue(Set s1, Set s2);
	void startNeighborhoodSearch();
	void findMinimum();
	void updateSolution();
	Set getSubsetOne();
	Set getSubsetTwo();
}