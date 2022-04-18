package com.hci3.aris.data;

import com.hci3.aris.data.model.grades.GradeDetailsContentModel;

import java.util.ArrayList;
import java.util.List;

public class GradeDetailsContentDataSource {

    public List<GradeDetailsContentModel> getContent() {

        try {
            List<GradeDetailsContentModel> gradeDetailsContentList = new ArrayList<>();

            gradeDetailsContentList.add(new GradeDetailsContentModel("Task 1", "10/10", 100.00));
            gradeDetailsContentList.add(new GradeDetailsContentModel("Task 2", "7/10", 70.00));
            gradeDetailsContentList.add(new GradeDetailsContentModel("Task 3", "8/10", 80.00));

            return gradeDetailsContentList;
        } catch (Exception exception) {
            throw new Error(exception);
        }
    }
}
