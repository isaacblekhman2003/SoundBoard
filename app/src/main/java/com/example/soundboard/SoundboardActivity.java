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
    private Button song;
    boolean loaded = false;
    private boolean isloaded;
    private Note ANote;
    private Note BbNote;
    private Note BNote;
    private Note CNote;
    private Note CCNote;
    private Note DNote;
    private Note DDNote;
    private Note ENote;


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

        ANote = new Note(soundPool.load(this, R.raw.scalea, 1),100);
        BbNote = new Note (soundPool.load(this, R.raw.scalebb, 1),100);
        BNote = new Note (soundPool.load(this, R.raw.scaleb, 1),100);
        CNote = new Note (soundPool.load(this, R.raw.scalec, 1),100);
        CCNote = new Note (soundPool.load(this, R.raw.scalecs, 1),100);
        DNote = new Note (soundPool.load(this, R.raw.scaled, 1),100);
       DDNote = new Note (soundPool.load(this, R.raw.scaleds, 1),100);
        ENote = new Note (soundPool.load(this, R.raw.scalee, 1),100);






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
        song = findViewById(R.id.button_main_song);
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
                                            soundPool.play(ANote.getsI(), 1, 1, 1, 0, 1f);
                                            Log.e("Test", "Played sound");
                                        }
                                    }


                                    });
        B.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                if (loaded) {
                    soundPool.play(BNote.getsI(), 1, 1, 1, 0, 1f);
                    Log.e("Test", "Played sound");
                }
            }


        });
        C.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                if (loaded) {
                    soundPool.play(CNote.getsI(), 1, 1, 1, 0, 1f);
                    Log.e("Test", "Played sound");
                }
            }


        });
        D.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                if (loaded) {
                    soundPool.play(DNote.getsI(), 1, 1, 1, 0, 1f);
                    Log.e("Test", "Played sound");
                }
            }


        });
        E.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                if (loaded) {
                    soundPool.play(ENote.getsI(), 1, 1, 1, 0, 1f);
                    Log.e("Test", "Played sound");
                }
            }


        });
        Bb.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                if (loaded) {
                    soundPool.play(BbNote.getsI(), 1, 1, 1, 0, 1f);
                    Log.e("Test", "Played sound");
                }
            }


        });
        CC.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                if (loaded) {
                    soundPool.play(CCNote.getsI(), 1, 1, 1, 0, 1f);
                    Log.e("Test", "Played sound");
                }
            }


        });
        DD.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (loaded) {
                    soundPool.play(DDNote.getsI(), 1, 1, 1, 0, 1f);
                    Log.e("Test", "Played sound");
                }
            }


        });
                                }


    @Override
    public void onClick(View view) {
        switch(view.getId()){
            case R.id.button_main_song:
            {  soundPool.play(ANote.getsI(), 1,1,1,0,1);}
        }
    }
}









