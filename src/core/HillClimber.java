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
	private int fitnessValue;
	private int currentSolutionSubsetOne;
	private int currentSolutionSubsetTwo;
	private int[] possibleSolutions;

	/**
	 * 
	 */
	public HillClimber(Set parentSet) {
		this.parentSet = parentSet;
		possibleSolutions = new int[8];
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
	public void startNeighborhoodSearch() throws Exception {
		computePossibleSolutions();
		findMinimum();
	}
	
	@Override
	public void computePossibleSolutions() throws Exception {
		int counter = 0;
		int loopIndexSubsetOne = 0;
		int loopIndexSubsetTwo = 0;
						
		for (int i = -1; i <= 1; i++) {
			loopIndexSubsetOne = currentSolutionSubsetOne + i;
			
			for (int j = -1; j <= 1; j++) {
				if (i == 0 && j == 0) {
					continue;
				}
				else {			
					loopIndexSubsetTwo = currentSolutionSubsetTwo + j;					
					possibleSolutions[counter] = computeFitnessValue(subSetOne, subSetTwo)-2*(subSetOne.getValue(loopIndexSubsetOne) - subSetTwo.getValue(loopIndexSubsetTwo));
					counter++;
				}			
			}
		}
	}

	@Override
	public void findMinimum() throws Exception {
		int localMinimumIndex = 0;
		System.out.println("Current solution: " + fitnessValue);
		for (int i = 0; i < possibleSolutions.length; i++) {		
			if (possibleSolutions[i] < fitnessValue) {
				localMinimumIndex = i;
				fitnessValue = possibleSolutions[i];
				System.out.println("Better solution at index " + i + ": " + possibleSolutions[i]);
			}
		}
		
		switch (localMinimumIndex) {
		case 0:
			updateSolution(currentSolutionSubsetOne-1, currentSolutionSubsetTwo-1);
			break;
		case 1:
			updateSolution(currentSolutionSubsetOne-1, currentSolutionSubsetTwo);
			break;
		case 2:
			updateSolution(currentSolutionSubsetOne-1, currentSolutionSubsetTwo+1);
			break;
		case 3:
			updateSolution(currentSolutionSubsetOne, currentSolutionSubsetTwo-1);
			break;
		case 4:
			updateSolution(currentSolutionSubsetOne, currentSolutionSubsetTwo+1);
			break;
		case 5:
			updateSolution(currentSolutionSubsetOne+1, currentSolutionSubsetTwo-1);
			break;
		case 6:
			updateSolution(currentSolutionSubsetOne+1, currentSolutionSubsetTwo);
			break;
		case 7:
			updateSolution(currentSolutionSubsetOne+1, currentSolutionSubsetTwo+1);
			break;
		default:
			break;
		}	
	}

	@Override
	public void updateSolution(int indexSubsetOne, int indexSubsetTwo) throws Exception {
		int dummySubsetOne = subSetOne.getValue(indexSubsetOne);
		int dummySubsetTwo = subSetTwo.getValue(indexSubsetTwo);
		
		subSetOne.replaceValue(dummySubsetTwo, indexSubsetOne);
		subSetTwo.replaceValue(dummySubsetOne, indexSubsetTwo);
		
		currentSolutionSubsetOne = indexSubsetOne;
		currentSolutionSubsetTwo = indexSubsetTwo;
		fitnessValue = computeFitnessValue(subSetOne, subSetTwo);
	}

	@Override
	public void pickRandomSolution() {
		currentSolutionSubsetOne = subSetOne.getRandomMember();
		currentSolutionSubsetTwo = subSetTwo.getRandomMember();
	}
	
	public void setRandomSolution(int indexSolutionSubsetOne, int indexSolutionSubsetTwo) {
		currentSolutionSubsetOne = indexSolutionSubsetOne;
		currentSolutionSubsetTwo = indexSolutionSubsetTwo;
	}

	@Override
	public int[] getCurrentSolution() throws Exception {
		int[] resultArray = new int[2];
		resultArray[0] = subSetOne.getValue(currentSolutionSubsetOne);
		resultArray[1] = subSetTwo.getValue(currentSolutionSubsetTwo);
		return resultArray;
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
	public int[] getPossibleSolutions() {
		return possibleSolutions;
	}
}