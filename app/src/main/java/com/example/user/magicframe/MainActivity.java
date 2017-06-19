package com.example.user.magicframe;

import android.content.Context;
import android.hardware.Sensor;
import android.hardware.SensorManager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;

public class MainActivity extends AppCompatActivity {
    MagicFrame mf;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mf = (MagicFrame) findViewById(R.id.magicframe);
        mf.sm = (SensorManager) getSystemService(Context.SENSOR_SERVICE);
        if(mf.sm != null) {
            Sensor s = mf.sm.getDefaultSensor(Sensor.TYPE_ACCELEROMETER);
            if(s != null) {
                Log.d("Sensors", "Found sensor!");
                mf.as = s;
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
        mf.sm.registerListener(mf, mf.as, SensorManager.SENSOR_DELAY_NORMAL);
    }

    @Override
    protected void onPause() {
        super.onPause();
        mf.sm.unregisterListener(mf);
    }
}
