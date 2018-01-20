package com.example.shaybuzz.beatbox;

import java.io.File;

/**
 * Created by shaybuzz on 20/01/2018.
 */

class Sound {
    private String name;
    private String mAssetPath;

    public Sound(String assetPath) {
        mAssetPath = assetPath;
        String[] components = assetPath.split(File.pathSeparator);
        String filename = components[components.length - 1];
        name = filename.replace(".wav", "");
    }
    public String getAssetPath() {
        return mAssetPath;
    }
    public String getName() {
        return name;
    }
}
