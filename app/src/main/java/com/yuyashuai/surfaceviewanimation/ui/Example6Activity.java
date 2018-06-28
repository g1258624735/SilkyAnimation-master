package com.yuyashuai.surfaceviewanimation.ui;

import android.app.Activity;
import android.os.Bundle;
import android.widget.ImageView;

import com.yuyashuai.surfaceviewanimation.R;
import com.yuyashuai.surfaceviewanimation.utils.FasterAnimationsContainer;

public class Example6Activity extends Activity {

    FasterAnimationsContainer mFasterAnimationsContainer;
    private static final int[] IMAGE_RESOURCES = {R.drawable.daku_01, R.drawable.daku_02, R.drawable.daku_03, R.drawable.daku_04, R.drawable.daku_05, R.drawable.daku_06, R.drawable.daku_07, R.drawable.daku_08, R.drawable.daku_09, R.drawable.daku_10, R.drawable.daku_11, R.drawable.daku_12, R.drawable.daku_13, R.drawable.daku_14, R.drawable.daku_15, R.drawable.daku_16, R.drawable.daku_17, R.drawable.daku_18, R.drawable.daku_19, R.drawable.daku_20, R.drawable.daku_21, R.drawable.daku_22, R.drawable.daku_23, R.drawable.daku_24, R.drawable.daku_25, R.drawable.daku_26, R.drawable.daku_27, R.drawable.daku_28, R.drawable.daku_29, R.drawable.daku_30, R.drawable.daku_31, R.drawable.daku_32, R.drawable.daku_33, R.drawable.daku_34, R.drawable.daku_35, R.drawable.daku_36, R.drawable.daku_37, R.drawable.daku_38, R.drawable.daku_39, R.drawable.daku_40, R.drawable.daku_41, R.drawable.daku_42, R.drawable.daku_43, R.drawable.daku_44, R.drawable.daku_45, R.drawable.daku_46, R.drawable.daku_47, R.drawable.daku_48, R.drawable.daku_49, R.drawable.daku_50, R.drawable.daku_51, R.drawable.daku_52, R.drawable.daku_53, R.drawable.daku_54, R.drawable.daku_55, R.drawable.daku_56, R.drawable.daku_57, R.drawable.daku_58, R.drawable.daku_59, R.drawable.daku_60, R.drawable.daku_61, R.drawable.daku_62, R.drawable.daku_63, R.drawable.daku_64, R.drawable.daku_65, R.drawable.daku_66, R.drawable.daku_67, R.drawable.daku_68, R.drawable.daku_69, R.drawable.daku_70, R.drawable.daku_71, R.drawable.daku_72, R.drawable.daku_73, R.drawable.daku_74, R.drawable.daku_75, R.drawable.daku_76, R.drawable.daku_77, R.drawable.daku_78, R.drawable.daku_79, R.drawable.daku_80, R.drawable.daku_81, R.drawable.daku_82, R.drawable.daku_83, R.drawable.daku_84, R.drawable.daku_85, R.drawable.daku_86, R.drawable.daku_87, R.drawable.daku_88, R.drawable.daku_89, R.drawable.daku_90, R.drawable.daku_91, R.drawable.daku_92, R.drawable.daku_93, R.drawable.daku_94, R.drawable.daku_95, R.drawable.daku_96, R.drawable.daku_97, R.drawable.daku_98, R.drawable.daku_99};
    private static final int ANIMATION_INTERVAL = 100;// 200ms
    private ImageView imageView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.animation_6_layout);
        imageView = findViewById(R.id.iv_main);
    }

    @Override
    protected void onStart() {
        super.onStart();
        mFasterAnimationsContainer = FasterAnimationsContainer
                .getInstance(imageView);
        mFasterAnimationsContainer.addAllFrames(IMAGE_RESOURCES,
                ANIMATION_INTERVAL);
        mFasterAnimationsContainer.start();
    }

    @Override
    protected void onStop() {
        super.onStop();
        if (mFasterAnimationsContainer != null) {
            mFasterAnimationsContainer.stop();
        }
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
    }
}
