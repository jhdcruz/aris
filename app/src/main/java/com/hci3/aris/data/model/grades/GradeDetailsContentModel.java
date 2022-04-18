package com.hci3.aris.data.model.grades;

import java.util.Locale;

public class GradeDetailsContentModel {
    private final String task;
    private final String score;
    private final double grade;

    public GradeDetailsContentModel(String task, String score, double grade) {
        this.task = task;
        this.score = score;
        this.grade = grade;
    }

    public String getGrade() {
        return String.format(Locale.US, "%.2f", grade);
    }

    public String getTask() {
        return task;
    }

    public String getScore() {
        return score;
    }
}
