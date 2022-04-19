package com.hci3.aris.ui.balance;

import android.content.Context;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.viewpager2.adapter.FragmentStateAdapter;


public class BalanceStateAdapter extends FragmentStateAdapter {

    final Context ctx;
    final int totalTabs;

    public BalanceStateAdapter(Context context, BalanceFragment fragment, int totalTabs) {
        super(fragment);
        this.ctx = context;
        this.totalTabs = totalTabs;
    }

    @NonNull
    public Fragment createFragment(int position) {
        switch (position) {
            case 0:
                return new BalanceTabView();
            case 1:
                return new EnrollmentTabView();
            default:
                return new ScholarshipTabView();
        }
    }

    public int getItemCount() {
        return totalTabs;
    }
}
