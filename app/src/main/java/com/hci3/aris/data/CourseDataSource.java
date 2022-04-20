package com.hci3.aris.data;

import com.hci3.aris.data.model.CourseModel;

import java.util.ArrayList;
import java.util.List;

public class CourseDataSource {

    public List<CourseModel> getCourses() {

        try {
            List<CourseModel> coursesList = new ArrayList<>();

            coursesList.add(new CourseModel("CITE 012", "Introduction to HCI", "Joseph Luken Domingo", "07:30 - 09:30 AM", "Online", 3, 78.25, 88.09, 86.00));
            coursesList.add(new CourseModel("CITE 003", "Computer Programming 3", "Eduardo Rodrigo", "10:30 - 12:30 PM", "Online", 3, 92.25, 91.04, 98.00));
            coursesList.add(new CourseModel("GEC 005", "Purposive Communication", "Jemarjo San Jose", "01:30 - 02:30 PM", "Online", 3, 84.45, 82.48, 81.11));
            coursesList.add(new CourseModel("GEC 001", "Understanding The Self", "Ruby Jean Fabros-Destreilles", "03:00 - 04:00 PM", "Online", 2, 82.32, 88.14, 86.23));

            return coursesList;
        } catch (Exception exception) {
            throw new Error(exception);
        }
    }
}
