package com.globant.users;

public class TeacherPartTime extends Teacher {
    public TeacherPartTime(String name,
                           double baseSalary,
                           int activeHoursWeek)
    {
        super(name,baseSalary,activeHoursWeek);
    }

    @Override
    public double calculateSalary() {
        return baseSalary * activeHoursWeek;
    }

    @Override
    public String toString() {
        return "*************************************\n" +
                "Teacher Part Time: \n"+
                "\nName: "+ name +
                "\nBase Salary: " + baseSalary +
                "\nActive Hours Per Week: " + activeHoursWeek +
                "\nFinal Salary: " + this.calculateSalary() +
                "\n*************************************\n\n\n";
    }
}

