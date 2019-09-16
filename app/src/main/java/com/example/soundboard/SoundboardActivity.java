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

public class SoundboardActivity extends AppCompatActivity implements OnTouchListener  {
    private SoundPool soundPool;
    private int soundID;
    private Button bruh;
    private Button swamp;
    private Button darude;
    boolean loaded = false;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        wireWidgets();
        bruh.setOnTouchListener(this);
        // Set the hardware buttons to control the music
        this.setVolumeControlStream(AudioManager.STREAM_MUSIC);
        // Load the sound
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

    private void wireWidgets() {
        bruh = findViewById(R.id.button_main_bruh);
        swamp = findViewById(R.id.button_main_myswomp);
        darude = findViewById(R.id.button_main_darude);
    }

    @Override
    public boolean onTouch(View v, MotionEvent event) {
        if (event.getAction() == MotionEvent.ACTION_DOWN) {
            // Getting the user sound settings
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
        return false;
    }
}

