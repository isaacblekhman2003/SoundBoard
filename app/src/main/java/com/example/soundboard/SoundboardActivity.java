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

public class SoundboardActivity extends AppCompatActivity implements View.OnClickListener {
    private SoundPool soundPool;
    int[] arrayy ={1,2,3,4,5,6,7,7};
    private Button A;
    private Button Bb;
    private Button B;
    private Button C;
    private Button CC;
    private Button D;
    private Button DD;
    private Button E;
    boolean loaded = false;
    private boolean isloaded;
    private int ANote;
    private int BbNote;
    private int BNote;
    private int CNote;
    private int CCNote;
    private int DNote;
    private int DDNote;
    private int ENote;


    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        widgets();
        listeners();
        initializeSoundPool();


    }

    private void initializeSoundPool(){

        this.setVolumeControlStream(AudioManager.STREAM_MUSIC);
        soundPool = new SoundPool(10, AudioManager.STREAM_MUSIC, 0);
        soundPool.setOnLoadCompleteListener(new OnLoadCompleteListener() {
            @Override
            public void onLoadComplete(SoundPool soundPool, int sampleId,
                                       int status) {
                loaded = true;
            }
        });

        ANote = soundPool.load(this, R.raw.scalea, 1);
        BbNote = soundPool.load(this, R.raw.scalebb, 1);
        BNote = soundPool.load(this, R.raw.scaleb, 1);
        CNote = soundPool.load(this, R.raw.scalec, 1);
        CCNote = soundPool.load(this, R.raw.scalecs, 1);
        DNote = soundPool.load(this, R.raw.scaled, 1);
       DDNote = soundPool.load(this, R.raw.scaleds, 1);
        ENote = soundPool.load(this, R.raw.scalee, 1);






    }

    private void widgets() {
        A = findViewById(R.id.button_main_A);
        Bb = findViewById(R.id.button_main_Bb);
        B = findViewById(R.id.button_main_B);
        C = findViewById(R.id.button_main_C);
        CC = findViewById(R.id.button_main_CC);
        D = findViewById(R.id.button_main_D);
        DD = findViewById(R.id.button_main_DD);
        E = findViewById(R.id.button_main_E);
    }
    private void delay(int millisDelay){
        try{
            Thread.sleep(millisDelay);

        }catch (InterruptedException e){
            e.printStackTrace();





        }}

    private void listeners() {
        A.setOnClickListener(new View.OnClickListener() {
                                    @Override
                                    public void onClick(View view) {

                                        if (loaded) {
                                            soundPool.play(ANote, 1, 1, 1, 0, 1f);
                                            Log.e("Test", "Played sound");
                                        }
                                    }


                                    });
        B.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                if (loaded) {
                    soundPool.play(BNote, 1, 1, 1, 0, 1f);
                    Log.e("Test", "Played sound");
                }
            }


        });
        C.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                if (loaded) {
                    soundPool.play(CNote, 1, 1, 1, 0, 1f);
                    Log.e("Test", "Played sound");
                }
            }


        });
        D.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                if (loaded) {
                    soundPool.play(DNote, 1, 1, 1, 0, 1f);
                    Log.e("Test", "Played sound");
                }
            }


        });
        E.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                if (loaded) {
                    soundPool.play(ENote, 1, 1, 1, 0, 1f);
                    Log.e("Test", "Played sound");
                }
            }


        });
        Bb.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                if (loaded) {
                    soundPool.play(BbNote, 1, 1, 1, 0, 1f);
                    Log.e("Test", "Played sound");
                }
            }


        });
        CC.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                if (loaded) {
                    soundPool.play(CCNote, 1, 1, 1, 0, 1f);
                    Log.e("Test", "Played sound");
                }
            }


        });
        DD.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (loaded) {
                    soundPool.play(DDNote, 1, 1, 1, 0, 1f);
                    Log.e("Test", "Played sound");
                }
            }


        });
                                }


    @Override
    public void onClick(View view) {
        switch(view.getId()){
            case R.id.button_main_A:
            {  SoundPool.play(ANote, 1,1,1,0,1)}
        }
    }
}









