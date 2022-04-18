package com.hci3.aris.data.model.grades;

import java.util.List;
import java.util.Locale;

public class GradeDetailsCardModel {
    private final String category;
    private final double total;
    private final List<GradeDetailsContentModel> detailsContent;

    public GradeDetailsCardModel(String category, double total, List<GradeDetailsContentModel> detailsContent) {
        this.category = category;
        this.total = total;
        this.detailsContent = detailsContent;
    }

    public String getCategory() {
        return category;
    }

    public String getTotal() {
        return String.format(Locale.US, "%.2f", total);
    }

    public List<GradeDetailsContentModel> getDetailsContent() {
        return detailsContent;
    }
}
