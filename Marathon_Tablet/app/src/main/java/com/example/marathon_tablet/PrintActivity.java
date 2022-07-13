package com.example.marathon_tablet;

import android.content.Intent;
import android.content.res.Configuration;
import android.os.Bundle;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;

public class PrintActivity extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_print);


        TextView text1 = findViewById(R.id.text1);
        TextView text2 = findViewById(R.id.text2);
        TextView text3 = findViewById(R.id.text3);
        ActionBar actionBar = getSupportActionBar();
        actionBar.hide();

        Intent intent = getIntent();

        String data = intent.getStringExtra("data");
        //QR데이터 or 휴대폰 번호 데이터
        String auth = intent.getStringExtra("type");
        //QR로 넘어온 데이터인지 휴대폰 번호로 넘어온 데이터인지 판단
        //QR = qr, 휴대폰 번호 = phone
        String type = CustomScannerActivity.getType();
        //QR 화면에서 선택하는 번호표 출력인지 기록증 출력인지
        //번호표 = number, 기록증 = record


        text1.setText(data);
        text2.setText(auth);
        text3.setText(type);
        System.out.println(data);
    }

    @Override
    public void onBackPressed()
    {
        StartActivity(MainActivity.class);
    }

    private void StartActivity(Class c) {
        Intent intent = new Intent(this, c);
        // 동일한 창이 여러번 뜨게 만드는 것이 아니라 기존에 켜져있던 창을 앞으로 끌어와주는 기능.
        // 이 플래그를 추가하지 않을 경우 창들이 중복돼서 계속 팝업되게 된다.
        // 메인화면을 띄우는 모든 코드에서 이 플래그를 추가해줘야 하는 것 같다.
        intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
        startActivity(intent);
    }

    @Override
    public void onConfigurationChanged(@NonNull Configuration newConfig){
        super.onConfigurationChanged(newConfig);
    }
}
