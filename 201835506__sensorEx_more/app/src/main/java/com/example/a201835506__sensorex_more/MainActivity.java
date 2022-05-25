package com.example.a201835506__sensorex_more;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.hardware.Sensor;
import android.hardware.SensorManager;
import android.os.Bundle;
import android.widget.TextView;

import java.util.List;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        SensorManager sm = (SensorManager) getSystemService(Context.SENSOR_SERVICE);
         List<Sensor> arSensor = sm.getSensorList(Sensor.TYPE_ALL);
         String result = "갯수 : "+ arSensor.size()+"\n\n";
         for(Sensor s : arSensor)
         {
             result += ("이름 = "+s.getName() + "\n형식 = " + s.getType() + "\n제조사 = "+s.getVendor()+
                     "\n전원 = "+s.getPower() + "\n해상도 = "+s.getResolution()+"범위 = "+ s.getMaximumRange()+"\n\n");
         }

        TextView txtResult = findViewById(R.id.result);
         txtResult.setText(result);
    }
}