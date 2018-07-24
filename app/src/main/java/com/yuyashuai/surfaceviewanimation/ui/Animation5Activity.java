package com.yuyashuai.surfaceviewanimation.ui;

import android.os.Bundle;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.widget.Button;
import android.widget.ImageView;

import com.yuyashuai.surfaceviewanimation.R;

import java.io.IOException;

import pl.droidsonroids.gif.AnimationListener;
import pl.droidsonroids.gif.GifDrawable;
import pl.droidsonroids.gif.GifImageView;

/**
 * @author gxj 2016-11-27 15:43:51
 * gif 图片播放
 */
public class Animation5Activity extends AppCompatActivity {
    private Button btnStartFile;
    private Button btnStop;
    private GifImageView img1;//播放动画的imageView
    private GifImageView img2;//播放动画的imageView
    private GifImageView img3;//播放动画的imageView
    private GifImageView img4;//播放动画的imageView
    private GifImageView img5;//播放动画的imageView
    private GifDrawable gifDrawable1 = null;
    private GifDrawable gifDrawable2;
    private GifDrawable gifDrawable3;
    private GifDrawable gifDrawable4;
    private GifDrawable gifDrawable5;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.animation_5_layout);
//        Debug.startMethodTracing("animation_3");
        initView();
        btnStartFile.setOnClickListener(view -> {
        });
        btnStop.setOnClickListener(view -> {
        });
        try {
            gifDrawable1 = new GifDrawable(getAssets(), "1.gif");
            gifDrawable2 = new GifDrawable(getAssets(), "2.gif");
            gifDrawable3 = new GifDrawable(getAssets(), "3.gif");
            gifDrawable4 = new GifDrawable(getAssets(), "Animated-Flag-Delaware.gif");
            gifDrawable5 = new GifDrawable(getAssets(), "led7.gif");
        } catch (IOException e) {
            e.printStackTrace();
        }
        img1.setImageDrawable(gifDrawable1);
        img2.setImageDrawable(gifDrawable2);
        img3.setImageDrawable(gifDrawable3);
        img4.setImageDrawable(gifDrawable4);
        img5.setImageDrawable(gifDrawable5);
    }

    private void initView() {
        img1 = findViewById(R.id.iv_1);
        img2 = findViewById(R.id.iv_2);
        img3 = findViewById(R.id.iv_3);
        img4 = findViewById(R.id.iv_4);
        img5 = findViewById(R.id.iv_5);
        btnStartFile = findViewById(R.id.btn_start_file);
        btnStop = findViewById(R.id.btn_stop);
    }

    @Override
    protected void onStop() {
//        Debug.stopMethodTracing();
        super.onStop();
    }
}
