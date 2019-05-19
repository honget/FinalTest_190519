package com.example.finaltest_190519.fragments;

import android.databinding.DataBindingUtil;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.finaltest_190519.R;

import com.example.finaltest_190519.databinding.FragmentNotiBinding;

public class NotiFragment extends Fragment {

    public FragmentNotiBinding binding;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

        binding = DataBindingUtil.inflate(inflater, R.layout.fragment_noti, container, false);
        return binding.getRoot();


    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);


//        binding.homeTxtV.setText("홈 화면에 오신걸 환영~");
    }
}
