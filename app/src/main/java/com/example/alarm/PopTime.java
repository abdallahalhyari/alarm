package com.example.alarm;

import android.annotation.SuppressLint;
import android.os.Build;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TimePicker;

import androidx.annotation.RequiresApi;
import androidx.fragment.app.DialogFragment;

public class PopTime extends DialogFragment implements View.OnClickListener {

    View view;
    TimePicker tp;
    Button buDome;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState)
    {
        view=inflater.inflate(R.layout.pop_time,container,false);
        tp=(TimePicker)view.findViewById(R.id.tp1);
        buDome=(Button)view.findViewById(R.id.buDome);
        buDome.setOnClickListener(this);
        return view;
    }



    @RequiresApi(api = Build.VERSION_CODES.M)
    @Override
    public void onClick(View v) {
        this.dismiss();
        MainActivity ma=(MainActivity)getActivity();
        if ((int) Build.VERSION.SDK_INT >= 23)
            ma.SetTime(tp.getHour(),tp.getMinute());
        else
            ma.SetTime(tp.getCurrentHour(),tp.getCurrentMinute());
    }


}
