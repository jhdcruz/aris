package com.hci3.aris.ui.balance;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.navigation.Navigation;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.google.android.material.bottomsheet.BottomSheetDialog;
import com.hci3.aris.R;
import com.hci3.aris.data.BalanceDataSource;

public class BalanceTabView extends Fragment {

    public BalanceTabView() {
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
        return inflater.inflate(R.layout.fragment_balance_list, container, false);
    }

    @SuppressLint("SetTextI18n")
    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        BalanceDataSource dataSource = new BalanceDataSource();
        BalanceRecyclerAdapter balanceAdapter = new BalanceRecyclerAdapter(getContext(), dataSource.getBalance());

        RecyclerView linearRecyclerView = view.findViewById(R.id.balance_list);
        RecyclerView gridRecyclerView = view.findViewById(R.id.balance_grid);

        if (gridRecyclerView != null) {
            GridLayoutManager gridLayoutManager = new GridLayoutManager(getContext(), 3, GridLayoutManager.VERTICAL, false);
            gridRecyclerView.setLayoutManager(gridLayoutManager);
            gridRecyclerView.setAdapter(balanceAdapter);
        } else {
            LinearLayoutManager linearLayoutManager = new LinearLayoutManager(getContext(), LinearLayoutManager.VERTICAL, false);
            linearRecyclerView.setLayoutManager(linearLayoutManager);
            linearRecyclerView.setAdapter(balanceAdapter);
        }

        Button payBalance = view.findViewById(R.id.balance_pay_fab);
        payBalance.setOnClickListener(l -> {
            BalancePayBottomSheet bottomSheet = new BalancePayBottomSheet();
            bottomSheet.show(this.getParentFragmentManager(), "payment");
        });
    }
}
