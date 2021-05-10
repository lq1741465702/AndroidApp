package com.example.liuqiangapp.chapter04;

import androidx.appcompat.app.AppCompatActivity;

import com.example.liuqiangapp.R;
import com.example.liuqiangapp.Util.FunctionUtil;

import android.os.Bundle;
import android.widget.Button;

import static com.example.liuqiangapp.MainActivity.getContext;

public class Chapter04MainActivity extends AppCompatActivity {
    private Button btnActLife,btnActUri,btnActMetadata;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_chapter04_main);
        btnActLife = findViewById(R.id.go_chapter04_ActLife);
        btnActUri = findViewById(R.id.go_chapter04_ActUri);
        btnActMetadata = findViewById(R.id.go_chapter04_ActMetadata);
    }


    @Override
    protected void onResume() {
        super.onResume();
        FunctionUtil.buttonJumpInterface(getContext(),btnActLife, Chapter04ActLifeActivity.class);
        FunctionUtil.buttonJumpInterface(getContext(),btnActUri,Chapter04ActionUriActivity.class);
        FunctionUtil.buttonJumpInterface(getContext(),btnActMetadata,Chapter04MetaDataActivity.class);
    }




}