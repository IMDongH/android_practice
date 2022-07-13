package com.example.marathon_tablet;

import android.content.Intent;
import android.content.res.Configuration;
import android.os.Bundle;
import android.telephony.PhoneNumberFormattingTextWatcher;
import android.widget.EditText;

import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;

public class PhoneActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_phone);

        EditText PhoneNumber = (EditText) findViewById(R.id.PhoneNumber);
        PhoneNumber.addTextChangedListener(new PhoneNumberFormattingTextWatcher());

        ActionBar actionBar = getSupportActionBar();
        actionBar.hide();

        Intent intent = getIntent();

        String type = intent.getStringExtra("type");

        System.out.println(type);

    }
    @Override
    public void onConfigurationChanged(@NonNull Configuration newConfig){
        super.onConfigurationChanged(newConfig);
    }


}
