package com.example.user.magicframe;

import android.content.Context;
import android.graphics.Canvas;
import android.hardware.Sensor;
import android.hardware.SensorEvent;
import android.hardware.SensorEventListener;
import android.hardware.SensorManager;
import android.util.Log;
import android.view.View;

/**
 * Created by user on 17.06.17.
 * The main view of the app.
 */

public class MagicFrame extends View implements SensorEventListener {
    private int xmin, xmax, ymin, ymax;
    private double x, y, vx, vy;
    public SensorManager sm;
    public Sensor as;

    public MagicFrame(Context context) {
        super(context);
        xmin = 0;
        xmax = getWidth();
        ymin = 0;
        ymax = getHeight();

        if(sm != null) {
            as = sm.getDefaultSensor(Sensor.TYPE_LINEAR_ACCELERATION);
        } else {
            Log.d("Sensors", "Sensors ain't available");
        }
    }

    protected void onDraw(Canvas canvas) {

    }

    @Override
    public void onSensorChanged(SensorEvent sensorEvent) {
        
    }

    @Override
    public void onAccuracyChanged(Sensor sensor, int i) {
        //Do nothin'
    }
}
