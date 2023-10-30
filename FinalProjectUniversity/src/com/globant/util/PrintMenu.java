package com.globant.util;

import com.globant.university.Klass;
import com.globant.university.University;

import java.util.Scanner;

public class PrintMenu {

    public static void run(Scanner scanner){
        String choice;
        do {

            Menu.printM();

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
                    Klass.createNewClass();
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
