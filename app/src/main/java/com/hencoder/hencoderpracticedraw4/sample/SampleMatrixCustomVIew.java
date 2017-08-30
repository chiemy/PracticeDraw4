package com.hencoder.hencoderpracticedraw4.sample;


import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Matrix;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.view.View;

/**
 * Created: chiemy
 * Date: 8/30/17
 * Description:
 */

public class SampleMatrixCustomVIew extends View {
    private static final int SPACING = 20;
    private float radius;
    private Matrix matrix = new Matrix();
    private float[] dst;
    private float[] src;

    private int rowCount;

    public SampleMatrixCustomVIew(Context context) {
        super(context);
    }

    public SampleMatrixCustomVIew(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
    }

    public SampleMatrixCustomVIew(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

    @Override
    protected void onSizeChanged(int w, int h, int oldw, int oldh) {
        super.onSizeChanged(w, h, oldw, oldh);
        int centerY = h / 2;

        rowCount = h / 2 / SPACING - 1;

        radius = (float) (h / Math.PI);

        float newY = h / 2 - (float) (radius * Math.cos(0 / radius));

        dst = new float[rowCount * 4];
        src = new float[rowCount * 4];

    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);

    }
}
