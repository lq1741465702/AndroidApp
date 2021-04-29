package com.example.liuqiangapp.Util;

import android.content.Context;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;

import com.example.liuqiangapp.MainActivity;

public class FunctionUtil {
    public static String AppName ="";
    private static final String TAG = "FunctionUtil";

    //根据手机分辨率从dp的单位转为px(像素)
    public static int dip2px (Context context , float dpValue){
        //获取手机当前的像素密度(1个dp对应几个px)
        float scale = context.getResources().getDisplayMetrics().density;
        LogUtil.d(TAG, "scale =  "+scale);
        return (int)(dpValue * scale + 0.5f);//四舍五入取整
    }


    public static String getAppName(){
        try {
            if (("").equals(AppName)){
            Context mContext =  MainActivity.getContext();
            PackageManager mPackageManager =mContext.getPackageManager();
            PackageInfo mPackageInfo = mPackageManager.getPackageInfo(mContext.getPackageName(),0);
            int labelRes = mPackageInfo.applicationInfo.labelRes;
            AppName = mContext.getResources().getString(labelRes);
            }
        } catch (PackageManager.NameNotFoundException e) {
            e.printStackTrace();
        }
        return AppName;
    }

}
