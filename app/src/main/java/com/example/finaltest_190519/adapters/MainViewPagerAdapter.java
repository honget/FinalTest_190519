package com.example.finaltest_190519.adapters;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentStatePagerAdapter;

import com.example.finaltest_190519.fragments.BankFragment;
import com.example.finaltest_190519.fragments.MyinfoFragment;
import com.example.finaltest_190519.fragments.NotiFragment;

public class MainViewPagerAdapter extends FragmentStatePagerAdapter {

    int mNumOfTabs;

    public BankFragment bankFragment= null;;
    public MyinfoFragment myinfoFragment= null;
    public NotiFragment notiFragment= null;

    public MainViewPagerAdapter(FragmentManager fm, int numOfTabs){
        super(fm);
        mNumOfTabs = numOfTabs;
    }

    @Override
    public Fragment getItem(int position) {

        Fragment fr = null;

        if(position == 0){

            if(myinfoFragment == null){
                myinfoFragment = new MyinfoFragment();
            }
            return myinfoFragment;
        }else if(position == 1){
            if(notiFragment == null){
                notiFragment = new NotiFragment();
            }
            return notiFragment;
        }else {
            if(bankFragment == null) {
                bankFragment = new BankFragment();
            }
            return bankFragment;
        }

    }

    @Override
    public int getCount() {
        return mNumOfTabs;
    }

}
