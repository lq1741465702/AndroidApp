package com.example.liuqiangapp.chapter03;

import android.os.Bundle;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;

import com.example.liuqiangapp.R;

public class Chapter03MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_unit3);
        Button mbtn = (Button)findViewById(R.id.go_button);
    }
}