package com.example.a201835506__canvasex_3;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.util.AttributeSet;
import android.view.View;

import androidx.annotation.Nullable;

public class MyDrawEx extends View {

    public MyDrawEx(Context context) {
        super(context);
    }

    public MyDrawEx(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        Paint paint = new Paint();
        paint.setColor(Color.RED);
        canvas.drawColor(Color.WHITE);

        for(int x=0; x<1000; x+=10)
        {
            canvas.drawLine(x,0,1000-x,1000,paint);

        }
    }
}
