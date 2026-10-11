import java.util.ArrayList;
import java.util.Scanner;

public class WeeklyTemperatures {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        // Create ArrayLists for days and temperatures
        ArrayList<String> days = new ArrayList<String>();
        ArrayList<Double> temperatures = new ArrayList<Double>();

        // Store days of the week
        days.add("Monday");
        days.add("Tuesday");
        days.add("Wednesday");
        days.add("Thursday");
        days.add("Friday");
        days.add("Saturday");
        days.add("Sunday");

        // Store corresponding average temperatures
        temperatures.add(87.4);
        temperatures.add(96.5);
        temperatures.add(34.7);
        temperatures.add(38.9);
        temperatures.add(67.5);
        temperatures.add(66.9);
        temperatures.add(71.8);

        System.out.println("===== WEEKLY TEMPERATURE PROGRAM =====");

        String userInput;

        do {
            System.out.print(
                "\nEnter a day, \"week\", or \"exit\": "
            );

            userInput = scanner.nextLine().trim();

            if (userInput.equalsIgnoreCase("week")) {

                // Display all temperatures and statistics
                displayWeeklyTemperatures(days, temperatures);

            } else if (userInput.equalsIgnoreCase("exit")) {

                System.out.println(
                    "\nThank you for using the Weekly Temperature Program."
                );

            } else {

                // Search for the selected day
                displayDailyTemperature(days, temperatures, userInput);
            }

        } while (!userInput.equalsIgnoreCase("exit"));

        scanner.close();
    }

    // Method to display a selected day's temperature
    public static void displayDailyTemperature(
            ArrayList<String> days,
            ArrayList<Double> temperatures,
            String selectedDay) {

        boolean dayFound = false;

        for (int i = 0; i < days.size(); i++) {

            if (days.get(i).equalsIgnoreCase(selectedDay)) {

                System.out.printf(
                    "%n%s: %.1f degrees F%n",
                    days.get(i),
                    temperatures.get(i)
                );

                dayFound = true;
                break;
            }
        }

        if (!dayFound) {
            System.out.println(
                "Invalid entry. Please enter Monday through Sunday, \"week\", or \"exit\"."
            );
        }
    }

    // Method to display all weekly temperatures
    public static void displayWeeklyTemperatures(
            ArrayList<String> days,
            ArrayList<Double> temperatures) {

        System.out.println("\n===== WEEKLY TEMPERATURE RESULTS =====");

        for (int i = 0; i < days.size(); i++) {

            System.out.printf(
                "%-12s %.1f degrees F%n",
                days.get(i) + ":",
                temperatures.get(i)
            );
        }

        // Calculate weekly statistics
        double average = calculateAverage(temperatures);

        int highestIndex = findHighestTemperature(temperatures);
        int lowestIndex = findLowestTemperature(temperatures);

        // Display weekly statistics
        System.out.printf(
            "%nWeekly Average: %.2f degrees F%n",
            average
        );

        System.out.printf(
            "Highest: %s %.1f degrees F%n",
            days.get(highestIndex),
            temperatures.get(highestIndex)
        );

        System.out.printf(
            "Lowest: %s %.1f degrees F%n",
            days.get(lowestIndex),
            temperatures.get(lowestIndex)
        );

        System.out.println("======================================");
    }

    // Method to calculate average weekly temperature
    public static double calculateAverage(
            ArrayList<Double> temperatures) {

        double total = 0;

        for (double temperature : temperatures) {
            total += temperature;
        }

        return total / temperatures.size();
    }

    // Method to find the highest temperature
    public static int findHighestTemperature(
            ArrayList<Double> temperatures) {

        int highestIndex = 0;

        for (int i = 1; i < temperatures.size(); i++) {

            if (temperatures.get(i) >
                    temperatures.get(highestIndex)) {

                highestIndex = i;
            }
        }

        return highestIndex;
    }

    // Method to find the lowest temperature
    public static int findLowestTemperature(
            ArrayList<Double> temperatures) {

        int lowestIndex = 0;

        for (int i = 1; i < temperatures.size(); i++) {

            if (temperatures.get(i) <
                    temperatures.get(lowestIndex)) {

                lowestIndex = i;
            }
        }

        return lowestIndex;
    }
}