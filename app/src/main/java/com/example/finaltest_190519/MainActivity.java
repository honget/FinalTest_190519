package com.example.finaltest_190519;

import android.databinding.DataBindingUtil;
import android.support.design.widget.TabLayout;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.example.finaltest_190519.adapters.MainViewPagerAdapter;
import com.example.finaltest_190519.adapters.NotiAdapter;
import com.example.finaltest_190519.databinding.ActivityMainBinding;
import com.example.finaltest_190519.datas.NotiInfo;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends BaseActivity {

    /**
     *  제약사항 1. 탭 레이아웃 사용
     *  2. 각각의 탭의 내요은 Fra
     */

//    제약사항 1. 탭 레이아웃 사용
//    2. 각각의 탭의 내용은 Fragment를 활용해서 구현
//    3. 뷰페이저를 활용해 생성된 프래그먼트 2개를 페이징 처리

    ActivityMainBinding act;

    MainViewPagerAdapter mvpa;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        bindViews();
        setupEvents();
        setValues();
    }

    @Override
    public void setupEvents() {

        act.tabLayout.addOnTabSelectedListener(new TabLayout.ViewPagerOnTabSelectedListener(act.fragViewPager));
        act.fragViewPager.addOnPageChangeListener(new TabLayout.TabLayoutOnPageChangeListener(act.tabLayout));

    }

    @Override
    public void setValues() {

        act.tabLayout.addTab(act.tabLayout.newTab().setText("내 프로필"));
        act.tabLayout.addTab(act.tabLayout.newTab().setText("공지사항"));

        mvpa = new MainViewPagerAdapter(getSupportFragmentManager(), act.tabLayout.getTabCount());
        act.fragViewPager.setAdapter(mvpa);

    }

    @Override
    public void bindViews() {

        act = DataBindingUtil.setContentView(this, R.layout.activity_main);
    }

}
