package com.example.adrianzabdiel.actividad;

import android.os.Build;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.MediaController;
import android.widget.VideoView;

public class MainActivity extends AppCompatActivity {
    VideoView mVideoView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mVideoView= findViewById(R.id.video);
        MediaController controller = new MediaController(this );
        controller.setMediaPlayer(mVideoView);
        mVideoView.setMediaController(controller);
    }

    private void initializePlayer(){
        mVideoView.setVideoPath("https://www.ebookfrenzy.com/android_book/movie.mp4");
        mVideoView.start();
    }

    private void realeasePlayer() {mVideoView.stopPlayback();}

    protected void onStart(){
        super.onStart();
        initializePlayer();
    }

    protected void onStop(){
        super.onStop();
        realeasePlayer();
    }

    protected void onPause(){
        super.onPause();

        if(Build.VERSION.SDK_INT < Build.VERSION_CODES.N){
            mVideoView.pause();
        }
    }
}
