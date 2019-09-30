package com.example.soundboard;

import android.media.AudioManager;
import android.media.SoundPool;
import android.media.SoundPool.OnLoadCompleteListener;
import android.os.Bundle;
import android.util.Log;
import android.view.View;

import androidx.appcompat.app.AppCompatActivity;

import android.widget.Button;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

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
    private Button clear;
    private Button song;
    private Button buildYourOwn;
    boolean loaded = false;
    private boolean isloaded;
    private Note ANote;  // camelCase for all variables & methods
    private Note BbNote;
    private Note BNote;
    private Note CNote;
    private Note CCNote;
    private Note DNote;
    private Note DDNote;
    private Note ENote;
    private Note[] noteScale;
    private Song buildyourown;
    private Map<Integer, Note> noteMap;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        widgets();
        initializeSoundPool();
        listeners();
    }

    private void initializeSoundPool() {

        noteMap = new HashMap<>();
        this.setVolumeControlStream(AudioManager.STREAM_MUSIC);
        soundPool = new SoundPool(10, AudioManager.STREAM_MUSIC, 0);
        soundPool.setOnLoadCompleteListener(new OnLoadCompleteListener() {
            @Override
            public void onLoadComplete(SoundPool soundPool, int sampleId,
                                       int status) {
                loaded = true;
            }
        });

        ANote = new Note(soundPool.load(this, R.raw.scalea, 1), 100);
        BbNote = new Note(soundPool.load(this, R.raw.scalebb, 1), 100);
        BNote = new Note(soundPool.load(this, R.raw.scaleb, 1), 100);
        CNote = new Note(soundPool.load(this, R.raw.scalec, 1), 100);
        CCNote = new Note(soundPool.load(this, R.raw.scalecs, 1), 100);
        DNote = new Note(soundPool.load(this, R.raw.scaled, 1), 100);
        DDNote = new Note(soundPool.load(this, R.raw.scaleds, 1), 100);
        ENote = new Note(soundPool.load(this, R.raw.scalee, 1), 100);

        noteMap.put(aButton.getId(), ANote);
        noteMap.put(bBButton.getId(), BbNote);
        noteMap.put(bButton.getId(), BNote);
        noteMap.put(cButton.getId(), CNote);
        noteMap.put(cCButton.getId(), CCNote);
        noteMap.put(dButton.getId(), DNote);
        noteMap.put(dDButton.getId(), DDNote);
        noteMap.put(eButton.getId(), ENote);
        noteScale = new Note[]{ANote, BbNote, BNote, CNote, CCNote, DNote, DDNote, ENote};
        buildyourown = new Song();
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
        buildYourOwn = findViewById(R.id.button_main_play);
        clear = findViewById(R.id.button_main_clear);
    }

    private void delay(int millisDelay) {
        try {
            Thread.sleep(millisDelay);

        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    private void listeners() {
        KeyboardListener keyboardListener = new KeyboardListener();
        aButton.setOnClickListener(keyboardListener);
        bButton.setOnClickListener(keyboardListener);
        cButton.setOnClickListener(keyboardListener);
        dButton.setOnClickListener(keyboardListener);
        eButton.setOnClickListener(keyboardListener);
        bBButton.setOnClickListener(keyboardListener);
        cCButton.setOnClickListener(keyboardListener);
        dDButton.setOnClickListener(keyboardListener);
        song.setOnClickListener(this);
        clear.setOnClickListener(this);
        buildYourOwn.setOnClickListener(this);
    }


    @Override
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.button_main_song: {
                for (int i = 0; i < noteScale.length; i++) {
                    soundPool.play(noteScale[i].getSoundId(), 1, 1, 1, 0, 1);
                    delay(noteScale[i].getDelay());
                }
                break;
            }
            case R.id.button_main_clear : {

                    buildyourown.newSong();
                break;
            }
            case R.id.button_main_play : {
                for (int i = 0; i < buildyourown.getSongLength(); i++) {
                    soundPool.play(buildyourown.getNote(i).getSoundId(), 1, 1, 1, 0, 1);
                    delay(buildyourown.getNote(i).getDelay());
                }
                break;


            }

            }


        }


    // make a map of all the notes
    // get the value of the note from the map based on what was clicked
    // play the note, add it to your playback list
    // this class listens for all the individual note buttons, not the scale & play
    private class KeyboardListener implements View.OnClickListener {

        @Override
        public void onClick(View view) {
            Note note = noteMap.get(view.getId());
            soundPool.play(note.getSoundId(), 1, 1, 1, 0, 1f);
            buildyourown.addNote(note);
        }
    }

}









