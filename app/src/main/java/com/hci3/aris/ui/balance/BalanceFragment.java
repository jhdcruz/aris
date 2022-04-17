package com.hci3.aris.ui.balance;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.viewpager2.widget.ViewPager2;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.google.android.material.tabs.TabLayout;
import com.google.android.material.tabs.TabLayoutMediator;
import com.hci3.aris.R;

import java.util.ArrayList;
import java.util.List;

public class BalanceFragment extends Fragment {

    /**
     * Mandatory empty constructor for the fragment manager to instantiate the
     * fragment (e.g. upon screen orientation changes).
     */
    public BalanceFragment() {
    }

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_balance, container, false);
    }


    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        List<String> titles = new ArrayList<>();
        titles.add("Balance");
        titles.add("Enrollment");
        titles.add("Scholarship");


        TabLayout tabLayout = view.findViewById(R.id.tabBar);
        ViewPager2 viewPager = view.findViewById(R.id.viewPager);

        BalanceStateAdapter adapter = new BalanceStateAdapter(getContext(), this, tabLayout.getTabCount());
        viewPager.setAdapter(adapter);

        new TabLayoutMediator(tabLayout, viewPager, (TabLayout.Tab tab, int position) ->
                tab.setText(titles.get(position))).attach();

    }
}