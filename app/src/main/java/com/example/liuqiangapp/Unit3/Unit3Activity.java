package com.example.liuqiangapp.Unit3;

import android.os.Bundle;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;

import com.example.liuqiangapp.R;

public class Unit3Activity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_unit3);
        Button mbtn = (Button)findViewById(R.id.go_button);
    }
}