package com.hci3.aris.ui.semester;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.hci3.aris.R;
import com.hci3.aris.data.CourseDataSource;
import com.hci3.aris.ui.grades.GradesRecyclerAdapter;

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

        CourseDataSource dataSource = new CourseDataSource();
        GradesRecyclerAdapter courseAdapter = new GradesRecyclerAdapter(getContext(), dataSource.getCourses());

        RecyclerView recyclerViewGrid = view.findViewById(R.id.grades_list_grid);
        RecyclerView recyclerViewList = view.findViewById(R.id.grades_list);

        if (recyclerViewGrid != null) {
            GridLayoutManager gridLayoutManager = new GridLayoutManager(getContext(), 3, GridLayoutManager.VERTICAL, false);
            recyclerViewGrid.setLayoutManager(gridLayoutManager);
            recyclerViewGrid.setAdapter(courseAdapter);
        } else {
            LinearLayoutManager linearLayoutManager = new LinearLayoutManager(getContext(), LinearLayoutManager.VERTICAL, false);
            recyclerViewList.setLayoutManager(linearLayoutManager);
            recyclerViewList.setAdapter(courseAdapter);
        }
    }
}
