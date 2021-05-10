package com.example.liuqiangapp.chapter04;

import androidx.appcompat.app.AppCompatActivity;
import com.example.liuqiangapp.R;

import android.content.pm.ActivityInfo;
import android.content.pm.PackageManager;
import android.os.Bundle;
import android.widget.TextView;

public class Chapter04MetaDataActivity extends AppCompatActivity {
    TextView tv_meta;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_chapter04_meta_data);
        tv_meta = findViewById(R.id.chapter04_metadata_weather);
        showMetaData();
    }


    private void showMetaData(){
        try {
            PackageManager pm = getPackageManager();//获取应用包管理器
            //从应用宝管理器中获取当前的活动信息
            ActivityInfo act = pm.getActivityInfo(getComponentName(),PackageManager.GET_META_DATA);
            Bundle bundle = act.metaData;//获取活动附加的元数据信息
            String value = bundle.getString("weather");//从包裹中取出名为weather的字符串
            tv_meta.setText("来自元数据信息：今天的天气是"+value);
        } catch (PackageManager.NameNotFoundException e) {
            e.printStackTrace();
        }
    }
}