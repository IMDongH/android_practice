package com.example.a201835506__mediaplayerex_2;

import androidx.appcompat.app.AppCompatActivity;

import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.MediaController;
import android.widget.VideoView;

public class MainActivity extends AppCompatActivity {

    VideoView videoView;
    String url = "http://sites.google.com/site/ubiaccessmobile/sample_video.mp4";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        MediaController mc = new MediaController(this);
        videoView = findViewById(R.id.videoView);
        videoView.setMediaController(mc);
        Button button = findViewById(R.id.button);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                playVideo();
            }
        });
    }

    public void playVideo()
    {
        try {
        videoView.setVideoURI(Uri.parse(url));
        videoView.requestFocus();
        videoView.start();
        }
        catch (Exception e)
        {
            e.printStackTrace();
        }

    }
}