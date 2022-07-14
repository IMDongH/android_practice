package com.example.marathon_tablet;

import android.content.Intent;
import android.content.res.Configuration;
import android.os.Bundle;
import android.telephony.PhoneNumberFormattingTextWatcher;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class PhoneActivity extends AppCompatActivity {

    private Button okButton;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_phone);

        okButton = findViewById(R.id.okButton);

        //전화번호 형식으로 데이터 표시
        EditText PhoneNumber = (EditText) findViewById(R.id.PhoneNumber);
        PhoneNumber.addTextChangedListener(new PhoneNumberFormattingTextWatcher());

        //상단바 숨김
        ActionBar actionBar = getSupportActionBar();
        actionBar.hide();

        okButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                if(validPhoneNumber(PhoneNumber.getText().toString()))
                {
                    Intent intent = new Intent(getApplicationContext(), PrintActivity.class);
                    intent.putExtra("data",PhoneNumber.getText().toString());
                    intent.putExtra("type","phone");
                    startActivity(intent);
                }
                else
                {
                    StartToast("올바르지 않은 전화번호 형식입니다.");
                }
            }
        });

    }
    @Override
    public void onConfigurationChanged(@NonNull Configuration newConfig){
        super.onConfigurationChanged(newConfig);
    }
    @Override
    protected void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);
    }
    public boolean validPhoneNumber(String number) {
        String regExp = "^01([0|1|6|7|8|9])-?([0-9]{3,4})-?([0-9]{4})$";
        if (number.matches(regExp)) {
            return true;
        } else {
            return false;
        }
    }

    private void StartToast(String msg) {
        Toast.makeText(this, msg, Toast.LENGTH_SHORT).show();
    }


}
