package com.hci3.aris.data;

import com.hci3.aris.data.model.CourseModel;

import java.util.ArrayList;
import java.util.List;

public class CourseDataSource {

    public List<CourseModel> getCourses() {

        try {
            List<CourseModel> coursesList = new ArrayList<>();

            coursesList.add(new CourseModel("IT12S2", "CITE 012", "Introduction to HCI", "Joseph Luken Domingo", "07:30 - 09:30 AM", "Mon, Wed, Fri", "Online", "31538", 3, 78.25, 88.09, 86.00));
            coursesList.add(new CourseModel("IT12S2", "CITE 003", "Computer Programming 2", "Eduardo Rodrigo", "10:30 - 12:30 PM", "Tue, Thu, Sat", "Online", "28508", 3, 92.25, 91.04, 98.00));
            coursesList.add(new CourseModel("IT12S2", "GEC 005", "Purposive Communication", "Jemarjo San Jose", "01:30 - 02:30 PM", "Mon, Wed, Fri", "Online", "31706", 3, 84.45, 82.48, 81.11));
            coursesList.add(new CourseModel("IT12S2", "GEC 001", "Understanding The Self", "Ruby Jean Fabros-Destreilles", "03:00 - 04:00 PM", "Tue, Thu, Sat", "Online", "31649", 2, 82.32, 88.14, 86.23));

            return coursesList;
        } catch (Exception exception) {
            throw new Error(exception);
        }
    }
}
