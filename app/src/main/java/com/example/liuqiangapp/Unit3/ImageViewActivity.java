package com.example.liuqiangapp.Unit3;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ImageButton;
import android.widget.Toast;

import com.example.liuqiangapp.R;

public class ImageViewActivity extends AppCompatActivity {
    private static final String TAG = "ImageViewActivity";
    ImageButton mImageButtonGreen ;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Log.d(TAG, "onCreate: ");
        setContentView(R.layout.activity_image_view);
        mImageButtonGreen = (ImageButton) findViewById(R.id.ib_green);

    }

    @Override
    protected void onResume() {
        super.onResume();
        Log.d(TAG, "onResume: ");
        mImageButtonGreen.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast mToast = Toast.makeText(getApplicationContext(),"click imageView",Toast.LENGTH_LONG);
                mToast.show();
            }
        });
    }
}