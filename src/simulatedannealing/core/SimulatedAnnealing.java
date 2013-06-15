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

	private Set parentSet;
	private Set subSetOne;
	private Set subSetTwo;
	private int fitnessValue;
	private int currentSolutionSubsetOne;
	private int currentSolutionSubsetTwo;
	private int[] possibleSolutions;
	private int pending;
	private boolean reachedLocalMinimum;
	private int numberOfRuns;
	private double temperature = 1000;
	private int deltaEnergy;
	private int acceptedValues;
	
	/**
	 * 
	 */
	public SimulatedAnnealing(Set parentSet) {
		this.parentSet = parentSet;
		possibleSolutions = new int[8];
		pending = 0;
		reachedLocalMinimum = true;
		numberOfRuns = 0;
		deltaEnergy = 0;
		acceptedValues = 0;
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
		
		setFitnessValue(subSetOne, subSetTwo);
	}
	
	@Override
	public void setFitnessValue(Set s1, Set s2) {
		// Fitness value = difference between the sums of the sets' values
		fitnessValue = s1.getSum() - s2.getSum();
	}

	@Override
	public int computeFitnessValue(Set s1, Set s2) {
		// Fitness value = difference between the sums of the sets' values
		return s1.getSum() - s2.getSum();
	}

	@Override
	public void startNeighborhoodSearch() throws Exception {
		do {
			computePossibleSolutions();
			if (pending == 90) {
				break;
			}
			printPossibleSolutions();
			findMinimum();
			if (acceptedValues == 25) {
				coolingTemperature();
				acceptedValues = 0;
			}		
		} while(pending < 100);	
	}

	@Override
	public void computePossibleSolutions() throws Exception {
		int counter = 0;
		int loopIndexSubsetOne = 0;
		int loopIndexSubsetTwo = 0;
		
		System.out.println("Current solution: " + fitnessValue);
		
		if (fitnessValue == 0) {
			pending = 100;
			//System.out.println("Current solution is optimal.");
		}
		else {
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
		numberOfRuns++;
	}
	
	// Wahrscheinlichkeit der Übernahme des neuen Zustands.
    // Je höher die Temperatur desto wahrscheinlicher und
    // je kleiner die Energiedifferenz desto wahrscheinlicher.
	private double calculatePossibility(int newEnergy) {
		calculateEnergy(newEnergy);
		double result = Math.pow(Math.E, -deltaEnergy/temperature);
		return result;
	}
	
	// Energieänderung im Vergleich zum vorigen Zustand
	private void calculateEnergy(int newEnergy) {
		deltaEnergy =  newEnergy-fitnessValue;
	}

	@Override
	public void findMinimum() throws Exception {
		int localMinimumIndex = 0;
		int acceptedValueIndex = 0;
		
		reachedLocalMinimum = true;
		
		System.out.println('\n' + "##### Run: " + numberOfRuns + " ######");
		
		for (int i = 0; i < possibleSolutions.length; i++) {		
			if (Math.abs(possibleSolutions[i]) < Math.abs(fitnessValue)) {
				localMinimumIndex = i;
				fitnessValue = possibleSolutions[i];
				reachedLocalMinimum = false;
				System.out.println("Better solution at index " + i + ": " + possibleSolutions[i]);
				pending = 0;
			}
			else {
				if (Math.random() < calculatePossibility(possibleSolutions[i])) {
					acceptedValueIndex = i;	
					acceptedValues++;
					System.out.println("Worse solution at index " + i + " accepted: " + possibleSolutions[i] + " (probability: " + calculatePossibility(possibleSolutions[i]) + ")");				
				}		
			}
		}
		
		pending++;
		
		if (reachedLocalMinimum == true) {
			localMinimumIndex = acceptedValueIndex;
			reachedLocalMinimum = false;
			fitnessValue = possibleSolutions[acceptedValueIndex];
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
	
	public void coolingTemperature() {
		temperature = 0.9*temperature;
	}
	
	public double getTemperature() {
		return temperature;
	}

	@Override
	public void updateSolution(int indexSubsetOne, int indexSubsetTwo) throws Exception {
		int dummySubsetOne = subSetOne.getValue(indexSubsetOne);
		int dummySubsetTwo = subSetTwo.getValue(indexSubsetTwo);
		
		subSetOne.replaceValue(dummySubsetTwo, indexSubsetOne);
		subSetTwo.replaceValue(dummySubsetOne, indexSubsetTwo);
		
		currentSolutionSubsetOne = indexSubsetOne;
		currentSolutionSubsetTwo = indexSubsetTwo;
		setFitnessValue(subSetOne, subSetTwo);
	}

	@Override
	public void pickRandomSolution() {
		currentSolutionSubsetOne = subSetOne.getRandomMember();
		currentSolutionSubsetTwo = subSetTwo.getRandomMember();
	}

	@Override
	public int[] getCurrentSolution() throws Exception {
		int[] resultArray = new int[2];
		resultArray[0] = currentSolutionSubsetOne;
		resultArray[1] = currentSolutionSubsetTwo;
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
	
	public int getPending() {
		return pending;
	}
	
	public boolean getReachedLocalMinimum() {
		return reachedLocalMinimum;
	}
	
	public int getAcceptedValues() {
		return acceptedValues;
	}
	
	public void resetAcceptedValues() {
		acceptedValues = 0;
	}

	@Override
	public void printPossibleSolutions() {
		for (int i = 0; i < possibleSolutions.length; i++) {
			System.out.println(getPossibleSolutions()[i]);
		}
	}
}