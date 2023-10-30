package com.globant.university;

import com.globant.users.Student;
import com.globant.users.Teacher;

import java.util.InputMismatchException;
import java.util.Scanner;
import java.util.ArrayList;

public class Klass {
    String name;
    String classroom;
    Teacher teacher;
    ArrayList<Student> students;

    public Klass(String name,
                 String classroom,
                 Teacher teacher,
                 ArrayList<Student> students) {
        this.name = name;
        this.classroom = classroom;
        this.teacher = teacher;
        this.students = students;
    }

    public void addStudent(Student student) {
        students.add(student);
    }

    @Override
    public String toString() {
        return "Name: " + name +
                "\nClassroom: " + classroom +
                "\nTeacher:\n\n" + teacher +
                "\nStudents:\n\n" + stringArraySt(students);
    }

    public static StringBuilder stringArraySt(ArrayList<Student> students) {
        StringBuilder sb = new StringBuilder();
        if (students != null)
            for (Student st : students) {
                sb.append(st);
            }
        else
            sb.append("There is not Students");
        return sb;
    }

    public String getName() {
        return name;
    }

    public String getClassroom() {
        return classroom;
    }

    public Teacher getTeacher() {
        return teacher;
    }

    public ArrayList<Student> getStudents() {
        return students;
    }

    public static void createNewClass() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter the name of the new Class:");
        String className = scanner.nextLine();

        System.out.println("Enter the classroom for the new class:");
        String classroom = scanner.nextLine();

        try {
            //Print existing teachers for selection
            System.out.println("Existing Teachers:");
            for (int i = 0; i < University.getTeachers().size(); i++) {
                System.out.println((i + 1) + ". " + University.getTeachers().get(i).getName());
            }

            Teacher selectedTeacher;
            int teacherIndex;

            System.out.println("Select the Teacher for the new class (enter the corresponding number): ");
            teacherIndex = scanner.nextInt() - 1;
            selectedTeacher = University.getTeachers().get(teacherIndex);

            // Print existing students for selection
            int numStudents;
            do {

                System.out.println("Existing Students:");
                for (int i = 0; i < University.getStudents().size(); i++) {
                    System.out.println((i + 1) + ". " + University.getStudents().get(i).getName());
                }

                System.out.println("Enter the number of students to add to the new class:");
                numStudents = scanner.nextInt();

                if(numStudents < 1 || numStudents > University.getStudents().size()){
                    System.out.println("Number is not Valid");
                }

            } while(numStudents < 1 || numStudents > University.getStudents().size());

            ArrayList<Student> selectedStudents = new ArrayList<>();

            for (int i = 0; i < numStudents; i++) {
                System.out.println("Select Student #" + (i + 1) + " (enter the corresponding number): ");
                int studentIndex = scanner.nextInt() - 1;
                selectedStudents.add(University.getStudents().get(studentIndex));
            }

            Klass newClass = new Klass(className, classroom, selectedTeacher, selectedStudents);
            University.getClasses().add(newClass);

            System.out.println("New class created and added successfully!");


        } catch (IndexOutOfBoundsException e) {
            System.out.println("Number no find in list");
        }catch(NumberFormatException w){
            System.out.println("Not a valid number");
        }catch(InputMismatchException b) {
            System.out.println("The value is not valid");
        }
    }
}
