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
	
	private int length;
	private int[] values;
	private int counter;
	
	public Set(int length) {
		this.length = length;
		this.values = new int[100];
		this.counter = 0;
	}

	@Override
	public void calculateSum() {
		// TODO Auto-generated method stub

	}

	@Override
	public int getLength() {
		return length;
	}

	@Override
	public int getRandomMember() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int getSum() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int addValue(int value) {
		values[counter] = value;		
		return counter++;
	}

	public int getValue(int index) {
		return values[index];
	}
}