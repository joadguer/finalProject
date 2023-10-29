package com.globant.univeristySystem;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Scanner;
import com.globant.users.Teacher;
import com.globant.users.Student;


public class University {
    private static ArrayList<Student> students = new ArrayList<>();
    private static ArrayList<Teacher> teachers = new ArrayList<>();
    private static ArrayList<Classes> classes = new ArrayList<>();

    public static ArrayList<Student> getStudents() {
        return students;
    }

    public static ArrayList<Teacher> getTeachers() {
        return teachers;
    }

    public static ArrayList<Classes> getClasses(){ return classes; }

    public static void l_ClassByIdStudent() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter the id of the student: ");
        int id= scanner.nextInt();

        scanner.nextLine();
        ArrayList<Classes> l_classes = new ArrayList<>();

        for(Classes klass : classes){
            for(Student student: klass.getStudents()) {
                if(student.getId() == id){
                    l_classes.add(klass);
                }
            }
        }

        if(l_classes.size() != 0){
            int i = 1;
            for(Classes klass : l_classes){
                System.out.println((i)+". "+klass.getName()+"\t"+klass.getClassroom());
                i++;
            }
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
}
