package com.example.liuqiangapp.chapter04;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.TextView;

import com.example.liuqiangapp.R;
public class Chapter04LoginInputActivity extends AppCompatActivity {
    private static final String TAG = "Chapter04LoginInputActi";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_chapter04_login_input);
        TextView tv_login = findViewById(R.id.chapter04_act_login);
        tv_login.setText(TAG);
    }
}