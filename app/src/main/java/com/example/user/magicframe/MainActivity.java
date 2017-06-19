package com.example.user.magicframe;

import android.content.Context;
import android.hardware.Sensor;
import android.hardware.SensorEvent;
import android.hardware.SensorEventListener;
import android.hardware.SensorManager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;

public class MainActivity extends AppCompatActivity implements SensorEventListener {
    public SensorManager sm;
    public Sensor as;
    MagicFrame mf;
    long time;
    long lastlogtime;
    double x, y, vx, vy;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mf = (MagicFrame) findViewById(R.id.magicframe);
        sm = (SensorManager) getSystemService(Context.SENSOR_SERVICE);
        if(sm != null) {
            Sensor s = sm.getDefaultSensor(Sensor.TYPE_ACCELEROMETER);
            if(s != null) {
                Log.d("Sensors", "Found sensor!");
                as = s;
            } else {
                Log.d("Sensors", "Linear acceleration sensor ain't available!");
            }
        } else {
            Log.d("Sensors", "Sensors ain't available");
        }
    }


    @Override
    protected void onResume() {
        super.onResume();
        sm.registerListener(this, as, SensorManager.SENSOR_DELAY_NORMAL);
    }

    @Override
    protected void onPause() {
        super.onPause();
        sm.unregisterListener(this);
    }

    @Override
    public void onSensorChanged(SensorEvent sensorEvent) {
        if(time == 0) {
            time = sensorEvent.timestamp;
            lastlogtime = time;
        } else {
            long dt = sensorEvent.timestamp - time;
            vx += sensorEvent.values[0] * dt;
            vy += sensorEvent.values[1] * dt;
            x += vx * dt;
            y += vy * dt;
            time = sensorEvent.timestamp;
            if(lastlogtime - time > 1000000000) {
                Log.d("Position", x + ", " + y);
                lastlogtime = time;
            }
        }
    }

    @Override
    public void onAccuracyChanged(Sensor sensor, int i) {
        //Do nothin'
    }
}
