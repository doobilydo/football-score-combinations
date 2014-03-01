import java.util.ArrayList;

/**
 * Implements a value system for American Football.
 * 
 * @author Jon Henrich
 * 
 */
public class FootballValueSystem implements ValueSystem {

	/**
	 * Value of a Safety.
	 */
	public final Integer SAFETY = 2;
	/**
	 * Value of a Field Goal.
	 */
	public final Integer FIELD_GOAL = 3;
	/**
	 * Value of a Kick. Only possible if paired with a Touchdown.
	 */
	private final Integer KICK = 1;
	/**
	 * Value of a Two-point Conversion. Only possible if paired with a
	 * Touchdown.
	 */
	private final Integer TWO_POINT_CONVERSION = 2;
	/**
	 * Represents the value of a <strong>Touchdown</strong> being scored.
	 */
	public final Integer TOUCHDOWN = 6;
	/**
	 * Represents the value of <em>both</em> a <strong>Touchdown</strong> and a
	 * <strong>Kick</strong> being scored.
	 */
	public final Integer TD_WITH_EXTRA_ONE = TOUCHDOWN + KICK;
	/**
	 * Represents the value of <em>both</em> a <strong>Touchdown</strong> and a
	 * <strong>Two-point Conversion</strong> being scored.
	 */
	public final Integer TD_WITH_EXTRA_TWO = TOUCHDOWN + TWO_POINT_CONVERSION;

	/**
	 * Constructor.
	 */
	public FootballValueSystem() {
		setValues();
	}

	@Override
	public void setValues() {
		values.clear(); // Reset the list
		values.add(SAFETY);
		values.add(FIELD_GOAL);
		values.add(TOUCHDOWN);
		values.add(TD_WITH_EXTRA_ONE);
		values.add(TD_WITH_EXTRA_TWO);
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
