package com.hci3.aris.ui.semester;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.hci3.aris.R;
import com.hci3.aris.data.model.CourseModel;
import com.hci3.aris.ui.grades.GradesAdapter;

import java.util.ArrayList;
import java.util.List;

public class SemesterGradesFragment extends Fragment {

    /**
     * Mandatory empty constructor for the fragment manager to instantiate the
     * fragment (e.g. upon screen orientation changes).
     */
    public SemesterGradesFragment() {
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_grades_list, container, false);
    }

    @SuppressLint("SetTextI18n")
    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        List<CourseModel> courseModelArray = new ArrayList<>();

        // Course data
        courseModelArray.add(new CourseModel("CITE 012", "Introduction to HCI", 3, 78.25, 88.09, 86.00));
        courseModelArray.add(new CourseModel("CITE 003", "Computer Programming 3", 3, 92.25, 91.04, 98.00));
        courseModelArray.add(new CourseModel("GEC 005", "Understanding The Self", 2, 82.32, 88.14, 86.23));
        courseModelArray.add(new CourseModel("GEC 001", "Purposive Communication", 3, 84.45, 82.48, 81.11));

        GradesAdapter courseAdapter = new GradesAdapter(getContext(), courseModelArray);
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(getContext(), LinearLayoutManager.VERTICAL, false);

        RecyclerView recyclerView = view.findViewById(R.id.grades_list);
        recyclerView.setLayoutManager(linearLayoutManager);
        recyclerView.setAdapter(courseAdapter);
    }
}
