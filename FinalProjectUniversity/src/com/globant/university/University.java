package com.globant.university;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;
import com.globant.users.Teacher;
import com.globant.users.Student;


public class University {
    private static ArrayList<Student> students = new ArrayList<>();
    private static ArrayList<Teacher> teachers = new ArrayList<>();
    private static ArrayList<Klass> klasses = new ArrayList<>();

    public static ArrayList<Student> getStudents() {
        return students;
    }

    public static ArrayList<Teacher> getTeachers() {
        return teachers;
    }

    public static ArrayList<Klass> getClasses(){ return klasses; }

    public static void l_ClassByIdStudent() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter the id of the student: ");
        int id;
        try {
            id = scanner.nextInt();

            scanner.nextLine();
            ArrayList<Klass> l_classes = new ArrayList<>();

            for (Klass klass : klasses) {
                for (Student student : klass.getStudents()) {
                    if (student.getId() == id) {
                        l_classes.add(klass);
                    }
                }
            }

            if (l_classes.size() != 0) {
                int i = 1;
                for (Klass klass : l_classes) {
                    System.out.println((i) + ". " + klass.getName() + "\t" + klass.getClassroom());
                    i++;
                }
            }else { System.out.println("There is no classes for this id"); }
        }catch(Exception e){
            System.out.println("Id is not valid");
        }

    }

    public static StringBuilder stringArraySt(ArrayList<Student> students) {
        StringBuilder sb = new StringBuilder();
        if(students != null)
            for (Student st : students) { sb.append(st); }
        else
            sb.append("There is not Students");
        return sb;
    }

    public static void addTeachers(Teacher... teachersToAdd) {
        Collections.addAll(teachers, teachersToAdd);
    }
    public static void addStudents(Student... StudentsToAdd) {
        Collections.addAll(students, StudentsToAdd);
    }
    public static void addClasses(Klass... klassToAdd) {
        Collections.addAll(klasses, klassToAdd);
    }
}
