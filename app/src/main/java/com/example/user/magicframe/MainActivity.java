package com.example.user.magicframe;

import android.content.Context;
import android.hardware.SensorManager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        MagicFrame mf = (MagicFrame) findViewById(R.id.magicframe);
        mf.sm = (SensorManager) getSystemService(Context.SENSOR_SERVICE);
    }
}
