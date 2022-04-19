package com.hci3.aris.data.model;

import java.util.ArrayList;
import java.util.List;

public class EnrollmentDataSource {

    public List<EnrollmentModel> getEnrolled() {

        try {
            List<EnrollmentModel> enrollmentList = new ArrayList<>();

            enrollmentList.add(new EnrollmentModel("1st installment", "23239828", "03/11/2022", 3500.00, 350.00));
            enrollmentList.add(new EnrollmentModel("2nd installment", "23239828", "03/11/2022", 3500.00, 350.00));
            enrollmentList.add(new EnrollmentModel("3rd installment", "23239828", "03/11/2022", 3500.00, 350.00));
            enrollmentList.add(new EnrollmentModel("4th installment", "23239828", "03/11/2022", 3500.00, 350.00));
            enrollmentList.add(new EnrollmentModel("5th installment", "23239828", "03/11/2022", 3500.00, 350.00));
            enrollmentList.add(new EnrollmentModel("6th installment", "23239828", "03/11/2022", 3500.00, 350.00));

            return enrollmentList;
        } catch (Exception exception) {
            throw new Error(exception);
        }
    }
}

