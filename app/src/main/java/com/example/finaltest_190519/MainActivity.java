package com.example.finaltest_190519;

import android.databinding.DataBindingUtil;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.example.finaltest_190519.databinding.ActivityMainBinding;

public class MainActivity extends BaseActivity {

    ActivityMainBinding mainAct;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        bindViews();
        setupEvents();
        setupEvents();
    }

    @Override
    public void setupEvents() {

    }

    @Override
    public void setValues() {

    }

    @Override
    public void bindViews() {
        mainAct = DataBindingUtil.setContentView(this, R.layout.activity_main);
    }
}
