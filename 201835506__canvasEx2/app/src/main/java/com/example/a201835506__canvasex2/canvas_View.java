package com.example.a201835506__canvasex2;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Path;
import android.util.AttributeSet;
import android.view.View;

import androidx.annotation.Nullable;

public class canvas_View extends View {
    private Paint paint;

    public canvas_View(Context context){
        super(context);

        init(context); // 초기화
    }

    public canvas_View(Context context, @Nullable AttributeSet attrs){
        super(context, attrs);

        init(context); // 초기화
    }

    private void init(Context context){
        paint = new Paint();
        paint.setColor(Color.RED);
    }
    @Override
    protected void onDraw(Canvas canvas){
        super.onDraw(canvas);
        Paint pnt = new Paint(Paint.ANTI_ALIAS_FLAG);
        pnt.setStrokeWidth(8);
        pnt.setColor(Color.RED);

        pnt.setStyle(Paint.Style.FILL);
        canvas.drawCircle(60,60,50,pnt);
        pnt.setStyle(Paint.Style.FILL_AND_STROKE);
        canvas.drawCircle(190,60,50,pnt);
        pnt.setStyle(Paint.Style.STROKE);
        canvas.drawCircle(330,60,50,pnt);

        pnt.setColor(Color.BLUE);
        pnt.setStyle(Paint.Style.FILL);
        canvas.drawCircle(350,250,90,pnt);
        pnt.setColor(Color.RED);
        pnt.setStyle(Paint.Style.STROKE);
        canvas.drawCircle(350,250,90,pnt);

        pnt.setColor(Color.RED);
        pnt.setStyle(Paint.Style.STROKE);
        canvas.drawCircle(550,250,90,pnt);
        pnt.setColor(Color.BLUE);
        pnt.setStyle(Paint.Style.FILL);
        canvas.drawCircle(550,250,90,pnt);

        pnt.setColor(Color.BLUE);
        pnt.setStrokeWidth(16);
        canvas.drawLine(50,530,540,530,pnt);
        pnt.setStrokeCap(Paint.Cap.ROUND);
        canvas.drawLine(50,560,540,560,pnt);
        pnt.setStrokeCap(Paint.Cap.SQUARE);
        canvas.drawLine(50,590,540,590,pnt);

        Path path = new Path();
        Paint pnt2 = new Paint();
        pnt2.setStrokeWidth(5);
        pnt2.setColor(Color.RED);
        pnt2.setStyle(Paint.Style.STROKE);

        path.addRect(100,1000,150,1090,Path.Direction.CW);
        path.addCircle(50,1050,40,Path.Direction.CW);
        canvas.drawPath(path,pnt2);

        path.reset();
        path.moveTo(10,1200);
        path.lineTo(50,1150);
        path.lineTo(400,1150);
        pnt2.setStrokeWidth(5);
        pnt2.setColor(Color.BLUE);
        canvas.drawPath(path,pnt2);

        pnt2.setTextSize(20);
        pnt2.setStyle(Paint.Style.FILL);
        canvas.drawTextOnPath("TEST TEXT ON PATH",path,0,0,pnt2);
    }

}
