package eo.cn.yxwuliu.activity;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.ObjectAnimator;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.ImageView;

import eo.cn.yxwuliu.R;
import eo.cn.yxwuliu.util.ActivityUtil;


/**
 * Created by Administrator on 2017/4/27.
 */

public class SplashActivity extends AppCompatActivity {
    private ImageView mIv;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash);
        initUI();
    }

    protected void initUI() {
        mIv = (ImageView) findViewById(R.id.iv_logo);
        ObjectAnimator animator = ObjectAnimator.ofFloat(mIv, "alpha", 0.5f, 1.0f);
        animator.setDuration(2000);
        animator.addListener(new AnimatorListenerAdapter() {
            @Override
            public void onAnimationEnd(Animator animation) {

                ActivityUtil.StartActivity(SplashActivity.this, MainActivity.class, true);
            }
        });
        animator.start();
    }

}
