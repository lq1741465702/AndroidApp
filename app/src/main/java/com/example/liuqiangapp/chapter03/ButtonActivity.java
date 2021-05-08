package com.example.liuqiangapp.chapter03;

import android.graphics.Color;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.example.liuqiangapp.R;

public class ButtonActivity extends AppCompatActivity {
    Boolean showStatus;
    private static final String TAG = "ButtonActivity";
    Button longButton;
    Button btnEnable;
    Button btnShow;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_button);
        showStatus = true;
        longButton = (Button) findViewById(R.id.on_long_click);
        btnEnable = (Button) findViewById(R.id.btn_enable);
        btnShow = (Button) findViewById(R.id.btn_show);
    }

    @Override
    protected void onResume() {
        super.onResume();
        Log.d(TAG, "onResume: showStatus= "+showStatus);
        longButton.setOnLongClickListener(new View.OnLongClickListener() {
            @Override
            public boolean onLongClick(View v) {
                Toast longClickToast = Toast.makeText(getApplicationContext(),"点击了长按钮事件",Toast.LENGTH_LONG);
                longClickToast.show();
                return true;
            }
        });

        btnEnable.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Log.d(TAG, "onLongClick: ");
                if (showStatus){
                    Log.d(TAG,"禁用按钮");
                    btnEnable.setText("点击启用");
                    btnShow.setEnabled(false);
                    btnShow.setTextColor(Color.GRAY);
                    btnShow.setText("已禁用");
                    showStatus=false;
                }else {
                    Log.d(TAG,"启用按钮");
                    btnEnable.setText("点击禁用");
                    btnShow.setEnabled(true);
                    btnShow.setTextColor(Color.GREEN);
                    btnShow.setText("已启用");
                    showStatus=true;
                }
            }
        });

        btnShow.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast showToast = Toast.makeText(getApplicationContext(),"点击了按钮",Toast.LENGTH_LONG);
                showToast.show();
            }
        });
    }
}