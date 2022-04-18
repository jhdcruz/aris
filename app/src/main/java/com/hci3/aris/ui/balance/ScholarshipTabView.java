package com.hci3.aris.ui.balance;

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
import com.hci3.aris.data.model.ScholarshipModel;

import java.util.ArrayList;
import java.util.List;

public class ScholarshipTabView extends Fragment {

    public ScholarshipTabView() {
        // Required empty public constructor
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_scholarship_list, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        List<ScholarshipModel> scholarshipModelArray = new ArrayList<>();

        scholarshipModelArray.add(new ScholarshipModel("Academic Scholarship Grant", "04/10/2022", 16000));
        scholarshipModelArray.add(new ScholarshipModel("DOST Scholarship Grant", "04/18/2022", 16000));

        ScholarshipRecyclerAdapter scholarshipAdapter = new ScholarshipRecyclerAdapter(getContext(), scholarshipModelArray);

        RecyclerView listRecyclerView = view.findViewById(R.id.scholarship_list);
        RecyclerView gridRecyclerView = view.findViewById(R.id.scholarship_grid);

        if (gridRecyclerView != null) {
            GridLayoutManager gridLayoutManager = new GridLayoutManager(getContext(), 3, GridLayoutManager.VERTICAL, false);
            gridRecyclerView.setLayoutManager(gridLayoutManager);
            gridRecyclerView.setAdapter(scholarshipAdapter);
        } else {
            LinearLayoutManager linearLayoutManager = new LinearLayoutManager(getContext(), LinearLayoutManager.VERTICAL, false);
            listRecyclerView.setLayoutManager(linearLayoutManager);
            listRecyclerView.setAdapter(scholarshipAdapter);
        }
    }
}