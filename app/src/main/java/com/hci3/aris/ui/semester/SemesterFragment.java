package com.hci3.aris.ui.semester;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.hci3.aris.R;
import com.hci3.aris.data.model.SemesterModel;

import java.util.ArrayList;
import java.util.List;

/**
 * A fragment that lists semesters.
 */
public class SemesterFragment extends Fragment {

    /**
     * Mandatory empty constructor for the fragment manager to instantiate the
     * fragment (e.g. upon screen orientation changes).
     */
    public SemesterFragment() {
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_semester, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        List<SemesterModel> semesterModelArray = new ArrayList<>();

        semesterModelArray.add(new SemesterModel("1st Sem", "2021-2022", 1.54, 20, 20, 8));
        semesterModelArray.add(new SemesterModel("2nd Sem", "2021-2022", 1.40, 18, 18, 7));
        semesterModelArray.add(new SemesterModel("1st Sem", "2020-2021", 1.34, 20, 20, 9));
        semesterModelArray.add(new SemesterModel("2nd Sem", "2020-2021", 1.20, 20, 18, 8));

        RecyclerView listRecyclerView = view.findViewById(R.id.semester_list);
        RecyclerView gridRecyclerView = view.findViewById(R.id.semester_grid);

        SemesterAdapter semesterAdapter = new SemesterAdapter(getContext(), semesterModelArray);

        if (gridRecyclerView != null) {
            GridLayoutManager gridLayoutManager = new GridLayoutManager(getContext(), 2, GridLayoutManager.VERTICAL, false);
            gridRecyclerView.setLayoutManager(gridLayoutManager);
            gridRecyclerView.setAdapter(semesterAdapter);
        } else {
            LinearLayoutManager linearLayoutManager = new LinearLayoutManager(getContext(), LinearLayoutManager.VERTICAL, false);
            listRecyclerView.setLayoutManager(linearLayoutManager);
            listRecyclerView.setAdapter(semesterAdapter);
        }
    }
}