package com.example.erzhou2;

import android.os.Bundle;
import android.support.v4.app.FragmentManager;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.RadioButton;
import android.widget.RadioGroup;

import com.example.erzhou2.ui.Potho.PothoFragment;
import com.example.erzhou2.ui.Video.VideoFragment;


public class MainActivity extends AppCompatActivity {

    private FragmentManager fragmentManager;
    private PothoFragment pothoFragment;
    /**
     * 视频
     */
    private RadioButton mRbVidio;
    /**
     * 图片
     */
    private RadioButton mRbPotho;
    private RadioGroup mRg;
    private FrameLayout mFlContent;
    private int currentIndex = 1;
    private VideoFragment videoFragment;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initView();
        fragmentManager = getSupportFragmentManager();
        pothoFragment = new PothoFragment();
        videoFragment = new VideoFragment();
        fragmentManager.beginTransaction()
                .replace(R.id.flContent, videoFragment)
                .commit();
        mRbVidio.setChecked(true);
        //设置点击事件
        setLisenter();

    }

    private void setLisenter() {
        mRg.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {
                switch (checkedId) {
                    case R.id.rbVidio:
                        //首页
                        if (currentIndex == 1) {
                            return;
                        }
                        currentIndex = 1;
                        fragmentManager.beginTransaction().replace(R.id.flContent, videoFragment).commit();
                        break;

                    case R.id.rbPotho:
                        //首页
                        if (currentIndex == 2) {
                            return;
                        }
                        currentIndex = 2;
                        fragmentManager.beginTransaction().replace(R.id.flContent, pothoFragment).commit();
                        break;
                }
            }
        });

    }

    private void initView() {
        mRbVidio = (RadioButton) findViewById(R.id.rbVidio);

        mRbPotho = (RadioButton) findViewById(R.id.rbPotho);

        mRg = (RadioGroup) findViewById(R.id.rg);

        mFlContent = (FrameLayout) findViewById(R.id.flContent);
    }


}

