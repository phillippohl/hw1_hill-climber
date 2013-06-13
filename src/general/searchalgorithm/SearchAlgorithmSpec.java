/**
 * 
 */
package general.searchalgorithm;

import general.set.Set;

/**
 * @author Phillipp Ohl
 * @version 0.1
 */
public interface SearchAlgorithmSpec {
	void defineInitialState();
	void pickRandomSolution();
	int computeFitnessValue(Set s1, Set s2);
	void startNeighborhoodSearch() throws Exception;
	void computePossibleSolutions() throws Exception;
	void findMinimum() throws Exception;
	void updateSolution(int indexSubsetOne, int indexSubsetTwo) throws Exception;
	Set getSubsetOne();
	Set getSubsetTwo();
	int[] getCurrentSolution() throws Exception;
	int getFitnessValue();
	int[] getPossibleSolutions();
	void printPossibleSolutions();
}