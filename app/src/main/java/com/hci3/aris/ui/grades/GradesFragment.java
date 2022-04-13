package com.hci3.aris.ui.grades;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.hci3.aris.R;
import com.hci3.aris.adapter.CourseAdapter;
import com.hci3.aris.data.model.CourseModel;

import java.util.ArrayList;

public class GradesFragment extends Fragment {

    private RecyclerView gradesRV;

    public GradesFragment() {
    }

    public static GradesFragment newInstance() {
        return new GradesFragment();
    }

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_grades, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        gradesRV = view.findViewById(R.id.grades_recycler);
        ArrayList<CourseModel> courseModelArray = new ArrayList<>();

        // Course data
        courseModelArray.add(new CourseModel("CITE 012", "Introduction to HCI", 3, 78.25, 88.09, 86.00));
        courseModelArray.add(new CourseModel("CITE 003", "Computer Programming 3", 3, 92.25, 91.04, 98.00));
        courseModelArray.add(new CourseModel("GEC 005", "Understanding The Self", 2, 82.32, 88.14, 86.23));
        courseModelArray.add(new CourseModel("GEC 001", "Purposive Communication", 3, 84.45, 82.48, 81.11));

        CourseAdapter courseAdapter = new CourseAdapter(getContext(), courseModelArray);

        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(getContext(), LinearLayoutManager.VERTICAL, false);

        gradesRV.setLayoutManager(linearLayoutManager);
        gradesRV.setAdapter(courseAdapter);
    }

}