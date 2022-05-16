package com.example.a201835506__canvasex6;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ImageView imageView1 = (ImageView) findViewById(R.id.imageView1);
        EditText editText = (EditText) findViewById(R.id.editText);
        Button button =  (Button) findViewById(R.id.button);

        button.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view)
            {
                Animation anim = AnimationUtils.loadAnimation(getApplicationContext(),R.anim.translate);
                imageView1.startAnimation(anim);
                editText.append("애니메이션 시작됨 \n");
            }
        });
    }
}