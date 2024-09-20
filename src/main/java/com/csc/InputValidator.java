package com.csc;

import java.util.Scanner;

public class InputValidator {
    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        int validValue = validateInput(1, 10, "Enter a number between 1 and 10 (or type 'exit' to quit):", "Default value is 5", 5);
        System.out.println("You selected: " + validValue);
        scanner.close(); // Close the scanner
    }

    public static int validateInput(int min, int max, String prompt, String defaultMessage, int defaultValue) {
        while (true) {
            System.out.println(prompt);
            String input = scanner.nextLine().trim();

            if (input.equalsIgnoreCase("exit")) {
                System.out.println("Exiting...");
                System.exit(0);
            } else if (input.isEmpty()) {
                System.out.println(defaultMessage);
                if (confirmDefaultValue()) {
                    return defaultValue;
                }
            }

            try {
                int value = Integer.parseInt(input);
                if (value >= min && value <= max) {
                    return value;
                } else {
                    System.out.println("Please enter a value within the specified bounds (" + min + " to " + max + ").");
                }
            } catch (NumberFormatException e) {
                System.out.println("Invalid input. Please enter a valid number.");
            }
        }
    }

    private static boolean confirmDefaultValue() {
        System.out.print("Do you want to use the default value? (yes/no): ");
        String confirmation = scanner.nextLine().trim();
        return confirmation.equalsIgnoreCase("yes");
    }
}
