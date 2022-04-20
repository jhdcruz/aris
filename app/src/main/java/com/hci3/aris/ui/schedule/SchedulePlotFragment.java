package com.hci3.aris.ui.schedule;

import android.annotation.SuppressLint;
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

public class SchedulePlotFragment extends Fragment {

    public SchedulePlotFragment() {
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
        return inflater.inflate(R.layout.fragment_schedule_plot, container, false);
    }

    @SuppressLint("SetTextI18n")
    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        List<String> titles = new ArrayList<>();
        titles.add("Monday");
        titles.add("Tuesday");
        titles.add("Wednesday");
        titles.add("Thursday");
        titles.add("Friday");
        titles.add("Saturday");

        TabLayout tabLayout = view.findViewById(R.id.sched_tab_layout);
        ViewPager2 viewPager = view.findViewById(R.id.sched_pager);

        ScheduleStateAdapter schedDetailsAdapter = new ScheduleStateAdapter(getContext(), this, tabLayout.getTabCount());
        viewPager.setAdapter(schedDetailsAdapter);

        new TabLayoutMediator(tabLayout, viewPager, (TabLayout.Tab tab, int position) ->
                tab.setText(titles.get(position))).attach();
    }
}