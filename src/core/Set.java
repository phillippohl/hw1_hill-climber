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
	
	public Set(int length) {
		this.length = length;
	}

	@Override
	public void calculateSum() {
		// TODO Auto-generated method stub

	}

	@Override
	public void setLength() {
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

}
