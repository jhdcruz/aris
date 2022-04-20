package com.hci3.aris.ui.schedule;

import android.content.Context;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.viewpager2.adapter.FragmentStateAdapter;


public class ScheduleStateAdapter extends FragmentStateAdapter {

    final Context ctx;
    final int totalTabs;

    public ScheduleStateAdapter(Context context, SchedulePlotFragment fragment, int totalTabs) {
        super(fragment);
        this.ctx = context;
        this.totalTabs = totalTabs;
    }

    @Override
    public int getItemCount() {
        return totalTabs;
    }

    @NonNull
    @Override
    public Fragment createFragment(int position) {

        // since this is just a sample, show same details to all tabs
        return new SchedulePlotView();
    }
}
