package com.hci3.aris.ui.grades;

import android.content.Context;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.viewpager2.adapter.FragmentStateAdapter;


public class GradesStateAdapter extends FragmentStateAdapter {

    Context ctx;
    int totalTabs;

    public GradesStateAdapter(Context context, GradesDetailsFragment fragment, int totalTabs) {
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
        return new GradesDetailsView();
    }
}
