package com.awesomeproject.module;

import android.util.Log;

import com.facebook.react.bridge.ReactApplicationContext;
import com.facebook.react.bridge.ReactContextBaseJavaModule;
import com.facebook.react.bridge.ReactMethod;
import com.gizwits.gizwifisdk.enumration.XPGWifiErrorCode;
import com.xtremeprog.xpgconnect.XPGWifiSDK;
import com.xtremeprog.xpgconnect.XPGWifiSDKListener;

/**
 * author: smart
 * time: 2016/7/20
 */
public class LoginXpgModule extends ReactContextBaseJavaModule {

    XPGWifiSDKListener xpgWifiSDKListener = new XPGWifiSDKListener(){
        //注册用户回调
        public void didUserLogin(int result, String errorMessage, String uid,String token) {
            if (result== XPGWifiErrorCode.XPGWifiError_NONE) {
                Log.d("TAG","成功");

            } else {
                Log.d("TAG","失败");
            }
        }
    };

    public LoginXpgModule(ReactApplicationContext reactContext) {
        super(reactContext);
        //注册监听器
        XPGWifiSDK.sharedInstance().setListener(xpgWifiSDKListener);
    }

    @Override
    public String getName() {
        return "loginXpg";
    }

    @ReactMethod
    public void login(String userName,String password){
        XPGWifiSDK.sharedInstance().userLoginWithUserName(userName,password);
    }


}
