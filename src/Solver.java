/**
 * Solves a given system of values to find all possible combinations of values,
 * excluding duplicate combinations in a different order.
 * 
 * @author Jon Henrich
 * 
 */
public class Solver {

	/**
	 * Number of combinations (N).
	 */
	public static int n = 0;

	/**
	 * Private Constructor. Class is meant to be used statically.
	 */
	private Solver() {

	}

	/**
	 * Solve the total for the given value system. Finds all possible
	 * combinations of the value system to equal the total.
	 * 
	 * @param values
	 *            - Array of designated values.
	 * @param total
	 *            - The total each combination must sum to.
	 * @param index
	 *            - Index of current value in the system.
	 * @param occurrences
	 *            - Number of occurrences per value.
	 */
	public static void solve(Integer[] values, int total, int index,
			Integer[] occurrences) {
		if (index >= 0) {
			int remaining = 0;
			int value = values[index]; // Get the current fixed value

			if (index == 0) { // If this is the last (smallest) value...
				// Take the remaining total and reduce it to increments
				// of the current value
				remaining = total / value;

				if ((remaining * value) != total) {
					// Do Nothing. The combination doesn't sum to the goal.
				} else {
					n++;
					// It sums to the goal. Add it to the list.
					occurrences[index] = remaining; // occurrences of the value

					for (Integer c : occurrences) {
						System.out.print(c + "\t");
					}
					System.out.print("#" + n);
					System.out.println("");
				}
			} else {// There is still a smaller value, move on to that one
				for (int i = 0; i <= total / value; i++) {
					remaining = total - (i * value);

					occurrences[index] = i;
					solve(values, remaining, index - 1, occurrences);
				}
			}
		}
	}

	/**
	 * Solution ported from a <strong>C++</strong> example. Used for testing
	 * purposes.
	 */
	public static void cPlusPlusVersion() {
		int total = 100;
		int combos = 0;

		System.out.println("Goal: " + total);
		// System.out.println("Q\tD\tN\tP");
		System.out.println("P\tN\tND\tQ");

		for (int q = 0; q <= total / 25; q++) {
			int totalLessQ = total - q * 25;

			for (int d = 0; d <= totalLessQ / 10; d++) {
				int totalLessQD = totalLessQ - d * 10;

				for (int n = 0; n <= totalLessQD / 5; n++) {
					int p = totalLessQD - n * 5;
					// System.out.println(q + "\t" + d + "\t" + n + "\t" + p);
					System.out.println(p + "\t" + n + "\t" + d + "\t" + q);
					combos++;
				}
			}
		}
		System.out.println("");
		System.out.println(combos + " combinations...");
	}

}
