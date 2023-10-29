package com.globant.users;

public abstract class Teacher {
    protected String name;
    protected double baseSalary;
    protected int activeHoursWeek;

    public Teacher(String name, double baseSalary, int activeHoursWeek) {
        this.name = name;
        this.baseSalary = baseSalary;
        this.activeHoursWeek = activeHoursWeek;
    }

    public abstract double calculateSalary();

    public String getName() {
        return name;
    }
}
