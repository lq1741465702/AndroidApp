package com.example.liuqiangapp.chapter04;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.example.liuqiangapp.R;

public class Chapter04ActionUriActivity extends AppCompatActivity {
    Button btnDial;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_chapter04_action_uri);
        btnDial = findViewById(R.id.btn_chapter04_dial);

        btnDial.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent mIntent = new Intent();
                mIntent.setAction(Intent.ACTION_DIAL);
                Uri uri = Uri.parse("tel:"+"10086");
                mIntent.setData(uri);
                startActivity(mIntent);
            }
        });

    }



}