package com.example.a201835506__canvasex_5;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        MyDrawEx view = new MyDrawEx(this);
        setContentView(view);
    }
}