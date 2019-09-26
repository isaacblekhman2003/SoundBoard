package com.example.soundboard;

public class Note {
    private int soundId;
    private int delay;

    public Note(int soundId, int delay) {
        this.soundId = soundId;
        this.delay = delay;
    }

    public int getSoundId(){
        return soundId;

    }
    public int getDelay(){
        return delay;
    }


    @Override
    public String toString() {
        return "Note{" +
                "soundId=" + soundId +
                ", delay=" + delay +
                '}';
    }
}
