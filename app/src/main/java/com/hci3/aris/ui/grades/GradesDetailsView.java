package com.hci3.aris.ui.grades;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.hci3.aris.R;
import com.hci3.aris.data.GradeDetailsCardDataSource;

public class GradesDetailsView extends Fragment {

    public GradesDetailsView() {
        /*
         * Mandatory empty constructor for the fragment manager to instantiate the
         * fragment (e.g. upon screen orientation changes).
         */
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_grade_details, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        GradeDetailsCardDataSource dataSource = new GradeDetailsCardDataSource();
        GradeDetailsRecyclerAdapter gradeDetailsAdapter = new GradeDetailsRecyclerAdapter(dataSource.getDetails());

        RecyclerView linearRecyclerView = view.findViewById(R.id.grade_details_list);
        RecyclerView gridRecyclerView = view.findViewById(R.id.grade_details_grid);

        if (gridRecyclerView != null) {
            GridLayoutManager gridLayoutManager = new GridLayoutManager(getContext(), 3, GridLayoutManager.VERTICAL, false);
            gridRecyclerView.setLayoutManager(gridLayoutManager);
            gridRecyclerView.setAdapter(gradeDetailsAdapter);
        } else {
            LinearLayoutManager linearLayoutManager = new LinearLayoutManager(getContext(), LinearLayoutManager.VERTICAL, false);
            linearRecyclerView.setLayoutManager(linearLayoutManager);
            linearRecyclerView.setAdapter(gradeDetailsAdapter);
        }

        // Inquiry dialog
        Button gradesInquire = view.findViewById(R.id.inquire_button);
        gradesInquire.setOnClickListener(l -> {
            GradesInquireBottomSheet inquire = new GradesInquireBottomSheet();
            inquire.show(this.getParentFragmentManager(), "grades_inquire");
        });
    }
}
