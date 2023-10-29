package com.globant.util;

import com.globant.univeristySystem.University;

import java.util.Scanner;

public class SubMenu {
    public static void printSubMenu(Scanner scanner){
        String subChoice;
        do{
            System.out.println("a. Select a Class");
            System.out.println("b. Exit submenu");
            subChoice = scanner.nextLine();
            switch (subChoice){
                case "a":
                    System.out.print("Enter the number of the class to show the detail information: ");
                    int classIndex = scanner.nextInt()-1;
                    scanner.nextLine();
                    if((0 <= classIndex) && classIndex < University.getClasses().size()) {
                        System.out.printf("Class %s selected\n", University.getClasses().get(classIndex).getName());
                        System.out.println("1. Show all info");
                        System.out.println("2. Show Students ");
                        System.out.println("3. Show Teacher");
                        System.out.println("4. Show Classroom");
                        System.out.println("5. Exit");
                        String finalChoice = scanner.nextLine();
                        switch (finalChoice){
                            case "1":
                                System.out.println(University.getClasses().get(classIndex));
                                break;
                            case "2":
                                System.out.println(University.stringArraySt(University.getClasses().get(classIndex).getStudents()));
                                break;
                            case "3":
                                System.out.println(University.getClasses().get(classIndex).getTeacher());
                                break;
                            case "4":
                                System.out.println(University.getClasses().get(classIndex).getClassroom());
                                break;
                            case "5":
                                break;
                            default:
                                System.out.println("Not an option");
                        }
                    }
                    break;
                case "b":
                    System.out.println("Exiting...");
                    break;
                default:
                    System.out.println("Not an option");
            }
        }while(!subChoice.equals("b"));
    }
}
