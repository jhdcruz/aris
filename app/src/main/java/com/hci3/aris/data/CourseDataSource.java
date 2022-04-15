package com.hci3.aris.data;

import com.hci3.aris.data.model.CourseModel;

import java.util.ArrayList;
import java.util.List;

public class CourseDataSource {

    public List<CourseModel> getCourses() {

        try {
            List<CourseModel> coursesList = new ArrayList<>();

            coursesList.add(new CourseModel("CITE 012", "Introduction to HCI", 3, 78.25, 88.09, 86.00));
            coursesList.add(new CourseModel("CITE 003", "Computer Programming 3", 3, 92.25, 91.04, 98.00));
            coursesList.add(new CourseModel("GEC 005", "Understanding The Self", 2, 82.32, 88.14, 86.23));
            coursesList.add(new CourseModel("GEC 001", "Purposive Communication", 3, 84.45, 82.48, 81.11));
            coursesList.add(new CourseModel("MATH 025", "Discrete Mathematics", 2, 82.12, 80.21, 86.53));

            return coursesList;
        } catch (Exception exception) {
            throw new Error(exception);
        }
    }
}
