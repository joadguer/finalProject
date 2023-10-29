package com.globant;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;
import com.globant.universitySystem.*;
import com.globant.users.*;
import com.globant.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Initialize data
        //Teachers
        Teacher teacher1 = new TeacherFullTime("John Doe", 5000, 5, 40);
        Teacher teacher2 = new TeacherFullTime("Jane Smith", 4000, 0, 40);

        Teacher teacher3 = new TeacherPartTime("John Doe", 50, 20);
        Teacher teacher4 = new TeacherPartTime("Jane Smith", 40, 20);

        //Students
        Student student1 = new Student("Alice Johnson", 1, 20);
        Student student2 = new Student("Bob Williams", 2, 22);
        Student student3 = new Student("Juanito Alcachofa", 3, 21);
        Student student4 = new Student("David Lee", 4, 23);
        Student student5 = new Student("Eva Davis", 5, 22);
        Student student6 = new Student("Juan Richar", 21, 19);

        //Group of Students:
        ArrayList<Student> students = new ArrayList<>();
        Collections.addAll(students, student1, student2,student3,student4);

        ArrayList<Student> students2 = new ArrayList<>();
        Collections.addAll(students2,student5,student6);

        ArrayList<Student> students3 = new ArrayList<>();
        Collections.addAll(students3, student1, student2);

        //Classes
        Classes class1 = new Classes("Math", "Room 101", teacher1, students);
        Classes class2 = new Classes("Physics", "Room 202", teacher2, students3);

        Classes class3 = new Classes("Biology", "Room 103", teacher3, students2);
        Classes class4 = new Classes("Music", "Room 204", teacher4, students3);

        //Adding data to Unieversity
        University.addStudents(student1,student2,student3,student4,student5,student6);
        University.addTeachers(teacher1, teacher2,teacher3, teacher4);
        University.addClasses(class1, class2, class3, class4);

        // Menu
        PrintMenu.run(scanner);
    }
}