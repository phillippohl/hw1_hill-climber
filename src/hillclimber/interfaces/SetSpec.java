package hillclimber.interfaces;

import hillclimber.core.Set;

/**
 * 
 */

/**
 * @author Phillipp Ohl
 * @version 0.2
 */
public interface SetSpec {
	void calculateSum();
	int addValue(int value);
	void replaceValue(int newValue, int index);
	void deleteValue(int index);
	int getLength();
	int getRandomMember();
	int getSum();
	int getValue(int index) throws Exception;
	int[] getValues();
	void refreshSum();
	Set getCopy();
}