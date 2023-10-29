package com.globant.users;

import java.util.Scanner;

public class Student {
    private String name;
    private int id;
    private int age;

    public Student(String name, int id, int age) {
        this.name = name;
        this.id = id;
        this.age = age;
    }

    public String getName() { return name; }

    public int getId() {
        return id;
    }

    public static Student createNewStudent(){
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter the name of the new student:");
        String name = scanner.nextLine();

        System.out.println("Enter the student ID: ");
        int studentId = scanner.nextInt();
        scanner.nextLine();

        System.out.println("Enter the age of the new student: ");
        int age = scanner.nextInt();
        scanner.nextLine();

        Student newStudent = new Student(name, studentId, age);

        //methods to get all the student and add it to the list

        return newStudent;

    }

    @Override
    public String toString() {
        return "-----------Student-----------\n" +
                "\nName: " + name +
                "\nID: " + id +
                "\nAge: " + age + "\n\n\n";
    }
}
