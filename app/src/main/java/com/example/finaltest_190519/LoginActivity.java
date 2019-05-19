package com.example.finaltest_190519;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.databinding.DataBindingUtil;
import android.os.Bundle;
import android.util.Log;
import android.view.View;

import com.example.finaltest_190519.databinding.ActivityLoginBinding;
import com.example.finaltest_190519.utills.CommectSever;
import com.example.finaltest_190519.utills.ContextUtill;

import org.json.JSONException;
import org.json.JSONObject;

public class LoginActivity extends BaseActivity {

    ActivityLoginBinding loginAct;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        bindViews();
        setValues();
        setupEvents();
    }

    @Override
    public void setupEvents() {

        loginAct.submitBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                String id = loginAct.usrIdEdt.getText().toString();
                String pw = loginAct.usrPwEdt.getText().toString();

                CommectSever.postRequestSingIn(mContext, id, pw, new CommectSever.JsonResponsHandler() {
                    @Override
                    public void onResponse(JSONObject json) {

                        try {
                            if(json.getInt("code") == 200){

                                JSONObject data = json.getJSONObject("data");
                                String token = data.getString("token");

                                ContextUtill.setUserToken(mContext, token);

                                moveMainPage(token);

                            }else{
                                AlertDialog.Builder alert = new AlertDialog.Builder(mContext);

                                alert.setTitle("로그인 실패");
                                alert.setMessage(json.getString("message"));
                                alert.setPositiveButton("확인", new DialogInterface.OnClickListener() {
                                    @Override
                                    public void onClick(DialogInterface dialog, int which) {
                                        loginAct.usrPwEdt.setText("");
                                    }
                                });

                                final AlertDialog.Builder finalAlert = alert;

                                runOnUiThread(new Runnable() {
                                    @Override
                                    public void run() {
                                        finalAlert.show();
                                    }
                                });
                            }
                        } catch (JSONException e) {
                            e.printStackTrace();
                        }

                    }
                });

            }
        });
    }

    @Override
    public void setValues() {

        String userToken =ContextUtill.getUserToken(mContext);

        Log.d("로그인 처리 : ", userToken);

        if(userToken != null){
            moveMainPage(userToken);
        }
    }

    public void moveMainPage(String userToken){

        Log.d("로그인 처리 : ", userToken);
        Intent intent = new Intent(mContext, MainActivity.class);
        intent.putExtra("USER_TOKEN", userToken);

        startActivity(intent);

        finish();
    }

    @Override
    public void bindViews() {
        loginAct = DataBindingUtil.setContentView(this, R.layout.activity_login);
    }
}
