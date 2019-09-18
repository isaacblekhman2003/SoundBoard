package com.example.soundboard;
import android.app.Activity;
import android.media.AudioManager;
import android.media.SoundPool;
import android.media.SoundPool.OnLoadCompleteListener;
import android.os.Bundle;
import android.util.Log;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnTouchListener;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.Button;

public class SoundboardActivity extends AppCompatActivity {
    private SoundPool soundPool;
    private int soundID;
    private Button bruh;
    private Button swamp;
    private Button darude;
    boolean loaded = false;
    private boolean isloaded;


    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Button[] buttons = new Button[12];

        setContentView(R.layout.activity_main);
        bruh = findViewById(R.id.button_main_bruh);
        swamp = findViewById(R.id.button_main_myswomp);
        darude = findViewById(R.id.button_main_darude);
        listeners();
        this.setVolumeControlStream(AudioManager.STREAM_MUSIC);
        soundPool = new SoundPool(10, AudioManager.STREAM_MUSIC, 0);
        soundPool.setOnLoadCompleteListener(new OnLoadCompleteListener() {
            @Override
            public void onLoadComplete(SoundPool soundPool, int sampleId,
                                       int status) {
                loaded = true;
            }
        });
        soundID = soundPool.load(this, R.raw.darude, 1);
    }
    private void listeners() {
        bruh.setOnClickListener(new View.OnClickListener() {
                                    @Override
                                    public void onClick(View view) {
                                        AudioManager audioManager = (AudioManager) getSystemService(AUDIO_SERVICE);
                                        float actualVolume = (float) audioManager
                                                .getStreamVolume(AudioManager.STREAM_MUSIC);
                                        float maxVolume = (float) audioManager
                                                .getStreamMaxVolume(AudioManager.STREAM_MUSIC);
                                        float volume = actualVolume / maxVolume;
                                        // Is the sound loaded already?
                                        if (loaded) {
                                            soundPool.play(soundID, volume, volume, 1, 0, 1f);
                                            Log.e("Test", "Played sound");
                                        }
                                    }


                                    });
                                }


    }









