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
	
	public Set(int length) {
		this.counter = 0;
		this.length = length;
		this.sum = 0;
		this.values = new int[100];
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
		return sum;
	}

	@Override
	public int addValue(int value) {
		values[counter] = value;		
		return counter++;
	}

	@Override
	public int getValue(int index) {
		return values[index];
	}
}