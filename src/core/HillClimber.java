/**
 * 
 */
package core;

import interfaces.HillClimberSpec;

/**
 * @author Phillipp Ohl
 * @version 0.1
 */
public class HillClimber implements HillClimberSpec {
	
	private Set parentSet;
	private Set subSetOne;
	private Set subSetTwo;
	private int currentSolutionSubsetOne;
	private int currentSolutionSubsetTwo;
	private int fitnessValue;
	private int[] possibleSolutions;

	/**
	 * 
	 */
	public HillClimber(Set parentSet) {
		this.parentSet = parentSet;
		possibleSolutions = new int[7];
	}

	@Override
	public void defineInitialState() {
		subSetOne = new Set(parentSet.getLength()/2);
		subSetTwo = new Set(parentSet.getLength()/2);
		
		for (int i = 0; i < parentSet.getLength(); i++) {
			int randomNumber = (int) (Math.random()*20+1);
			
			if (i%2 == 0) {
				subSetOne.addValue(randomNumber);
			}
			else {
				subSetTwo.addValue(randomNumber);
			}			
		}
	}
	
	@Override
	public int computeFitnessValue(Set s1, Set s2) {
		// Fitness value = difference between the sums of the sets' values
		this.fitnessValue = s1.getSum() - s2.getSum();
		return s1.getSum() - s2.getSum();
	}

	@Override
	public void startNeighborhoodSearch() {
		computePossibleSolution();
		//findMinimum(lowerSolution, upperSolution);
	}
	
	@Override
	public void computePossibleSolution() {
		//Set newSubSetOne = subSetOne.getCopy();
		//Set newSubSetTwo = subSetTwo.getCopy();

		//updateSolution(newSubSetOne, newSubSetTwo, 0);
	}

	@Override
	public void findMinimum() {
		/*int currentFitness = computeFitnessValue(subSetOne, subSetTwo);
		
		while (true) {
			System.out.println("Current solution: " + currentFitness);
			
			if (currentFitness <= lowerSolutionFitness && currentFitness <= upperSolutionFitness) {
				System.out.println("Current solution is a local minimum.");
				break;
			}
			else if (currentFitness > lowerSolutionFitness) {
				updateSolution(subSetOne, subSetTwo, 0);
			}
			else if (currentFitness > upperSolutionFitness) {
				updateSolution(subSetOne, subSetTwo, 1);
			}
		}*/
	}

	@Override
	public void updateSolution(int indexSubsetOne, int indexSubsetTwo) {
		int dummySubsetOne = subSetOne.getValue(indexSubsetOne);
		int dummySubsetTwo = subSetTwo.getValue(indexSubsetTwo);
		
		subSetOne.replaceValue(dummySubsetTwo, indexSubsetOne);
		subSetTwo.replaceValue(dummySubsetOne, indexSubsetTwo);
		
		currentSolutionSubsetOne = subSetOne.getValue(indexSubsetOne);
		currentSolutionSubsetTwo = subSetTwo.getValue(indexSubsetTwo);
		fitnessValue = computeFitnessValue(subSetOne, subSetTwo);
	}
	
	@Override
	public Set getSubsetOne() {
		return subSetOne;
	}

	@Override
	public Set getSubsetTwo() {
		return subSetTwo;
	}

	@Override
	public int getFitnessValue() {
		return fitnessValue;
	}

	@Override
	public void pickRandomSolution() {
		currentSolutionSubsetOne = subSetOne.getRandomMember();
		currentSolutionSubsetTwo = subSetTwo.getRandomMember();
	}

	@Override
	public int[] getCurrentSolution() {
		int[] resultArray = new int[2];
		resultArray[0] = currentSolutionSubsetOne;
		resultArray[1] = currentSolutionSubsetTwo;
		return resultArray;
	}
}