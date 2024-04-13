/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package com.mycompany.login;

/**
 *
 * @author lab_services_student
 */
import java.util.Scanner;
public class Login {
private static String registerUser = null;

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        // Greeting
        System.out.println("\n Registeration \n");

        System.out.println("Good day ! , how are doing today ? - \n");
        String giveanswer = scanner.nextLine();
        System.out.println("\n Good- Please enter all the details acquired from you.\n");

        // Get username
        System.out.print("Enter your desired username: \n");
        String username = scanner.nextLine();

        // Validate username
        if (checkUsername(username)) {
            System.out.println("Username successfully captured.\n");
            showRegistrationMenu(scanner);
        } else {
            System.out.println("\n Username is not correctly formatted.\n");
            TryAgainUsername(scanner);
        }
    }

    public static void TryAgainUsername(Scanner scanner) {
        // Allow the user to try again, when failed 1st attempt
        System.out.print("\n Re-type your username \n");
        String user = scanner.nextLine();
        System.out.println("Enter your password: ");
        String pass = scanner.nextLine();
        registerUser = scanner.nextLine();
        if (registerUser.length() > 5 && checkPasswordComplexity(registerUser)) {
            System.out.println("Username successfully captured.");
        }

        // Get password
        System.out.print("Enter your password: ");
        String password = scanner.nextLine();

        // Validate password
        if (checkPasswordComplexity(password)) {
            System.out.println("Password successfully captured.");
            showRegistrationMenu(scanner);
        } else {
            System.out.println("Password is not correctly formatted.");
        }
    }

    public static void showRegistrationMenu(Scanner scanner) {
        System.out.print("Enter your name: ");
        String name = scanner.nextLine();

        // Allow user to try again
        System.out.print("Enter your student number: ");
        String studentNumber = scanner.nextLine();
        System.out.println("Registration successful!");

        // Validate name and student number (you can customize this logic)
        if (loginUser(name, studentNumber)) {

            System.out.println("Registration successful!");
        }
    }

    public static boolean loginUser(String name, String studentNumber) {
        if (name.length() > 5 && studentNumber.length() == 9) {
            System.out.println("You have registered successfully. Thank you!");
            return true;
        }
        return false;
    }

    // Validate password: at least 8 characters, numbers, and special characters
    public static boolean checkPasswordComplexity(String password) {
        if (password.length() < 8) {
            return false;
        }

        boolean hasDigit = false;
        boolean hasSpecialChar = false;

        for (char c : password.toCharArray()) {
            if (Character.isDigit(c)) {
                hasDigit = true;
            } else if (!Character.isLetterOrDigit(c)) {
                hasSpecialChar = true;
            }
        }
        return hasDigit && hasSpecialChar;
    }

    public static boolean checkUsername(String username) {
        if (hasUnderscore(username)) {
            System.out.println("\n Username has an underscore.\n");
            return true;
        } else {
            System.out.println("Username does not have an underscore.");
            return false;
        }
    }

    public static boolean hasUnderscore(String username) {
        return username.contains("_");
    }
}