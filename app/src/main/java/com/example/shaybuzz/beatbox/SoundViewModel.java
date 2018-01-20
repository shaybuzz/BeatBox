package com.example.shaybuzz.beatbox;

import android.databinding.BaseObservable;
import android.databinding.Bindable;
import android.util.Log;
import android.view.View;

/**
 * Created by shaybuzz on 21/01/2018.
 */

public class SoundViewModel extends BaseObservable{
    private Sound sound;
    private BeatBox beatBox;

    public SoundViewModel(BeatBox beatBox){
        this.beatBox = beatBox;
    }

    public void setSound(Sound sound){
        this.sound = sound;
        notifyChange();
    }

    public Sound getSound() {
        return sound;
    }

    @Bindable
    public String getTitle(){
        return sound.getName();
    }

    public void onButtonClicked(View view){
        Log.d("###","### play sounds " + sound.getAssetPath());
    }
}
