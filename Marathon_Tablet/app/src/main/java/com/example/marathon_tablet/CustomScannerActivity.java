package com.example.marathon_tablet;

import android.content.Intent;
import android.content.res.Configuration;
import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import androidx.annotation.NonNull;

import com.journeyapps.barcodescanner.CaptureActivity;
import com.journeyapps.barcodescanner.CaptureManager;
import com.journeyapps.barcodescanner.DecoratedBarcodeView;

public class CustomScannerActivity extends CaptureActivity {
    public static String type = "number";
    private CaptureManager capture;
    private DecoratedBarcodeView barcodeScannerView;
    private BackPressCloseHandler backPressCloseHandler;
    private Button phoneButton;
    private TextView number,record;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_custom_scanner);
        phoneButton = findViewById(R.id.phoneButton);
        number = findViewById(R.id.number);
        record = findViewById(R.id.record);

        setClickedText();
        backPressCloseHandler = new BackPressCloseHandler(this);

        barcodeScannerView = (DecoratedBarcodeView)findViewById(R.id.zxing_barcode_scanner);
//        barcodeScannerView.setTorchListener((DecoratedBarcodeView.TorchListener) this);
        capture = new CaptureManager(this, barcodeScannerView);
        capture.initializeFromIntent(getIntent(), savedInstanceState);
        capture.setShowMissingCameraPermissionDialog(false);
        capture.decode();



        TextView.OnClickListener onClickListener = new TextView.OnClickListener() {
            @Override
            public void onClick(View v) {
                switch (v.getId()){
                    case R.id.number:
                            number.setTextColor(getResources().getColor(R.color.white));
                            record.setTextColor(Color.parseColor("#585858"));
                            type="number";
                        break;
                    case R.id.record:
                            number.setTextColor(Color.parseColor("#585858"));
                            record.setTextColor(getResources().getColor(R.color.white));
                            type="record";
                        break;
                }
            }
        };

        number.setOnClickListener(onClickListener);
        record.setOnClickListener(onClickListener);

        phoneButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(), PhoneActivity.class);
                intent.putExtra("type",type);
                startActivity(intent);
            }
        });

    }

    public void onBackPressed() {
        backPressCloseHandler.onBackPressed();
    }
//    @Override
//    public void onRequestPermissionsResult(int requestCode, @NonNull String[] permissions, @NonNull int[] grantResults) {
//        capture.onRequestPermissionsResult(requestCode, permissions, grantResults);
//    }
    @Override
    protected void onResume() {
        super.onResume();
        capture.onResume();
    }

    @Override
    protected void onPause() {
        super.onPause();

        capture.onPause();
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        capture.onDestroy();
    }

    @Override
    protected void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);
        capture.onSaveInstanceState(outState);
    }
    @Override
    public void onConfigurationChanged(@NonNull Configuration newConfig){
        super.onConfigurationChanged(newConfig);
    }
    public static String getType()
    {
        return type;
    }

    public void setClickedText(){
        switch (type){
            case "number":
                number.setTextColor(getResources().getColor(R.color.white));
                record.setTextColor(Color.parseColor("#585858"));
                break;
            case "record":
                number.setTextColor(Color.parseColor("#585858"));
                record.setTextColor(getResources().getColor(R.color.white));
                break;
        }
    }
}
