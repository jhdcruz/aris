package com.hci3.aris.ui.grades;

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

import com.google.android.material.card.MaterialCardView;
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

    @SuppressWarnings("unused")
    public static SemesterFragment newInstance(int columnCount) {
        SemesterFragment fragment = new SemesterFragment();
        Bundle args = new Bundle();
        fragment.setArguments(args);
        return fragment;
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

        SemesterAdapter semesterAdapter = new SemesterAdapter(getContext(), semesterModelArray);
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(getContext(), LinearLayoutManager.VERTICAL, false);

        RecyclerView recyclerView = view.findViewById(R.id.semester_list);
        recyclerView.setLayoutManager(linearLayoutManager);
        recyclerView.setAdapter(semesterAdapter);
    }
}