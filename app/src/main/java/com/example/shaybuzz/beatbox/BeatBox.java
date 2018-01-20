package com.example.shaybuzz.beatbox;

import android.content.Context;
import android.content.res.AssetManager;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by shaybuzz on 21/01/2018.
 */

public class BeatBox {
    private static final String TAG = "BeatBox";
    private static final String SOUNDS_FOLDER = "sample_sounds";
    private AssetManager mAssets;
    private List<Sound> sounds = new ArrayList<>();

    public BeatBox(Context context) {
        mAssets = context.getAssets();
        loadSounds();
    }

    private void loadSounds() {
        try {
            String[] list = mAssets.list(SOUNDS_FOLDER);
            for (String item : list) {
                Sound sound = new Sound(SOUNDS_FOLDER + File.pathSeparator + item);
                sounds.add(sound);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public List<Sound> getSounds() {
        return sounds;
    }
}
