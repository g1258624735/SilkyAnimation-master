package com.yuyashuai.surfaceviewanimation;

import android.os.Bundle;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.widget.Button;
import android.widget.ImageView;

import java.io.IOException;

import pl.droidsonroids.gif.GifDrawable;
import pl.droidsonroids.gif.GifImageView;

/**
 * @author gxj 2016-11-27 15:43:51
 * gif 图片播放
 */
public class Animation5Activity extends AppCompatActivity {
    private Button btnStartFile;
    private Button btnStop;
    private GifImageView guideImageView;//播放动画的imageView
    private GifDrawable gifDrawable = null;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.animation_5_layout);
//        Debug.startMethodTracing("animation_3");
        initView();
        btnStartFile.setOnClickListener(view -> {
            if (gifDrawable != null) {
                gifDrawable.start();
            }
        });
        btnStop.setOnClickListener(view -> {
            if (gifDrawable != null) {
                gifDrawable.stop();
            }
        });
        try {
            gifDrawable = new GifDrawable(getAssets(), "anminaition.gif");
        } catch (IOException e) {
            e.printStackTrace();
        }
        if (gifDrawable != null) {
            guideImageView.setImageDrawable(gifDrawable);
        }
    }

    private void initView() {
        guideImageView = findViewById(R.id.iv_main);
        btnStartFile = findViewById(R.id.btn_start_file);
        btnStop = findViewById(R.id.btn_stop);
    }

    @Override
    protected void onStop() {
//        Debug.stopMethodTracing();
        super.onStop();
    }
}
