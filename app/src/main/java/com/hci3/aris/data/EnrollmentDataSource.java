package com.hci3.aris.data;

import com.hci3.aris.data.model.EnrollmentModel;

import java.util.ArrayList;
import java.util.List;

public class EnrollmentDataSource {

    public List<EnrollmentModel> getEnrollment() {

        try {
            List<EnrollmentModel> enrollmentList = new ArrayList<>();

            enrollmentList.add(new EnrollmentModel("2021-2022 | 1st Sem", "23239828", "08/15/2021", 48000.00, 48000.00, true));
            enrollmentList.add(new EnrollmentModel("2021-2022 | 2nd Sem", "20394280", "02/18/2022", 48000.00, 3500.00, false));

            return enrollmentList;
        } catch (Exception exception) {
            throw new Error(exception);
        }
    }
}

