package com.yuyashuai.surfaceviewanimation.ui;

import android.os.Bundle;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.widget.Button;
import android.widget.ImageView;

import com.yuyashuai.surfaceviewanimation.R;
import com.yuyashuai.surfaceviewanimation.utils.LazyLoadingAnimationDrawable;
import com.yuyashuai.surfaceviewanimation.utils.ReversibleAnimationDrawable;

/**
 * @author yuyashuai 2016-11-27 15:43:51
 * AnimationDrawable 自定义 AnimationDrawable 开始行 帧动画播放的优化
 */
public class Animation4Activity extends AppCompatActivity {
    private Button btnStartFile;
    private Button btnStop;
    private ImageView guideImageView;//播放动画的imageView
    private LazyLoadingAnimationDrawable animationDrawable;  //指南Frame动画

    private void startGuideAnim() {
        if (guideImageView != null && animationDrawable != null) {
            animationDrawable.start();
        }
    }

    private void stopGuideAnim() {
        if (guideImageView != null && animationDrawable != null) {
            animationDrawable.stop();
        }
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.animation_3_layout);
//        Debug.startMethodTracing("animation_3");
        initView();
        new Handler().postDelayed(this::startGuideAnim, 40);
        btnStartFile.setOnClickListener(view -> {
            startGuideAnim();
        });
        btnStop.setOnClickListener(view -> stopGuideAnim());
        ReversibleAnimationDrawable anim = LazyLoadingAnimationDrawable
                .loadFromResource(getResources(), R.drawable.frame_animation);
        guideImageView.setImageDrawable(anim);
        animationDrawable = (LazyLoadingAnimationDrawable) guideImageView.getDrawable();
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
