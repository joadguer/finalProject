package com.globant;
import java.util.ArrayList;
import java.util.Scanner;
import com.globant.univeristySystem.University;
import com.globant.users.Teacher;
import com.globant.users.TeacherFullTime;
import com.globant.users.TeacherPartTime;
import com.globant.users.Student;
import com.globant.univeristySystem.Classes;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        //cambiar constructor a privado

        // Initialize data
        Teacher teacher1 = new TeacherFullTime("John Doe", 5000, 5, 40);
        Teacher teacher2 = new TeacherFullTime("Jane Smith", 4000, 0, 40);

        Teacher teacher3 = new TeacherPartTime("John Doe", 50, 20);
        Teacher teacher4 = new TeacherPartTime("Jane Smith", 40, 20);

        University.getTeachers().add(teacher1);
        University.getTeachers().add(teacher2);
        University.getTeachers().add(teacher3);
        University.getTeachers().add(teacher4);

        Student student1 = new Student("Alice Johnson", 1, 20);
        Student student2 = new Student("Bob Williams", 2, 22);
        Student student3 = new Student("Juanito Alcachofa", 3, 21);
        Student student4 = new Student("David Lee", 4, 23);
        Student student5 = new Student("Eva Davis", 5, 22);
        Student student6 = new Student("Juan Richar", 21, 19);

        University.getStudents().add(student1);
        University.getStudents().add(student2);
        University.getStudents().add(student3);
        University.getStudents().add(student4);
        University.getStudents().add(student5);
        University.getStudents().add(student6);


        ArrayList<Student> students = new ArrayList<>();
        students.add(student1);
        students.add(student2);
        students.add(student3);
        students.add(student4);

        ArrayList<Student> students2 = new ArrayList<>();
        students2.add(student5);
        students2.add(student6);

        ArrayList<Student> students3 = new ArrayList<>();
        students3.add(student1);
        students3.add(student2);


        Classes class1 = new Classes("Math", "Room 101", teacher1, students);
        Classes class2 = new Classes("Physics", "Room 202", teacher2, students3);

        Classes class3 = new Classes("Biology", "Room 103", teacher3, students2);
        Classes class4 = new Classes("Music", "Room 204", teacher4, students3);


        University.getClasses().add(class1);
        University.getClasses().add(class2);
        University.getClasses().add(class3);
        University.getClasses().add(class4);



        // Menu
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
                    for(Teacher teacher: University.getTeachers())
                    {
                        System.out.println(teacher);
                    }
                    break;
                case "b":
                    System.out.println("University.Classes:");
                    int i = 1;
                    for(Classes clss: University.getClasses())
                    {
                        System.out.println(i+".- "+ clss.getName());
                        i++;
                    }
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
                    break;
                case "c":
                    Student studentToAdd = Student.createNewStudent();
                    //adding a new student to the class
                    System.out.println("Enter the name of the class to enroll the student:");
                    String klassName = scanner.nextLine();
                    for(Classes klass: University.getClasses()){
                        if (klass.getName().equals(klassName)){
                            klass.addStudent(studentToAdd);
                            System.out.println("Student Added Successfully");
                            break; //in case there is only one className
                        }
                    }
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