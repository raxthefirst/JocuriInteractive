package com.radustan.jocuriinteractive;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.Context;
import android.media.AudioManager;
import android.os.Bundle;
import android.provider.MediaStore;
import android.util.DisplayMetrics;
import android.widget.SeekBar;
import android.widget.Switch;
import android.widget.TextView;

public class Setari extends AppCompatActivity {

    @SuppressLint("UseSwitchCompatOrMaterialCode") ///DE LA TTS

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_setari);

        TextView txtVolum = findViewById(R.id.txtVolum);
        TextView txtAudio = findViewById(R.id.txtAudio);
        SeekBar seekBarVolum = findViewById(R.id.seekBarVolum);
        Switch tts = (Switch) findViewById(R.id.TTS);

        DisplayMetrics displayMetrics = new DisplayMetrics();
        getWindowManager().getDefaultDisplay().getMetrics(displayMetrics);
        int heightbtn = displayMetrics.heightPixels;
        int widthbtn = displayMetrics.widthPixels;

        txtVolum.setTextSize(widthbtn / 25);
        txtAudio.setTextSize(widthbtn / 15);

        tts.setTextSize(widthbtn/25);
        tts.setSwitchPadding(widthbtn/30);
        tts.setChecked(true);
        Boolean ttsswitchState = tts.isChecked();

        seekBarVolum.getLayoutParams().width=widthbtn / (25/10);
        seekBarVolum.getLayoutParams().height=heightbtn / 20;

        AudioManager audioManager = (AudioManager) getSystemService(Context.AUDIO_SERVICE);

        int maxVolume = audioManager.getStreamMaxVolume(AudioManager.STREAM_MUSIC);
        int curVolume = audioManager.getStreamVolume(AudioManager.STREAM_MUSIC);
        seekBarVolum.setMax(maxVolume);
        seekBarVolum.setProgress(curVolume);

        seekBarVolum.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
                audioManager.setStreamVolume(AudioManager.STREAM_MUSIC, progress, 0);
            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {

            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {

            }
        });

    }

    @Override
    public void finish() {
        super.finish();
        overridePendingTransition(R.anim.slide_in_left, R.anim.slide_out_right);
    }

}