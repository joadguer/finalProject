package com.globant.util;

import com.globant.university.Klass;
import com.globant.university.University;
import com.globant.users.Student;
import com.globant.users.Teacher;

import java.util.Scanner;

public class MenuOptions {
    public static void printTeacher() {
        for(Teacher teacher: University.getTeachers()) { System.out.println(teacher); }
    }

    public static void printAllClass(){
        System.out.println("University Classes:");
        int i = 1;
        for(Klass clss: University.getClasses())
        {
            System.out.println(i+".- "+ clss.getName());
            i++;
        }
    }

    //menu for adding an existing student
    public static void addStToClass(Scanner scanner){
        Student studentToAdd = Student.createNewStudent();
        //adding a new student to the class
        System.out.println("Enter the name of the class to enroll the student:");
        String klassName = scanner.nextLine();
        for(Klass klass: University.getClasses()){
            if (klass.getName().equals(klassName)){
                klass.addStudent(studentToAdd);
                System.out.println("Student Added Successfully");
                break; //in case there is only one className
            }
        }
    }
}
