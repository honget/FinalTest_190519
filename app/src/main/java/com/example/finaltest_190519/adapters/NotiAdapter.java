package com.example.finaltest_190519.adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import com.example.finaltest_190519.R;
import com.example.finaltest_190519.datas.NotiInfo;

import java.util.List;

public class NotiAdapter extends ArrayAdapter<NotiInfo> {

    Context context;
    List<NotiInfo> notiList;

    LayoutInflater inf;

    public NotiAdapter(Context context, List<NotiInfo> notiList){

        super(context, R.layout.noti_list_item, notiList);

        this.context = context;
        this.notiList = notiList;

        inf = LayoutInflater.from(context);
    }


    @Override
    public View getView(int position, View row, ViewGroup parent) {

        if(row == null){
            row = inf.inflate(R.layout.noti_list_item, null);
        }

        NotiInfo noti = notiList.get(position);

        TextView notiNumTxtV = row.findViewById(R.id.notiNumTxtV);
        TextView notiTitleTxtV = row.findViewById(R.id.notiTitleTxtV);

        notiNumTxtV.setText(noti.num);
        notiTitleTxtV.setText(noti.title);

        return row;
    }
}
