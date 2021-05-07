package com.example.liuqiangapp.Unit4;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.widget.TextView;

import com.example.liuqiangapp.R;

public class ActLifeActivity extends AppCompatActivity {
    private static final String TAG = "ActLifeActivity";
    private TextView mActStatus;

    private void refreshActLife(String actStatus){
        Log.d(TAG, "refreshActLife: "+actStatus);
        mActStatus.setText(actStatus);
    }

    @Override
    protected void onStart() {
        super.onStart();
        refreshActLife("onStart");
    }

    @Override
    protected void onStop() {
        super.onStop();
        refreshActLife("onStop");
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        refreshActLife("onDestroy");
    }

    @Override
    protected void onPause() {
        super.onPause();
        refreshActLife("onPause");
    }

    @Override
    protected void onResume() {
        super.onResume();
        refreshActLife("onResume");
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_act_life);
        mActStatus= findViewById(R.id.act_status);
        refreshActLife("onCreate");
    }
}