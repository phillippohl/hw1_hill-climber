/**
 * 
 */
package core;

import interfaces.SetSpec;

/**
 * @author Phillipp Ohl
 * @version 0.1
 */
public class Set implements SetSpec {
	
	private int counter;
	private int length;
	private int sum;
	private int[] values;
	boolean refreshed;
	
	public Set(int length) {
		this.counter = 0;
		this.length = length;
		this.sum = 0;
		this.values = new int[100];
		this.refreshed = true;
	}

	@Override
	public void calculateSum() {	
		for (int i = 0; i < length; i++) {
			sum += values[i];
		}
	}

	@Override
	public int getLength() {
		return length;
	}

	@Override
	public int getRandomMember() {
		return values[(int) (Math.random()*length)];
	}

	@Override
	public int getSum() {
		if (this.refreshed == false) {
			refreshSum();
		}
		return sum;
	}

	@Override
	public int addValue(int value) {
		values[counter] = value;		
		this.refreshed = false;
		return counter++;
	}

	@Override
	public int getValue(int index) {
		return values[index];
	}
	
	private void refreshSum() {
		calculateSum();
		this.refreshed = true;
	}
}