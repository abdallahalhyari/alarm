package com.example.alarm;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentActivity;
import androidx.fragment.app.FragmentManager;

import android.app.AlarmManager;
import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;

import com.example.alarm.services.MyReceiver;

import java.util.Calendar;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        FragmentManager fm= getSupportFragmentManager();
        PopTime popTime=new PopTime();
        popTime.show(fm,"Show fragment");
    }

    void SetTime(int Hour,int Minute) {
        Calendar calendar = Calendar.getInstance();
        calendar.set(Calendar.HOUR_OF_DAY, Hour);
        calendar.set(Calendar.MINUTE,Minute);
        calendar.set(Calendar.SECOND, 0);

        AlarmManager am = (AlarmManager)getSystemService  (Context.ALARM_SERVICE);
        Intent intent = new Intent(this, MyReceiver.class);
        intent.setAction("com.alhyari.alarm");
        intent.putExtra("MyMessage","hello i am alarm  !!!");
        PendingIntent pi = PendingIntent.getBroadcast(this, 0, intent,
                PendingIntent.FLAG_UPDATE_CURRENT);
        am.setRepeating(AlarmManager.RTC_WAKEUP, calendar.getTimeInMillis(),
                AlarmManager.INTERVAL_DAY , pi);
    }
}