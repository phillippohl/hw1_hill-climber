/**
 * 
 */
package core;

import interfaces.SetSpec;

/**
 * @author Phillipp Ohl
 * @version 0.2
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
		this.values = new int[length];
		this.refreshed = true;
	}
	
	@Override
	public void calculateSum() {	
		for (int i = 0; i < length; i++) {
			sum += values[i];
		}
	}
	
	@Override
	public int addValue(int value) {
		values[counter] = value;		
		this.refreshed = false;
		return counter++;
	}

	@Override
	public void replaceValue(int newValue, int index) {		
		values[index] = newValue;
		this.refreshed = false;
	}

	@Override
	public void deleteValue(int index) {
		while(index < counter) {
			values[index] = values[index+1];
			index++;
		}
		counter--;
		this.refreshed = false;
	}

	@Override
	public int getLength() {
		return length;
	}

	@Override
	public int getRandomMember() {
		return (int) (Math.random()*length);
	}
	
	@Override
	public int getSum() {
		if (this.refreshed == false) {
			refreshSum();
		}
		return sum;
	}
	
	@Override
	public int getValue(int index) throws Exception {
		if (index >= values.length) {
			System.out.println("Current solution has no upper neighbor.");
			return values[index-1];
		}
		if (index < 0) {
			System.out.println("Current solution has no lower neighbor.");
			return values[0];
		}
		return values[index];
	}
	
	@Override
	public int[] getValues() {
		return this.values;
	}
	
	@Override
	public void refreshSum() {
		sum = 0;
		calculateSum();
		this.refreshed = true;
	}

	@Override
	public Set getCopy() {
		Set copy = new Set(this.length);
		copy.counter = this.counter;
		copy.length = this.length;
		copy.sum = this.sum;
		copy.values = this.values.clone();
		copy.refreshed = this.refreshed;
		return copy;
	}
}