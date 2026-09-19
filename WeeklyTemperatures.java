import java.util.ArrayList;
import java.util.Scanner;

public class WeeklyTemperatures {

    public static void main(String[] args) {

        // Create Scanner object for user input
        Scanner scanner = new Scanner(System.in);

        // Create an ArrayLists for the days of the week and their temperatures
        ArrayList<String> days = new ArrayList<String>();
        ArrayList<Double> temperatures = new ArrayList<Double>();

        // Store the days of the week (E.X. Monday through Sunday)
        days.add("Monday");
        days.add("Tuesday");
        days.add("Wednesday");
        days.add("Thursday");
        days.add("Friday");
        days.add("Saturday");
        days.add("Sunday");

        // Store the corresponding average temperatures
        temperatures.add(67.3);
        temperatures.add(69.8);
        temperatures.add(67.1);
        temperatures.add(70.4);
        temperatures.add(64.3);
        temperatures.add(78.9);
        temperatures.add(69.9);

        // Ask the user for an input for a day or the week
        System.out.println("Weekly Temperature Program");
        System.out.println("--------------------------");
        System.out.println("Enter a day of the week (E.X. Monday through Sunday)");
        System.out.print("or enter \"week\" to display the entire week's temperatures: ");

        String userInput = scanner.nextLine().trim();

        // Check if the user wants the entire week
        if (userInput.equalsIgnoreCase("week")) {

            double totalTemperature = 0.0;

            System.out.println("\nWeekly Temperatures");
            System.out.println("-------------------");

            // Loop through both ArrayLists
            for (int i = 0; i < days.size(); i++) {

                System.out.printf(
                    "%s: %.1f degrees F%n",
                    days.get(i),
                    temperatures.get(i)
                );

                totalTemperature += temperatures.get(i);
            }

            // Calculate the weekly average temperature
            double weeklyAverage =
                    totalTemperature / temperatures.size();

            System.out.printf(
                "%nWeekly Average Temperature: %.2f degrees F%n",
                weeklyAverage
            );

        } else {

            boolean dayFound = false;

            // Search through the days ArrayList
            for (int i = 0; i < days.size(); i++) {

                if (days.get(i).equalsIgnoreCase(userInput)) {

                    System.out.printf(
                        "%n%s: %.1f degrees F%n",
                        days.get(i),
                        temperatures.get(i)
                    );

                    dayFound = true;
                    break;
                }
            }

            // Display an error if the day was not found within the listed days
            if (!dayFound) {

                System.out.println(
                    "\nInvalid entry. Please enter Monday through Sunday or \"week\"."
                );
            }
        }

        scanner.close();
    }
}