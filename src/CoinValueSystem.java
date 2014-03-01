import java.util.ArrayList;

/**
 * Implements a value system for U.S. currency.
 * 
 * @author Jon Henrich
 * 
 */
public class CoinValueSystem implements ValueSystem {

	public final Integer PENNY = 1;
	public final Integer NICKEL = 5;
	public final Integer DIME = 10;
	public final Integer QUARTER = 25;

	// public final Integer ONE_DOLLAR = 100;

	public CoinValueSystem() {
		setValues();
	}

	@Override
	public void setValues() {
		values.clear(); // Reset the list
		values.add(PENNY);
		values.add(NICKEL);
		values.add(DIME);
		values.add(QUARTER);
	}

	@Override
	public ArrayList<Integer> getValuesList() {
		return values;
	}

	@Override
	public Integer[] getValuesArray() {
		Integer[] valuesArray = {};
		return values.toArray(valuesArray);
	}

}
