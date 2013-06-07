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
	Set getSubsetOne();
	Set getSubsetTwo();
	void pickRandomSolution();
	void computeFitnessValue(Set s1, Set s2);
	void startNeighborhoodSearch();
	void findMinimum();
	void updateSolution();
}