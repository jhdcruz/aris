package com.hci3.aris.data;

import com.hci3.aris.data.model.grades.GradeDetailsCardModel;

import java.util.ArrayList;
import java.util.List;

public class GradeDetailsCardDataSource {

    public List<GradeDetailsCardModel> getDetails() {

        try {
            List<GradeDetailsCardModel> gradeDetailsList = new ArrayList<>();
            GradeDetailsContentDataSource gradeContentList = new GradeDetailsContentDataSource();

            gradeDetailsList.add(new GradeDetailsCardModel("Activities", 90.00, gradeContentList.getContent()));
            gradeDetailsList.add(new GradeDetailsCardModel("Assignments", 90.00, gradeContentList.getContent()));
            gradeDetailsList.add(new GradeDetailsCardModel("Quizzes", 90.00, gradeContentList.getContent()));
            gradeDetailsList.add(new GradeDetailsCardModel("Recitations", 90.00, gradeContentList.getContent()));

            return gradeDetailsList;
        } catch (Exception exception) {
            throw new Error(exception);
        }
    }
}
