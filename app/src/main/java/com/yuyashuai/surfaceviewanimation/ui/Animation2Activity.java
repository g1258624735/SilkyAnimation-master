package com.yuyashuai.surfaceviewanimation.ui;

import android.graphics.Bitmap;
import android.graphics.drawable.AnimationDrawable;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.support.v4.content.ContextCompat;
import android.support.v7.app.AppCompatActivity;
import android.widget.Button;
import android.widget.ImageView;

import com.yuyashuai.surfaceviewanimation.R;
import com.yuyashuai.surfaceviewanimation.utils.FrameAnimationUtil;

/**
 * @author gxj 2018-6-27 15:43:51
 */
public class Animation2Activity extends AppCompatActivity {
    private Button btnStartFile;
    private Button btnStop;
    private ImageView img;
    private FrameAnimationUtil myFrameAnimation;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.animation_2_layout);
//        Debug.startMethodTracing("animation_2");
        initView();
        btnStartFile.setOnClickListener(view -> {
            if (myFrameAnimation != null) {
                myFrameAnimation.stop();
                myFrameAnimation.start();
            }
        });
        btnStop.setOnClickListener(view -> {
            if (myFrameAnimation != null)
                myFrameAnimation.stop();
        });
        myFrameAnimation = new FrameAnimationUtil();
        Drawable drawable = ContextCompat.getDrawable(this, R.drawable.frame_animation);
        myFrameAnimation.setAnimationDrawable((AnimationDrawable) drawable);
        img.setImageDrawable(myFrameAnimation.getAnimationDrawable());
        if (myFrameAnimation != null) {
            myFrameAnimation.stop();
            myFrameAnimation.start();
        }
    }

    private void initView() {
        img = findViewById(R.id.img);
        btnStartFile = findViewById(R.id.btn_start_file);
        btnStop = findViewById(R.id.btn_stop);
    }

    @Override
    protected void onStop() {
        super.onStop();
        if (myFrameAnimation != null) {
            myFrameAnimation.stop();
            AnimationDrawable animationDrawable = myFrameAnimation.getAnimationDrawable();
            if (animationDrawable != null) {
                for (int i = 0; i < animationDrawable.getNumberOfFrames(); i++) {
                    Drawable frame = animationDrawable.getFrame(i);
                    if (frame != null && frame instanceof BitmapDrawable && ((BitmapDrawable) frame).getBitmap() != null && !((BitmapDrawable) frame).getBitmap().isRecycled()) {
//                        ((BitmapDrawable) frame).getBitmap().recycle();  不用直接 recycle()交给提醒去做 防止内存抖动
                        Bitmap bitmap = ((BitmapDrawable) frame).getBitmap();
                        bitmap = null;
                    }
                    if (frame != null) {
                        frame.setCallback(null);
                    }
                }
                animationDrawable.setCallback(null);
            }
            myFrameAnimation.setAnimationDrawable(null);
            myFrameAnimation = null;
        }

        if (img != null) {
            img.setImageDrawable(null);
        }
//        Debug.stopMethodTracing();
    }

    @Override
    protected void onDestroy() {

        super.onDestroy();
    }
}
