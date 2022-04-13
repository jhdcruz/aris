package com.hci3.aris.data.model;


import android.annotation.SuppressLint;

import androidx.annotation.Nullable;

import java.util.Locale;

public class CourseModel {

    // Course Details
    private String courseCode;
    private String courseName;
    private String courseGpa;
    private int courseUnits;

    // Course Grades
    private double gradePrelim;
    private double gradeMidterm;
    private double gradeFinal;

    // Constructor
    public CourseModel(String courseCode, String courseName, int courseUnits,
                       double gradePrelim, double gradeMidterm, double gradeFinal) {
        this.courseCode = courseCode;
        this.courseName = courseName;
        this.courseUnits = courseUnits;
        this.courseGpa = getCourseGpa();
        this.gradePrelim = gradePrelim;
        this.gradeMidterm = gradeMidterm;
        this.gradeFinal = gradeFinal;
    }

    // Getters
    public String getCourseCode() {
        return courseCode;
    }

    public String getCourseName() {
        return courseName;
    }

    public int getCourseUnits() {
        return courseUnits;
    }

    public String getCourseGpa() {
        double gpa = (gradePrelim + gradeMidterm + gradeFinal) / 3;
        return String.format(Locale.ENGLISH, "%.2f", gpa);
    }

    public double getGradePrelim() {
        return gradePrelim;
    }

    public double getGradeMidterm() {
        return gradeMidterm;
    }

    public double getGradeFinal() {
        return gradeFinal;
    }

    // Setters
    public void setCourseCode(String courseCode) {
        this.courseCode = courseCode;
    }

    public void setCourseName(String courseName) {
        this.courseName = courseName;
    }

    public void setCourseUnits(int courseUnits) {
        this.courseUnits = courseUnits;
    }

    public void setGradePrelim(double gradePrelim) {
        this.gradePrelim = gradePrelim;
    }

    public void setGradeMidterm(double gradeMidterm) {
        this.gradeMidterm = gradeMidterm;
    }

    public void setGradeFinal(double gradeFinal) {
        this.gradeFinal = gradeFinal;
    }

}
