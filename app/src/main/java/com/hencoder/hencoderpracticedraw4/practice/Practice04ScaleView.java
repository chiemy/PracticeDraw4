package com.hencoder.hencoderpracticedraw4.practice;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Point;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.view.View;

import com.hencoder.hencoderpracticedraw4.R;

public class Practice04ScaleView extends View {
    Paint paint = new Paint(Paint.ANTI_ALIAS_FLAG);
    Bitmap bitmap;
    Point point1 = new Point(200, 200);
    Point point2 = new Point(600, 200);

    public Practice04ScaleView(Context context) {
        super(context);
    }

    public Practice04ScaleView(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
    }

    public Practice04ScaleView(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

    {
        bitmap = BitmapFactory.decodeResource(getResources(), R.drawable.maps);
        paint.setColor(Color.RED);
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        float px = point1.x + bitmap.getWidth() / 2;
        float py = point1.y + bitmap.getHeight() / 2;
        canvas.save();
        // 注意：顺序是反的
        // 即：画图 > 图片中心与画布原点重合 > 放大 > 移动回原来位置
        canvas.translate(px, py);
        canvas.scale(1.2f, 1.2f);
        canvas.translate(-px, -py);
        canvas.drawBitmap(bitmap, point1.x, point1.y, paint);

        // 下面的代码与上边的实现等效，
        // canvas.scale(sx, sy, px, py) 内部就是 translate(px, py) > scale(sx, sy) > translate(-px, -py)
        // canvas.scale(1.2f, 1.2f, px, py);
        // canvas.drawBitmap(bitmap, point1.x, point1.y, paint);
        canvas.restore();


        float px1 = point2.x + bitmap.getWidth() / 2;
        float py1 = point2.y + bitmap.getHeight() / 2;
        canvas.save();
        canvas.scale(0.5f, 1.5f, px1, py1);
        canvas.drawBitmap(bitmap, point2.x, point2.y, paint);
        canvas.restore();
    }
}
