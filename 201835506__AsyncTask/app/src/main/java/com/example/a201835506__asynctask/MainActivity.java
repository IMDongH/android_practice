package com.example.a201835506__asynctask;

import androidx.appcompat.app.AppCompatActivity;

import android.os.AsyncTask;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ProgressBar;

public class MainActivity extends AppCompatActivity {

    ProgressBar progressBar;
    int value;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        progressBar = findViewById(R.id.progressBar);

        Button button = findViewById(R.id.button);
        BackgroundTask task = new BackgroundTask();
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                task.execute();
            }
        });
        Button cancel_button = findViewById(R.id.cancel);
        cancel_button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                task.cancel(false);
            }
        });
    }

    class BackgroundTask extends AsyncTask<Integer,Integer,Integer>{
        @Override
        protected void onPreExecute() {
            //super.onPreExecute();
            value = 0;
            progressBar.setProgress(value);
        }

        @Override
        protected void onPostExecute(Integer integer) {
            //super.onPostExecute(integer);
            progressBar.setProgress(0);
        }

        @Override
        protected void onProgressUpdate(Integer... values) {
            //super.onProgressUpdate(values);
            progressBar.setProgress(values[0].intValue());
        }

        @Override
        protected Integer doInBackground(Integer... integers) {
            //return null;
            while(isCancelled()==false){
                value += 1;
                if(value >=100){
                    break;
                }
                publishProgress(value);

                try{
                    Thread.sleep(1000);
                }catch (Exception e){}
            }

            return value;
        }
    }
}
