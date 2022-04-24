package com.example.platform_channel_demo;

import android.content.IntentFilter;
import android.os.BatteryManager;
import android.os.Build.VERSION;
import android.os.Build.VERSION_CODES;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import io.flutter.embedding.android.FlutterActivity;
import io.flutter.embedding.engine.FlutterEngine;
import io.flutter.plugin.common.MethodChannel;


public class MainActivity extends FlutterActivity {
    private static final String CHANNEL_METHOD_BATTERY = "com.example.platform_channel_demo/common";
    
    @Override
    public void configureFlutterEngine(@NonNull FlutterEngine flutterEngine) {
        
        super.configureFlutterEngine(flutterEngine);
        new MethodChannel(flutterEngine.getDartExecutor().getBinaryMessenger(), CHANNEL_METHOD_BATTERY).setMethodCallHandler((call, result) -> {
            if(call.method.equals("getBatteryLevel")){
                
                int suma = getSuma();
                if(suma != 0){
                    result.success(suma);
                }
                // int batteryLevel = getBatteryLevel();
                // if(batteryLevel != -1){
                //     result.success(batteryLevel);
                // }else{
                //     result.error("UNAVAULABLE", "Battery level not available.", null);
                // }
                return;
            }
            result.notImplemented();
            return;
        });
    }

    private int getSuma(){
        int suma = 5 + 3;
        return suma;
    }

    private int getBatteryLevel(){
        int batteryLevel = -1;
        if(VERSION.SDK_INT >= VERSION_CODES.LOLLIPOP){
            //BatteryManager BatteryManager = (BatteryManager) getSystemService(BATTERY_SERVICE);
            //batteryLevel = batteryLevel.getProperty(BatteryManager.BATTERY_PROPERTY_CAPACITY);
        } else{
            //Intent intent = new ContextWrapper(getApplicationContext()).registerReceiver(null, new IntentFilter(Intent.ACTION_BATTERY_CHANGED));
            //batteryLevel = (intent.getIntExtra(BatteryManager.EXTRA_LEVEL, -1)*100)/ intent.getIntExtra(BatteryManager.EXTRA_SCALE, -1);
        }
        return batteryLevel;
    }

}

