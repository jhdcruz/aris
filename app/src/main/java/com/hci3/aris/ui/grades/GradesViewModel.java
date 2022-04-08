package com.hci3.aris.ui.grades;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

public class GradesViewModel extends ViewModel {

    private final MutableLiveData<String> mText;

    public GradesViewModel() {
        mText = new MutableLiveData<>();
        mText.setValue("This is balance fragment");
    }

    public LiveData<String> getText() {
        return mText;
    }
}