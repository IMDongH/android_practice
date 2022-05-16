package com.example.a201835506__canvasex_3;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
//        setContentView(R.layout.activity_main);
            MyDrawEx view = new MyDrawEx(this);
            setContentView(view);

    }
}