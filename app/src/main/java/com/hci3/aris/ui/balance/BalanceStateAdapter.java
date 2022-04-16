package com.hci3.aris.ui.balance;

import android.content.Context;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.viewpager2.adapter.FragmentStateAdapter;


public class BalanceStateAdapter extends FragmentStateAdapter {

    Context ctx;
    int totalTabs;

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
                return new Enrollment_fragment2();
            default:
                return new Scholarship_fragment3();
        }
    }

    public int getItemCount() {
        return totalTabs;
    }
}
