package com.hci3.aris.ui.grades;

import android.annotation.SuppressLint;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.navigation.Navigation;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import com.google.android.material.textview.MaterialTextView;
import com.hci3.aris.R;
import com.hci3.aris.data.CourseDataSource;
import com.hci3.aris.data.model.CourseModel;

import java.util.List;

public class GradesFragment extends Fragment {

    /*
     * Mandatory empty constructor for the fragment manager to instantiate the
     * fragment (e.g. upon screen orientation changes).
     */
    public GradesFragment() {
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_grades, container, false);
    }

    @SuppressLint("SetTextI18n")
    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        CourseDataSource dataSource = new CourseDataSource();

        GradesAdapter courseAdapter = new GradesAdapter(getContext(), dataSource.getCourses());
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(getContext(), LinearLayoutManager.VERTICAL, false);

        RecyclerView recyclerView = view.findViewById(R.id.grades_list);
        recyclerView.setLayoutManager(linearLayoutManager);
        recyclerView.setAdapter(courseAdapter);

        MaterialTextView enrolledCourses = view.findViewById(R.id.enrolled_courses);
        enrolledCourses.setText("(" + courseAdapter.getItemCount() + ")");

        Button viewAll = view.findViewById(R.id.courses_view_all);
        viewAll.setOnClickListener(l ->
                Navigation.findNavController(l).navigate(R.id.action_navigation_grades_to_subnav_semester)
        );
    }

}