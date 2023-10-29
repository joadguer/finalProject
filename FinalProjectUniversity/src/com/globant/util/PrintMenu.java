package com.globant.util;

import com.globant.univeristySystem.Classes;
import com.globant.univeristySystem.University;

import java.util.Scanner;

public class PrintMenu {

    public static void run(Scanner scanner){
        String choice;
        do {
            System.out.println("------------------Menu------------------");
            System.out.println("a. Print all professors with their data");
            System.out.println("b. Print all classes");
            System.out.println("c. Create a new student and add it to an existing class");
            System.out.println("d. Create a new class and add an existing teacher and students");
            System.out.println("e. List all classes for a given student");
            System.out.println("f. Exit");

            System.out.print("Enter your choice: ");

            choice = scanner.nextLine();

            switch (choice) {
                case "a":
                    MenuOptions.printTeacher();
                    break;
                case "b":
                    MenuOptions.printAllClass();
                    SubMenu.printSubMenu(scanner);
                    break;
                case "c":
                    MenuOptions.addStToClass(scanner);
                    break;
                case "d":
                    Classes.createNewClass();
                    break;
                case "e":
                    University.l_ClassByIdStudent();
                    break;
                case "f":
                    System.out.println("Exiting program...");
                    break;
                default:
                    System.out.println("Invalid choice. Please enter a valid option.");
            }
        } while (!choice.equals("f"));
    }

}
