package com.example.a201835506__canvasex_4;

import androidx.appcompat.app.AppCompatActivity;

import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;

public class MainActivity extends AppCompatActivity {

    LinearLayout mLinearLayout;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        mLinearLayout = new LinearLayout(this);
        ImageView img = new ImageView(this);
        Drawable myImage = getResources().getDrawable(R.drawable.android_blue);
        img.setImageDrawable(myImage);
        img.setLayoutParams(new ViewGroup.LayoutParams(ViewGroup.LayoutParams.WRAP_CONTENT,
                ViewGroup.LayoutParams.WRAP_CONTENT));
        mLinearLayout.addView(img);
//        setContentView(mLinearLayout);
        setContentView(R.layout.activity_main);
    }
}