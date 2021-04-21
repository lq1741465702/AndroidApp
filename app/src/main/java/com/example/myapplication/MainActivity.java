package com.example.myapplication;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.appcompat.app.AppCompatActivity;
import com.example.myapplication.Util.*;

public class MainActivity extends AppCompatActivity {
    private static final String TAG = "MainActivity";
    public Context mCotext;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mCotext=getApplicationContext();
        FunctionUtil.getAppName(mCotext);
        TextView main_hello = findViewById(R.id.main_hello);
        TextView main_hello_dp = findViewById(R.id.mian_hello_dp);
        TextView main_hello_sp = findViewById(R.id.mian_hello_sp);
        TextView main_hello_px = findViewById(R.id.mian_hello_px);
        LinearLayout mainLinearLayout = findViewById(R.id.mainLinearLayout);
//        mainLinearLayout.setBackgroundColor(getResources().getColor(R.color.purple_700));
//        main_hello.setText("3秒后跳入Ac3");

        main_hello_px.setTextColor(getResources().getColor(R.color.purple_200));
        main_hello_sp.setTextColor(getResources().getColor(R.color.black));
        main_hello_dp.setTextColor(getResources().getColor(R.color.green));
        main_hello_sp.setBackgroundColor(getResources().getColor(R.color.white));

        //获取main_hello_dp的布局参数(包含宽度和高度)
        ViewGroup.LayoutParams params = main_hello_dp.getLayoutParams();
        //修改布局参数中的宽度数值，注意默认px单位，需要把dp数值转为px数值
        params.width = FunctionUtil.dip2px(this,300);
        main_hello_dp.setLayoutParams(params);

    }

    @Override
    protected void onResume() {
        super.onResume();
        //goMain3Activity();
    }

    private void goMain3Activity(){
        new Handler().postDelayed(mGoMain3,3000);
    }

    private Runnable mGoMain3 = new Runnable() {
        @Override
        public void run() {
            startActivity(new Intent(MainActivity.this, MainActivity2.class));
        }
    };





}