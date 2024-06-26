package com.squareetlabs.capacitor.dontkillmyapp;

import android.content.Context;
import android.os.Build;

import com.getcapacitor.JSObject;
import com.getcapacitor.Plugin;
import com.getcapacitor.PluginCall;
import com.getcapacitor.PluginMethod;
import com.getcapacitor.annotation.CapacitorPlugin;

/**
 * Capacitor plugin that provides access to device settings to prevent the OS from killing the app.
 * <p>
 * This plugin includes methods to:
 * - Check and request auto-start permissions to allow the app to run in the background.
 * - Check if the device supports auto-start permissions.
 * - Check and request battery saver permissions to prevent the app from being killed by the OS.
 * - Check if the device supports managing battery saver settings.
 * - Request the user to ignore battery optimizations for the app.
 * - Request the user to allow the app to auto-start on device boot.
 * - Request the app to stay active and prevent it from being paused.
 * - Allow the app to run in the background by combining battery saver and auto-start permissions.
 */
@CapacitorPlugin(name = "DontKillMyApp")
public class DontKillMyAppPlugin extends Plugin {

    private final DontKillMyApp implementation = DontKillMyApp.getInstance();

    @PluginMethod
    public void requestAutoStart(PluginCall call) {
        Context context = getContext();
        implementation.requestAutoStart(context);
        JSObject result = new JSObject();
        result.put("requested", true);
        call.resolve(result);
    }

    @PluginMethod
    public void requestKeepAppActive(PluginCall call) {
        Context context = getContext();
        implementation.requestKeepAppActive(context);
        JSObject result = new JSObject();
        result.put("requested", true);
        call.resolve(result);
    }

    @PluginMethod
    public void requestRunInBackground(PluginCall call) {
        Context context = getContext();
        implementation.requestRunInBackground(context);
        JSObject result = new JSObject();
        result.put("requested", true);
        call.resolve(result);
    }

    @PluginMethod
    public void openAppInfo(PluginCall call) {
        Context context = getContext();
        implementation.openAppInfo(context);
        JSObject result = new JSObject();
        result.put("opened", true);
        call.resolve(result);
    }

    @PluginMethod
    public void isIgnoringBatteryOptimizations(PluginCall call) {
        Context context = getContext();
        boolean ignoring = implementation.isIgnoringBatteryOptimizations(context);
        JSObject result = new JSObject();
        result.put("ignoring", ignoring);
        call.resolve(result);
    }
}