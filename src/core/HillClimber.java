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
	private Set subSet1;
	private Set subSet2;

	/**
	 * 
	 */
	public HillClimber(Set parentSet) {
		this.parentSet = parentSet;
		defineInitialState();
	}

	@Override
	public void defineInitialState() {
		subSet1 = new Set(parentSet.getLength()/2);
		subSet2 = new Set(parentSet.getLength()/2);
		
		for (int i = 0; i < parentSet.getLength(); i++) {
			int randomNumber = (int) (Math.random()*20+1);
			
			if (i%2 == 0) {
				subSet1.addValue(randomNumber);
			}
			else {
				subSet2.addValue(randomNumber);
			}			
		}
	}
	
	@Override
	public Set getSubsetOne() {
		return subSet1;
	}

	@Override
	public Set getSubsetTwo() {
		return subSet2;
	}

	@Override
	public void pickRandomSolution() {
		// TODO Auto-generated method stub

	}

	@Override
	public void computeFitnessValue(Set s1, Set s2) {
		// TODO Auto-generated method stub

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
}