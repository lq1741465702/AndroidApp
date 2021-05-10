package com.example.liuqiangapp.chapter04;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.TextView;

import com.example.liuqiangapp.R;
public class Chapter04JumpFirstActivity extends AppCompatActivity {
    private static final String TAG = "Chapter04JumpFirstActiv";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_chapter04_jump_first);
        TextView tv_login = findViewById(R.id.chapter04_act_login);
        tv_login.setText(TAG);
    }
}