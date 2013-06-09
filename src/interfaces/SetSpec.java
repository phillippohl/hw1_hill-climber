package interfaces;

import core.Set;

/**
 * 
 */

/**
 * @author Phillipp Ohl
 * @version 0.1
 */
public interface SetSpec {
	void calculateSum();
	int addValue(int value);
	void replaceValue(int newValue, int index);
	void deleteValue(int index);
	int getLength();
	int getRandomMember();
	int getSum();
	int getValue(int index);
	int[] getValues();
	Set getCopy();
	int getCurrentValueIndex();
	int getLowerNeighbor() throws Exception;
	int getUpperNeighbor() throws Exception;
}