package com.example.alarm.services;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.widget.Toast;

public class MyReceiver extends BroadcastReceiver {

    @Override
    public void onReceive(Context context, Intent intent) {
       if(intent.getAction().equalsIgnoreCase("com.alhyari.alarm")){
           Bundle b=intent.getExtras();
           Toast.makeText(context,b.getString("MyMessage"),Toast.LENGTH_LONG).show();
       }
    }
}