package com.hencoder.hencoderpracticedraw4.practice;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.Point;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.view.View;

import com.hencoder.hencoderpracticedraw4.R;

public class Practice08MatrixScaleView extends View {
    Paint paint = new Paint(Paint.ANTI_ALIAS_FLAG);
    Bitmap bitmap;
    Point point1 = new Point(200, 200);
    Point point2 = new Point(600, 200);
    Matrix matrix = new Matrix();

    public Practice08MatrixScaleView(Context context) {
        super(context);
    }

    public Practice08MatrixScaleView(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
    }

    public Practice08MatrixScaleView(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

    {
        bitmap = BitmapFactory.decodeResource(getResources(), R.drawable.maps);
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        float dx1 = point1.x + bitmap.getWidth() / 2;
        float dy1 = point1.y + bitmap.getHeight() / 2;
        matrix.reset();
        // Matrix调用一系列set,pre,post方法时,可视为将这些方法插入到一个队列
        // pre表示在队头插入一个方法
        // post表示在队尾插入一个方法
        // set表示把当前队列清空, 并且总是位于队列的最中间位置

        matrix.postTranslate(-dx1, -dy1);
        matrix.postScale(1.2f, 1.2f);
        matrix.postTranslate(dx1, dy1);

        canvas.save();
        canvas.concat(matrix);
        canvas.drawBitmap(bitmap, point1.x, point1.y, paint);
        canvas.restore();

        float dx2 = point2.x + bitmap.getWidth() / 2;
        float dy2 = point2.y + bitmap.getHeight() / 2;
        matrix.reset();
        matrix.preTranslate(dx2, dy2);
        matrix.preScale(0.5f, 1.5f);
        matrix.preTranslate(-dx2, -dy2);

        canvas.save();
        canvas.concat(matrix);
        canvas.drawBitmap(bitmap, point2.x, point2.y, paint);
        canvas.restore();
    }
}
