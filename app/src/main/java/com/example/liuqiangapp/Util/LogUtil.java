package com.example.liuqiangapp.Util;

import android.util.Log;

public class LogUtil{
    public static final boolean DEBUG = true;
    public static final String APP_TAG = FunctionUtil.getAppName();

    public static void v(String tag,String msg){
        if(DEBUG){
            Log.v(APP_TAG+"  ："+tag, msg);
        }
    }

    public static void d(String tag,String msg){
        if(DEBUG){
            Log.d(APP_TAG+"  ："+tag, msg);
        }
    }

    public static void i(String tag,String msg){
        if(DEBUG){
            Log.i(APP_TAG+"  ："+tag, msg);
        }
    }

    public static void w(String tag,String msg){
        if(DEBUG){
            Log.w(APP_TAG+"  ："+tag, msg);
        }
    }

    public static void e(String tag,String msg){
        if(DEBUG){
            Log.e(APP_TAG+"  ："+tag, msg);
        }
    }
}
