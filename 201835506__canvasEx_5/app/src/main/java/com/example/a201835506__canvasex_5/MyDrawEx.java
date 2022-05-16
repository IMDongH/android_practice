package com.example.a201835506__canvasex_5;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;

import androidx.annotation.Nullable;

public class MyDrawEx extends View {

    private Paint mPaint;
    private Bitmap mAndroidGreen;
    private Bitmap mAndroidRed;
    private int nAngle = 0;
    public void init(Context context)
    {
        mPaint = new Paint();
        Resources res = getResources();
        mAndroidGreen = BitmapFactory.decodeResource(res,R.drawable.android_green);
        mAndroidRed = BitmapFactory.decodeResource(res,R.drawable.android_red);
    }
    public MyDrawEx(Context context) {
        super(context);
        init(context);
    }

    public MyDrawEx(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
        init(context);
    }

    public boolean onTouchEvent(MotionEvent event)
    {
        if(event.getAction() == MotionEvent.ACTION_UP)
        {
            nAngle = nAngle + 5;
            invalidate();
        }
        return true;
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);

        canvas.drawBitmap(mAndroidGreen,0,0,mPaint);
        canvas.save();

        canvas.rotate(nAngle);
        canvas.drawBitmap(mAndroidRed,0,0,mPaint);

        Bitmap sm = BitmapFactory.decodeResource(getResources(),R.drawable.image);

        Bitmap bitm2 = Bitmap.createBitmap(sm,0,0,sm.getWidth(),sm.getHeight());
        canvas.drawBitmap(bitm2,0,1000,mPaint);

        Bitmap bitm3 = Bitmap.createScaledBitmap(sm,700,300,false);
        canvas.drawBitmap(bitm3,0,1300,mPaint);
    }
}
