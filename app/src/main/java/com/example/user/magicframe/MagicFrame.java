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

public class MagicFrame extends View {
    private int xmin, xmax, ymin, ymax;
    private double x, y, vx, vy;
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
}
