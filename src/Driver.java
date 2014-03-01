import java.util.Arrays;
import java.util.Scanner;

/**
 * Football Score Combinations (FSC)
 * 
 * This program will calculate all possible combinations of scoring to achieve 
 * the given total in a football game.
 */

/**
 * Driver is the entry point of the program and provides the console UI.
 * 
 * @author Jon Henrich
 * 
 */
public class Driver {

	/**
	 * Constructor.
	 */
	public Driver() {

	}

	/**
	 * Start.
	 * 
	 * @param args
	 */
	public static void main(String[] args) {
		// Get the possible score values.

		System.out.println("Running...\n");
		{
			System.out.println("Football Score Combinations (FSC)\n\n"
					+ "This program will calculate all possible "
					+ "combinations of scoring \nto achieve the given total "
					+ "in a football game.\n");

			boolean validInput = false;
			int total = 0;
			Scanner scanIn = new Scanner(System.in);

			// Ask user for a total to solve
			do {
				System.out.println("Please enter a number: "
						+ "(Type 'exit' to end the program)");
				String input;
				input = scanIn.nextLine();

				if (input.equals("exit")) {
					scanIn.close(); // Close the Scanner
					validInput = true;
				} else {
					try {
						total = Integer.parseInt(input);

						Driver driver = new Driver();
						driver.football(total);
					} catch (NumberFormatException e) {
						validInput = false;
						System.out.println("Invalid number.");
					}
				}
			} while (!validInput);

			scanIn.close(); // Close the Scanner
		}
		System.out.println("\nDone.");
	}

	/**
	 * Runs the scenario for football scores.
	 * 
	 * @param total
	 *            - Number to total scores to.
	 */
	public void football(int total) {
		Solver.n = 0;
		ValueSystem vs = new FootballValueSystem();

		runScenario(total, vs);
	}

	/**
	 * Runs the scenario for coin counting. Used for testing.
	 * 
	 * @param total
	 *            - Number to total values to.
	 */
	public void coins(int total) {
		Solver.n = 0;
		ValueSystem vs = new CoinValueSystem();

		runScenario(total, vs);
	}

	/**
	 * Runs a scenario based on the value system given.
	 * 
	 * @param total
	 *            - Total to sum to.
	 * @param V
	 *            - Value System to be used.
	 */
	public void runScenario(int total, ValueSystem V) {
		// Reset the counter
		Solver.n = 0;

		// Get the values specific to the system
		Integer[] values = V.getValuesArray();

		// Create an array for occurrences per value (per Nth possibility)
		Integer[] temp = new Integer[values.length];

		// Sort in ascending order
		Arrays.sort(values);

		// Display the goal (total)
		System.out.println("Goal: " + total + "\n");

		// Display the fixed values in the system
		System.out.println("Values");

		for (Integer v : values) {
			System.out.print(v + "\t");
		}
		System.out.println("N\t\n");

		// Solve the system
		Solver.solve(values, total, (values.length - 1), temp);

		// Display the number of possible combinations (N)
		System.out.println("\nTotal: " + Solver.n + " possibilities\n");
	}
}
