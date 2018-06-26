package com.yuyashuai.surfaceviewanimation;

import android.graphics.drawable.AnimationDrawable;
import android.os.Handler;

/**
 * Created by Will on 2018/4/24.
 */
public class FrameAnimationUtil {
    private Handler mHandler;
    private Runnable mRunnable;
    private OnFrameAnimationListener mListener;
    private AnimationDrawable mAnimationDrawable;

    public FrameAnimationUtil() {
        mHandler = new Handler();
        mRunnable = new Runnable() {
            @Override
            public void run() {
                if (mAnimationDrawable != null) {
                    if (mAnimationDrawable.getFrame(mAnimationDrawable.getNumberOfFrames() - 1) != mAnimationDrawable.getCurrent()) {
                        initHandler();
                    } else {
                        unRunning();
                    }
                }

            }
        };
    }

    public void setAnimationDrawable(AnimationDrawable animationDrawable) {
        mAnimationDrawable = animationDrawable;
    }

    public AnimationDrawable getAnimationDrawable() {
        return mAnimationDrawable;
    }

    public void start() {
        if (mAnimationDrawable != null) {
            mAnimationDrawable.start();
        }
        initHandler();
        if (mListener != null) {
            mListener.onStart();
        }
    }

    public void stop() {
        if (mAnimationDrawable != null) {
            mAnimationDrawable.stop();
        }
        unRunning();
    }

    private void unRunning() {
        if (mListener != null) {
            mListener.onFinish();
        }
        mHandler.removeCallbacks(mRunnable);
    }

    private void initHandler() {
        mHandler.postDelayed(mRunnable, 33);
    }

    public void setOnFrameAnimationListener(OnFrameAnimationListener listener) {
        mListener = listener;
    }

    public interface OnFrameAnimationListener {
        void onStart();

        void onFinish();
    }
}
