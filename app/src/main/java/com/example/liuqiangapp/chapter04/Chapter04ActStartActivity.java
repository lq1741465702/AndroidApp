package com.example.liuqiangapp.chapter04;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.TextView;

import com.example.liuqiangapp.R;
public class Chapter04ActStartActivity extends AppCompatActivity {
    private static final String TAG = "Chapter04ActStartActivi";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_chapter04_act_start);
        TextView tv_login = findViewById(R.id.chapter04_act_start);
        tv_login.setText(TAG);
    }
}