package com.awesomeproject;

import android.app.Application;
import android.util.Log;

import com.awesomeproject.reactpackage.AnToastReactPackage;
import com.facebook.react.ReactApplication;
import com.facebook.react.ReactInstanceManager;
import com.facebook.react.ReactNativeHost;
import com.facebook.react.ReactPackage;
import com.facebook.react.shell.MainReactPackage;
import com.xtremeprog.xpgconnect.XPGWifiSDK;

import java.util.Arrays;
import java.util.List;

public class MainApplication extends Application implements ReactApplication {



  @Override
  public void onCreate() {
    super.onCreate();
    XPGWifiSDK.sharedInstance().startWithAppID(getApplicationContext(), "9be2e74dce0f45a18bf28252b68c27f5");
  }



  private final ReactNativeHost mReactNativeHost = new ReactNativeHost(this) {
    @Override
    protected boolean getUseDeveloperSupport() {
      return BuildConfig.DEBUG;
    }

    @Override
    protected List<ReactPackage> getPackages() {
      return Arrays.<ReactPackage>asList(
              new MainReactPackage(),
              new AnToastReactPackage()
      );
    }
  };

  @Override
  public ReactNativeHost getReactNativeHost() {
    return mReactNativeHost;
  }

}
