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

	/**
	 * 
	 */
	public HillClimber(Set parentSet) {
		this.parentSet = parentSet;
		defineInitialState();
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
	public void computeFitnessValue(Set s1, Set s2) {
		// Fitness value = difference between the sums of the sets' values
		fitnessValue = s1.getSum() - s2.getSum();
	}

	@Override
	public void startNeighborhoodSearch() {
		// TODO Auto-generated method stub

	}

	@Override
	public void findMinimum() {
		// TODO Auto-generated method stub

	}

	@Override
	public void updateSolution() {
		// TODO Auto-generated method stub

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