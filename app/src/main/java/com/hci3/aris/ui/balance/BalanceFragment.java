package com.hci3.aris.ui.balance;

import androidx.lifecycle.ViewModelProvider;

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
import com.hci3.aris.adapter.BalanceAdapter;

import java.util.ArrayList;
import java.util.List;

public class BalanceFragment extends Fragment {

    private BalanceViewModel mViewModel;

    public static BalanceFragment newInstance() {
        return new BalanceFragment();
    }

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_balance, container, false);
    }


    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        mViewModel = new ViewModelProvider(this).get(BalanceViewModel.class);

        List<String> titles = new ArrayList<>();
        titles.add("Balance");
        titles.add("Enrollment");
        titles.add("Scholarship");


        TabLayout tabLayout = view.findViewById(R.id.tabBar);
        ViewPager2 viewPager2 = view.findViewById(R.id.viewPager);

        BalanceAdapter adapter = new BalanceAdapter(getContext(), this , tabLayout.getTabCount());
        viewPager2.setAdapter(adapter);

        new TabLayoutMediator(tabLayout, viewPager2, (TabLayout.Tab tab, int position) ->
                tab.setText(titles.get(position))).attach();

    }
}