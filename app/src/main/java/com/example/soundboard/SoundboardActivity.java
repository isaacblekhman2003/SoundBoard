package com.example.soundboard;
import android.media.AudioManager;
import android.media.SoundPool;
import android.media.SoundPool.OnLoadCompleteListener;
import android.os.Bundle;
import android.util.Log;
import android.view.View;

import androidx.appcompat.app.AppCompatActivity;

import android.widget.Button;

import java.util.Arrays;

public class SoundboardActivity extends AppCompatActivity implements View.OnClickListener {
    private SoundPool soundPool;

    private Button aButton;
    private Button bBButton;
    private Button bButton;
    private Button cButton;
    private Button cCButton;
    private Button dButton;
    private Button dDButton;
    private Button eButton;
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
    private Note[] noteScale;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        widgets();
        initializeSoundPool();
        listeners();




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

        noteScale = new Note[] {ANote,BbNote,BNote,CNote,CCNote,DNote,DDNote,ENote};




    }

    private void widgets() {
        aButton = findViewById(R.id.button_main_A);
        bBButton = findViewById(R.id.button_main_Bb);
        bButton = findViewById(R.id.button_main_B);
        cButton = findViewById(R.id.button_main_C);
        cCButton = findViewById(R.id.button_main_CC);
        dButton = findViewById(R.id.button_main_D);
        dDButton = findViewById(R.id.button_main_DD);
        eButton = findViewById(R.id.button_main_E);
        song = findViewById(R.id.button_main_song);
    }
    private void delay(int millisDelay){
        try{
            Thread.sleep(millisDelay);

        }catch (InterruptedException e){
            e.printStackTrace();
        }
    }

    private void listeners() {
        aButton.setOnClickListener(new View.OnClickListener() {
                                    @Override
                                    public void onClick(View view) {

                                        if (loaded) {
                                            soundPool.play(ANote.getSoundId(), 1, 1, 1, 0, 1f);
                                            Log.e("Test", "Played sound");
                                        }
                                    }


                                    });
        bButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                if (loaded) {
                    soundPool.play(BNote.getSoundId(), 1, 1, 1, 0, 1f);
                    Log.e("Test", "Played sound");
                }
            }


        });
        cButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                if (loaded) {
                    soundPool.play(CNote.getSoundId(), 1, 1, 1, 0, 1f);
                    Log.e("Test", "Played sound");
                }
            }


        });
        dButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                if (loaded) {
                    soundPool.play(DNote.getSoundId(), 1, 1, 1, 0, 1f);
                    Log.e("Test", "Played sound");
                }
            }


        });
        eButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                if (loaded) {
                    soundPool.play(ENote.getSoundId(), 1, 1, 1, 0, 1f);
                    Log.e("Test", "Played sound");
                }
            }


        });
        bBButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                if (loaded) {
                    soundPool.play(BbNote.getSoundId(), 1, 1, 1, 0, 1f);
                    Log.e("Test", "Played sound");
                }
            }


        });
        cCButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                if (loaded) {
                    soundPool.play(CCNote.getSoundId(), 1, 1, 1, 0, 1f);
                    Log.e("Test", "Played sound");
                }
            }


        });
        dDButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (loaded) {
                    soundPool.play(DDNote.getSoundId(), 1, 1, 1, 0, 1f);
                    Log.e("Test", "Played sound");
                }
            }});
            song.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    if (loaded) {
                        Log.d("LOOK AT ME", "onClick: " + Arrays.toString(noteScale));
                        for(int i = 0; i < noteScale.length; i++ ) {soundPool.play(noteScale[i].getSoundId(), 1,1,1,0,1);
                            delay(noteScale[i].getDelay() );
                        }
                        Log.e("Test", "Played sound");
                    }
                }


        });
                                }



    @Override
    public void onClick(View view) {
        switch(view.getId()){
            case R.id.button_main_song:
            { for(int i = 0; i < noteScale.length; i++ ) {soundPool.play(noteScale[i].getSoundId(), 1,1,1,0,1);
                delay(noteScale[i].getDelay() );
            }}
        }
    }
}









