package com.hci3.aris.data.model;

import java.util.Locale;

public class CourseModel {

    // Course Details
    private final String courseSection;
    private final String courseCode;
    private final String courseName;
    private final String courseProf;
    private final String courseTime;
    private final String courseSched;
    private final String courseRoom;
    private final String courseCanvasCode;
    private final int courseUnits;

    // Course Grades
    private final double gradePrelim;
    private final double gradeMidterm;
    private final double gradeFinal;

    // Constructor
    public CourseModel(String courseSection, String courseCode, String courseName, String courseProf, String courseTime,
                       String courseSched, String courseRoom, String courseCanvasCode, int courseUnits,
                       double gradePrelim, double gradeMidterm, double gradeFinal) {
        this.courseSection = courseSection;
        this.courseCode = courseCode;
        this.courseName = courseName;
        this.courseProf = courseProf;
        this.courseTime = courseTime;
        this.courseSched = courseSched;
        this.courseRoom = courseRoom;
        this.courseCanvasCode = courseCanvasCode;
        this.courseUnits = courseUnits;
        this.gradePrelim = gradePrelim;
        this.gradeMidterm = gradeMidterm;
        this.gradeFinal = gradeFinal;
    }

    // Getters


    public String getCourseSection() {
        return courseSection;
    }

    public String getCourseCanvasCode() {
        return courseCanvasCode;
    }

    public String getCourseCode() {
        return courseCode;
    }

    public String getCourseName() {
        return courseName;
    }

    public String getCourseProf() {
        return courseProf;
    }

    public String getCourseRoom() {
        return courseRoom;
    }

    public String getCourseTime() {
        return courseTime;
    }

    public String getCourseSched() {
        return courseSched;
    }

    public int getCourseUnits() {
        return courseUnits;
    }

    public String getCourseGpa() {
        double gpa = (gradePrelim + gradeMidterm + gradeFinal) / 3;
        return String.format(Locale.ENGLISH, "%.2f", gpa);
    }

    public String getGradePrelim() {
        return String.format(Locale.ENGLISH, "%.2f", gradePrelim);
    }

    public String getGradeMidterm() {
        return String.format(Locale.ENGLISH, "%.2f", gradeMidterm);
    }

    public String getGradeFinal() {
        return String.format(Locale.ENGLISH, "%.2f", gradeFinal);
    }
}
