package com.example.user.sensorapp02;

import android.content.Context;
import android.hardware.Sensor;
import android.hardware.SensorEvent;
import android.hardware.SensorEventListener;
import android.hardware.SensorManager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;

import java.util.List;

public class MainActivity extends AppCompatActivity implements SensorEventListener {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //端末のセンサーリストを表示
        SensorManager sm = (SensorManager)this.getSystemService(Context.SENSOR_SERVICE);
        List<Sensor> sensors = sm.getSensorList(Sensor.TYPE_ALL);
        for (Sensor s: sensors) {
            Log.d("SENSOR", "名前 : " + s.getName());
        }
    }

    @Override
    public void onSensorChanged(SensorEvent sev){

    }

    @Override
    public void onAccuracyChanged(Sensor s, int ac){

    }
}
