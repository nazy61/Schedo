package com.nazycodes.schedo.fragments;

import android.os.Bundle;

import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.harrywhewell.scrolldatepicker.DayScrollDatePicker;
import com.harrywhewell.scrolldatepicker.OnDateSelectedListener;
import com.nazycodes.schedo.R;

import java.util.Date;

public class PlannedFragment extends Fragment {

    private DayScrollDatePicker mPicker;

    public PlannedFragment() {
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_planned, container, false);

        mPicker = view.findViewById(R.id.day_date_picker);
        mPicker.setStartDate(1, 1, 2020);
        mPicker.setEndDate(30, 12, 2050);

        mPicker.getSelectedDate(new OnDateSelectedListener() {
            @Override
            public void onDateSelected(@Nullable Date date) {
                if(date != null){
                    // do something with selected date
                }
            }
        });

        return view;
    }

}