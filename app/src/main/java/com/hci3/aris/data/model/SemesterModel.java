package com.hci3.aris.data.model;

import java.util.Locale;

public class SemesterModel {

    private String semester;
    private String school_year;
    private double semGpa;
    private int unitsEarned;
    private int unitsEnrolled;
    private int courseCount;

    public SemesterModel(String semester, String schoolYear, double semGpa, int semUnits,
                         int semTotal, int courses) {
        this.semester = semester;
        this.school_year = schoolYear;
        this.semGpa = semGpa;
        this.unitsEarned = semUnits;
        this.unitsEnrolled = semTotal;
        this.courseCount = courses;
    }

    public String getSemester() {
        return semester;
    }

    public String getSchoolYear() {
        return school_year;
    }

    public double getSemGpa() {
        return Double.parseDouble(String.format(Locale.ENGLISH, "%.2f", semGpa));
    }

    public int getUnitsEarned() {
        return unitsEarned;
    }

    public int getUnitsEnrolled() {
        return unitsEnrolled;
    }

    public int getCourseCount() {
        return courseCount;
    }
}
