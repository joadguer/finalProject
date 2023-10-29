package com.globant.users;

public class TeacherFullTime extends Teacher {
    private int experienceYears;
    public TeacherFullTime(String name, double baseSalary, int experienceYears, int activeHoursWeek )
    {
        super(name, baseSalary,activeHoursWeek);
        this.experienceYears = experienceYears;
    }

    @Override
    public double calculateSalary() {
        return (experienceYears >0) ? (baseSalary * 1.1 * experienceYears) : (baseSalary * activeHoursWeek);
    }

    @Override
    public String toString(){
        return "*************************************\n" +
                "Teacher Full Time: \n"+
                "\nName: "+ name +
                "\nExperience Years: " + experienceYears +
                "\nBase Salary: " + baseSalary +
                "\nActive Hours Per Week: " + activeHoursWeek +
                "\nFinal Salary: " + this.calculateSalary() +
                "\n*************************************\n\n\n";

    }
}
