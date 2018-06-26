package com.yuyashuai.surfaceviewanimation;

import android.os.Bundle;
import android.os.Debug;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.view.SurfaceView;
import android.widget.Button;

import com.yuyashuai.silkyanimation.SilkyAnimation;

/**
 * @author gxj 2018-11-27 15:43:51
 * SilkyAnimation 框架测试帧动画
 */
public class Animation1Activity extends AppCompatActivity {


    private SilkyAnimation silkyAnimation;
    private Button btnStartFile;
    private Button btnStop;
    private SurfaceView mSurfaceView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.animation_1_layout);
//        Debug.startMethodTracing("animation_1");
        initView();
        silkyAnimation = new SilkyAnimation.Builder(mSurfaceView)
                .setCacheCount(5)
                .setFrameInterval(33)
                .setSupportInBitmap(true)
                .setScaleType(SilkyAnimation.SCALE_TYPE_FIT_CENTER)
                .setRepeatMode(SilkyAnimation.MODE_INFINITE)
                .build();
        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                silkyAnimation.start("daku");
            }
        }, 100);

        //如果需要在onCreate方法中直接调用开始，通过handler.postDelayed添加一个时延
        //if you call start() in onCreate method,use handler.postDelayed add a time delay to call it.
        btnStartFile.setOnClickListener(view -> silkyAnimation.start("daku"));
        btnStop.setOnClickListener(view -> silkyAnimation.stop());
        silkyAnimation.setAnimationStateListener(new SilkyAnimation.AnimationStateListener() {
            @Override
            public void onStart() {

            }

            @Override
            public void onFinish() {

            }
        });
    }

    @Override
    protected void onStart() {
        super.onStart();

    }

    private void initView() {
        mSurfaceView = findViewById(R.id.sv_main);
        btnStartFile = findViewById(R.id.btn_start_file);
        btnStop = findViewById(R.id.btn_stop);
    }

    @Override
    protected void onStop() {
//        Debug.stopMethodTracing();
        super.onStop();
        if (silkyAnimation != null) {
            silkyAnimation.stop();
        }
    }
}
