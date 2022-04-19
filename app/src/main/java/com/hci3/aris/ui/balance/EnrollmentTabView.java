package com.hci3.aris.ui.balance;

import android.annotation.SuppressLint;
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
import android.widget.Button;

import com.hci3.aris.R;
import com.hci3.aris.data.BalanceDataSource;
import com.hci3.aris.data.model.EnrollmentDataSource;

public class EnrollmentTabView extends Fragment {

    public EnrollmentTabView() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_enrollment_list, container, false);
    }

    @SuppressLint("SetTextI18n")
    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        EnrollmentDataSource sourceData = new EnrollmentDataSource();
        EnrollmentRecyclerAdapter Adapter = new EnrollmentRecyclerAdapter(getContext(), sourceData.getEnrolled() );

        RecyclerView linearRecyclerView = view.findViewById(R.id.enrollment_list);

        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(getContext(), LinearLayoutManager.VERTICAL, false);
        linearRecyclerView.setLayoutManager(linearLayoutManager);
        linearRecyclerView.setAdapter(Adapter);

    }
}