package com.example.sageadvice;

import android.app.Application;

public class GlobalVariables extends Application {
    private int secretTrack = 0;

    public int getSecretTrack() {
        return secretTrack;
    }

    public void setSecretTrack(int secretTracks) {
        this.secretTrack = secretTracks;
    }
}
