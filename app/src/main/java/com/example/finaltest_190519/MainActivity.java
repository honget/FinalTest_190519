package com.example.finaltest_190519;

import android.databinding.DataBindingUtil;
import android.support.design.widget.TabLayout;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.example.finaltest_190519.adapters.MainViewPagerAdapter;
import com.example.finaltest_190519.databinding.ActivityMainBinding;

public class MainActivity extends BaseActivity {

    /**
     *  제약사항 1. 탭 레이아웃 사용
     *  2. 각각의 탭의 내요은 Fra
     */

    ActivityMainBinding mainAct;
    MainViewPagerAdapter mainViewPagerAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        bindViews();
        setupEvents();
        setupEvents();
    }

    @Override
    public void setupEvents() {

        // 화면 변경시 탭 변경
        mainAct.mainViewPager.addOnPageChangeListener(new TabLayout.TabLayoutOnPageChangeListener(mainAct.mainTab));

        mainAct.mainTab.addOnTabSelectedListener(new TabLayout.BaseOnTabSelectedListener() {
            @Override
            public void onTabSelected(TabLayout.Tab tab) {
                mainAct.mainViewPager.setCurrentItem(tab.getPosition());

            }

            @Override
            public void onTabUnselected(TabLayout.Tab tab) {

            }

            @Override
            public void onTabReselected(TabLayout.Tab tab) {

            }
        });

        int viewCurr = mainAct.mainViewPager.getCurrentItem();

        if(viewCurr == 0){

//            mainViewPagerAdapter.myinfoFragment.binding.myImgV;

            mainViewPagerAdapter.myinfoFragment.binding.myNameTxtV.setText("");
        }
    }

    @Override
    public void setValues() {
        mainAct.mainTab.addTab(mainAct.mainTab.newTab().setText("내 프로필"));
        mainAct.mainTab.addTab(mainAct.mainTab.newTab().setText("공지사항"));
        mainAct.mainTab.addTab(mainAct.mainTab.newTab().setText("은행목록"));

        mainViewPagerAdapter = new MainViewPagerAdapter(getSupportFragmentManager(), mainAct.mainTab.getTabCount());
        mainAct.mainViewPager.setAdapter(mainViewPagerAdapter);
    }

    @Override
    public void bindViews() {
        mainAct = DataBindingUtil.setContentView(this, R.layout.activity_main);
    }
}
