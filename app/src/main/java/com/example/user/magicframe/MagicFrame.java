package com.example.user.magicframe;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.hardware.Sensor;
import android.hardware.SensorEvent;
import android.hardware.SensorEventListener;
import android.hardware.SensorManager;
import android.util.AttributeSet;
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
    private long time;
    private long lastlogtime;
    Paint black;

    public MagicFrame(Context context) {
        super(context);
        init();
    }

    public MagicFrame(Context context, AttributeSet attrs) {
        super(context, attrs);
        init();
    }

    public MagicFrame(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        init();
    }

    private void init() {
        xmin = 0;
        xmax = getWidth();
        ymin = 0;
        ymax = getHeight();
        black = new Paint();
        black.setColor(Color.BLACK);
    }

    protected void onDraw(Canvas canvas) {
        canvas.drawRect(0, 0, 100, 100, black);
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
