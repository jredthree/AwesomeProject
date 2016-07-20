package com.awesomeproject.module;

import android.widget.Toast;

import com.facebook.react.bridge.Callback;
import com.facebook.react.bridge.ReactApplicationContext;
import com.facebook.react.bridge.ReactContextBaseJavaModule;
import com.facebook.react.bridge.ReactMethod;
import com.facebook.react.uimanager.IllegalViewOperationException;

import java.util.HashMap;
import java.util.Map;

/**
 * author: smart
 * time: 2016/7/19
 */
public class ToastCustomModule extends ReactContextBaseJavaModule{

    private static final String DURATION_SHORT="SHORT";
    private static final String DURATION_LONG="LONG";

    public ToastCustomModule(ReactApplicationContext reactContext) {
        super(reactContext);
    }

    @Override
    public String getName() {
        return "ToastCustomAndroid";
    }

    @Override
    public Map<String, Object> getConstants() {
        final Map<String, Object> constants = new HashMap<>();
        constants.put(DURATION_SHORT, Toast.LENGTH_SHORT);
        constants.put(DURATION_LONG, Toast.LENGTH_LONG);
        return constants;
    }
    @ReactMethod
    public void show(String message,int duration){
        Toast.makeText(getReactApplicationContext(),message,duration).show();
    }

    @ReactMethod
    public void measureLayout(
            String message,
            int duration,
            Callback errorCallback,
            Callback successCallback){
        try {
            show(message,duration);
            successCallback.invoke(100, 100, 200, 200);
        } catch (IllegalViewOperationException e) {
            errorCallback.invoke(e.getMessage());
        }
    }
}
