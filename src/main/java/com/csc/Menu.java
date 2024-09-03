package com.csc;

import java.util.Scanner;

public class Menu {
    public static int menu(Integer min, Integer max, String prompt, String error) {
        Scanner scanner = new Scanner(System.in);
        while (true) {
            System.out.print(prompt);
            try {
                String inputStr = scanner.nextLine();
                if (inputStr.equalsIgnoreCase("exit")) {
                    System.out.println("Exiting the program.");
                    System.exit(0);
                }
                int input = Integer.parseInt(inputStr);
                boolean valid = true;
                if (min != null && input < min) {
                    valid = false;
                }
                if (max != null && input > max) {
                    valid = false;
                }
                if (valid) {
                    return input;
                } else {
                    System.out.println(error);
                }
            } catch (NumberFormatException e) {
                System.out.println("Invalid input. Please enter a valid integer (or type 'exit' to quit): ");
            }
        }
    }

    public static void main(String[] args) {
        String prompt = "Enter a number (or type 'exit' to quit): ";
        String error = "Number is invalid ";

        int result = Menu.menu(null, null, prompt, error);
        System.out.println("No bounds: " + result);
        result = Menu.menu(null, 10, prompt, error);
        System.out.println("With bounds: " + result);
        result = Menu.menu(0, null, prompt, error);
        System.out.println("With bounds: " + result);
        result = Menu.menu(0, 10, prompt, error);
        System.out.println("With bounds: " + result);
        result = Menu.menu(null, 10, prompt, error);
        System.out.println("With bounds: " + result);
        result = Menu.menu(-10, null, prompt, error);
        System.out.println("With bounds: " + result);
        result = Menu.menu(-10, 5, prompt, error);
        System.out.println("With bounds: " + result);
    }
}

// Your code goes here!
