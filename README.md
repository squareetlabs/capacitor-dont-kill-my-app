# Capacitor DontKillMyApp

A Capacitor plugin to manage auto-start and battery saver permissions across different Android manufacturers.

## Install

```bash
npm install @squareetlabs/capacitor-dont-kill-my-app
ionic cap sync
```

After that, follow the platform-specific instructions in the section [Android](#android).

### Android

This API requires the following permissions be added to your `AndroidManifest.xml` before the `application` tag if you want to request direct exemption from Power Management features:

```xml

<uses-permission android:name="android.permission.REQUEST_IGNORE_BATTERY_OPTIMIZATIONS"/>
```

And need the following permission to be added to your `AndroidManifest.xml` before the `application` tag if you want to request direct exemption from Auto-Start features and Battery Saver features. It was needed for check the auto-start permission on the device based on brand:

```xml
<queries>
    <!-- Package queries for specific auto-start settings -->
    <package android:name="com.asus.mobilemanager" />
    <package android:name="com.miui.securitycenter" />
    <package android:name="com.letv.android.letvsafe" />
    <package android:name="com.huawei.systemmanager" />
    <package android:name="com.coloros.safecenter" />
    <package android:name="com.oppo.safe" />
    <package android:name="com.iqoo.secure" />
    <package android:name="com.vivo.permissionmanager" />
    <package android:name="com.evenwell.powersaving.g3" />
    <package android:name="com.samsung.android.lool" />
    <package android:name="com.oneplus.security" />
    <package android:name="com.lenovo.powersetting" />
    <package android:name="com.meizu.safe" />
</queries>
```  

⚠️ **Attention**: Google Play policies prohibit apps from requesting direct exemption from Power Management features in Android 6.0+ (Doze and App Standby) unless the core function of the app is adversely
affected. [Source](https://developer.android.com/training/monitoring-device-state/doze-standby.html#support_for_other_use_cases)

## Summary

This Capacitor plugin helps bring up the auto-start and battery saver permission managers on Android devices, allowing users to add an app to auto-start and prevent the system from killing it. Ensuring that your app can run in the background and is not restricted by the system is crucial for
applications that rely on long-running background processes. This includes apps like music players, navigation apps, alarm apps, or fitness trackers.
Different Android manufacturers implement custom modifications that can restrict apps from running in the background, which can negatively impact the user experience. This plugin provides a unified interface to handle these permissions, allowing developers to prompt users to enable the necessary
settings on their devices.

## API Docs

For a more detailed look into the different methods and their parameters, refer to the [API Documentation](api-docs.md).

## Features

This plugin provides the following features:

- Check if the auto-start permission is available on the device.
- Open the auto-start settings for the user to enable auto-start for the app.
- Check if the battery saver permission is available on the device.
- Open the battery saver settings for the user to manage battery saver for the app.
- Request to ignore battery optimization for the app.
- Request to add the app to the auto-start whitelist.
- Request to keep the app active and prevent it from being paused.
- Allow the app to run in the background by combining battery saver and auto-start permissions.

## Usage

### Initialize the Plugin

Before using the plugin methods, initialize the plugin in your application. This can be done in your main application file (e.g., `App.tsx` or `App.vue`).

### Checking if Battery Saver Permission is Available

You can check if the battery saver permission is available on the device using the following method:

```javascript
DontKillMyApp.isBatterySaverPermissionAvailable()
    .then(result => {
        console.log('Battery saver permission available:', result.isAvailable);
    })
    .catch(error => {
        console.error('Error checking if battery saver permission is available', error);
    });
```

### Requesting to Ignore Battery Optimization

You can request to ignore battery optimization for the app using the following method:

```javascript
DontKillMyApp.requestKeepAppActive()
    .then(result => {
        console.log('Requested ignore battery optimization:', result.requested);
    })
    .catch(error => {
        console.error('Error requesting ignore battery optimization', error);
    });
```

### Requesting Auto-Start

You can request the app to be added to the auto-start whitelist using the following method:

```javascript
DontKillMyApp.requestAutoStart()
    .then(result => {
        console.log('Requested auto-start:', result.requested);
    })
    .catch(error => {
        console.error('Error requesting auto-start', error);
    });
```

### Requesting to Keep App Active

You can request the app to run in the background by combining battery saver and auto-start permissions using the following method:

```javascript
DontKillMyApp.requestRunInBackground()
    .then(result => {
        console.log('Requested run in background:', result.requested);
    })
    .catch(error => {
        console.error('Error requesting run in background', error);
    });
```

### Open app info settings

You can open the app info settings using the following method:

```javascript
DontKillMyApp.openAppInfo()
    .then(result => {
        console.log('Opened app info settings:', result.opened);
    })
    .catch(error => {
        console.error('Error opening app info settings', error);
    });
```

## Limitations

- The plugin supports a variety of manufacturers, but there may be cases where the auto-start or battery saver settings cannot be opened due to changes in the manufacturer's custom UI.
- The plugin primarily supports newer Android devices, and behavior may vary on older devices or heavily customized versions of Android.

## Supported Manufacturers

As of now, the library supports the following manufacturers:

1. Xiaomi
2. Redmi
3. Letv
4. Honor
5. Oppo
6. Vivo
7. Huawei
8. Samsung
9. Asus
10. One Plus
11. Lenovo
12. Meizu
13. Realme

Support for other manufacturers will be added as and when possible. Contributions and pull requests are welcome.

## Contributing

If you have suggestions, bug reports, or want to contribute to the development of this plugin, please feel free to create an issue or submit a pull request.

## License

This project is licensed under the MIT License. See the [LICENSE](LICENSE) file for more details.

## Related Information

Since this depends entirely on the OEM and not on Android itself, the underlying components that this library makes use of are continuously changing. Please refer to the [API Documentation](api-docs.md) for the most up-to-date information on the plugin's capabilities and usage.

---
