package com.squareetlabs.capacitor.dontkillmyapp;

import android.app.AlertDialog;
import android.content.ComponentName;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.net.Uri;
import android.os.Build;
import android.os.PowerManager;
import android.provider.Settings;

import com.getcapacitor.Logger;

import java.util.List;

/**
 * DontKillMyApp is a helper class that manages requests for auto-start and battery optimization
 * permissions for various Android device manufacturers.
 */
public class DontKillMyApp {

    private static DontKillMyApp instance;

    private DontKillMyApp() {
    }

    /**
     * Get the singleton instance of DontKillMyApp.
     *
     * @return The instance of DontKillMyApp.
     */
    public static DontKillMyApp getInstance() {
        if (instance == null) {
            instance = new DontKillMyApp();
        }
        return instance;
    }

    /**
     * Request auto-start permission for the app based on the device manufacturer.
     *
     * @param context The application context.
     */
    public void requestAutoStart(Context context) {
        String buildInfo = Build.BRAND.toLowerCase();
        switch (buildInfo) {
            case "asus":
                autoStartAsus(context);
                break;
            case "xiaomi":
                autoStartXiaomi(context);
                break;
            case "letv":
                autoStartLetv(context);
                break;
            case "honor":
                autoStartHonor(context);
                break;
            case "oppo":
                autoStartOppo(context);
                break;
            case "vivo":
                autoStartVivo(context);
                break;
            case "nokia":
                autoStartNokia(context);
                break;
            case "samsung":
                autoStartSamsung(context);
                break;
            case "oneplus":
                autoStartOnePlus(context);
                break;
            case "huawei":
                autoStartHuawei(context);
                break;
            case "lenovo":
                autoStartLenovo(context);
                break;
            case "meizu":
                autoStartMeizu(context);
                break;
            case "realme":
                autoStartRealme(context);
                break;
            default:
                autoStartGeneric(context);
                break;
        }
    }


    /**
     * Check if the app is ignoring battery optimizations.
     *
     * @param context The application context.
     * @return True if ignoring battery optimizations, false otherwise.
     */
    public boolean isIgnoringBatteryOptimizations(Context context) {
        String packageName = context.getPackageName();
        PowerManager pm = (PowerManager) context.getSystemService(Context.POWER_SERVICE);
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {
            return pm.isIgnoringBatteryOptimizations(packageName);
        }
        return false;
    }

    /**
     * Request permissions to run the app in the background.
     *
     * @param context The application context.
     */
    public void requestRunInBackground(Context context) {
        requestKeepAppActive(context);
        requestAutoStart(context);
    }

    /**
     * Open the app's info screen in the device settings.
     *
     * @param context The application context.
     */
    public void openAppInfo(Context context) {
        Intent intent = new Intent(Settings.ACTION_APPLICATION_DETAILS_SETTINGS);
        intent.setData(Uri.parse("package:" + context.getPackageName()));
        context.startActivity(intent);
    }

    /**
     * Request permission to ignore battery optimizations.
     *
     * @param context The application context.
     */
    public void requestKeepAppActive(Context context) {
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {
            Intent intent = new Intent();
            intent.setAction(Settings.ACTION_REQUEST_IGNORE_BATTERY_OPTIMIZATIONS);
            intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
            intent.setData(Uri.parse("package:" + context.getPackageName()));
            context.startActivity(intent);
        }
    }


    /**
     * Check if a package exists on the device.
     *
     * @param context       The application context.
     * @param targetPackage The package name to check.
     * @return True if the package exists, false otherwise.
     */
    private boolean isPackageExists(Context context, String targetPackage) {
        PackageManager pm = context.getPackageManager();
        try {
            PackageInfo packageInfo = pm.getPackageInfo(targetPackage, PackageManager.GET_META_DATA);
            return packageInfo != null;
        } catch (PackageManager.NameNotFoundException e) {
            return false;
        }
    }

    /**
     * Attempt to start an intent for the specified package and component.
     *
     * @param context       The application context.
     * @param packageName   The package name.
     * @param componentName The component name.
     * @throws Exception If the intent cannot be started.
     */
    private void startIntent(Context context, String packageName, String componentName) throws Exception {
        try {
            Intent intent = new Intent();
            intent.setComponent(new ComponentName(packageName, componentName));
            context.startActivity(intent);
        } catch (Exception e) {
            Logger.error(e.getMessage());
            throw e;
        }
    }

    // Methods for different manufacturers
    private void autoStartAsus(Context context) {
        if (isPackageExists(context, "com.asus.mobilemanager")) {
            try {
                startIntent(context, "com.asus.mobilemanager", "com.asus.mobilemanager.powersaver.PowerSaverSettings");
            } catch (Exception e) {
                autoStartGeneric(context);
            }
        } else {
            autoStartGeneric(context);
        }
    }

    private void autoStartXiaomi(Context context) {
        if (isPackageExists(context, "com.miui.securitycenter")) {
            try {
                startIntent(context, "com.miui.securitycenter", "com.miui.permcenter.autostart.AutoStartManagementActivity");
            } catch (Exception e) {
                autoStartGeneric(context);
            }
        } else {
            autoStartGeneric(context);
        }
    }

    private void autoStartLetv(Context context) {
        if (isPackageExists(context, "com.letv.android.letvsafe")) {
            try {
                startIntent(context, "com.letv.android.letvsafe", "com.letv.android.letvsafe.AutobootManageActivity");
            } catch (Exception e) {
                autoStartGeneric(context);
            }
        } else {
            autoStartGeneric(context);
        }
    }

    private void autoStartHonor(Context context) {
        if (isPackageExists(context, "com.huawei.systemmanager")) {
            try {
                startIntent(context, "com.huawei.systemmanager", "com.huawei.systemmanager.optimize.process.ProtectActivity");
            } catch (Exception e) {
                autoStartGeneric(context);
            }
        } else {
            autoStartGeneric(context);
        }
    }

    private void autoStartOppo(Context context) {
        if (isPackageExists(context, "com.coloros.safecenter") || isPackageExists(context, "com.oppo.safe")) {
            try {
                startIntent(context, "com.coloros.safecenter", "com.coloros.safecenter.permission.startup.StartupAppListActivity");
            } catch (Exception e) {
                try {
                    startIntent(context, "com.oppo.safe", "com.oppo.safe.permission.startup.StartupAppListActivity");
                } catch (Exception ex) {
                    try {
                        startIntent(context, "com.coloros.safecenter", "com.coloros.safecenter.startupapp.StartupAppListActivity");
                    } catch (Exception exx) {
                        autoStartGeneric(context);
                    }
                }
            }
        } else {
            autoStartGeneric(context);
        }
    }

    private void autoStartVivo(Context context) {
        if (isPackageExists(context, "com.iqoo.secure") || isPackageExists(context, "com.vivo.permissionmanager")) {
            try {
                startIntent(context, "com.iqoo.secure", "com.iqoo.secure.ui.phoneoptimize.AddWhiteListActivity");
            } catch (Exception e) {
                try {
                    startIntent(context, "com.vivo.permissionmanager", "com.vivo.permissionmanager.activity.BgStartUpManagerActivity");
                } catch (Exception ex) {
                    try {
                        startIntent(context, "com.iqoo.secure", "com.iqoo.secure.ui.phoneoptimize.BgStartUpManager");
                    } catch (Exception exx) {
                        autoStartGeneric(context);
                    }
                }
            }
        } else {
            autoStartGeneric(context);
        }
    }

    private void autoStartNokia(Context context) {
        if (isPackageExists(context, "com.evenwell.powersaving.g3")) {
            try {
                startIntent(context, "com.evenwell.powersaving.g3", "com.evenwell.powersaving.g3.exception.PowerSaverExceptionActivity");
            } catch (Exception e) {
                autoStartGeneric(context);
            }
        } else {
            autoStartGeneric(context);
        }
    }

    private void autoStartSamsung(Context context) {
        if (isPackageExists(context, "com.samsung.android.lool")) {
            try {
                startIntent(context, "com.samsung.android.lool", "com.samsung.android.sm.ui.battery.BatteryActivity");
            } catch (Exception e) {
                autoStartGeneric(context);
            }
        } else {
            autoStartGeneric(context);
        }
    }

    private void autoStartOnePlus(Context context) {
        if (isPackageExists(context, "com.oneplus.security")) {
            try {
                startIntent(context, "com.oneplus.security", "com.oneplus.security.chainlaunch.view.ChainLaunchAppListActivity");
            } catch (Exception e) {
                autoStartGeneric(context);
            }
        } else {
            autoStartGeneric(context);
        }
    }

    private void autoStartHuawei(Context context) {
        if (isPackageExists(context, "com.huawei.systemmanager")) {
            try {
                startIntent(context, "com.huawei.systemmanager", "com.huawei.systemmanager.startupmgr.ui.StartupNormalAppListActivity");
            } catch (Exception e) {
                autoStartGeneric(context);
            }
        } else {
            autoStartGeneric(context);
        }
    }

    private void autoStartLenovo(Context context) {
        if (isPackageExists(context, "com.lenovo.powersetting")) {
            try {
                startIntent(context, "com.lenovo.powersetting", "com.lenovo.powersetting.ui.Settings$HighPowerAppListActivity");
            } catch (Exception e) {
                autoStartGeneric(context);
            }
        } else {
            autoStartGeneric(context);
        }
    }

    private void autoStartMeizu(Context context) {
        if (isPackageExists(context, "com.meizu.safe")) {
            try {
                startIntent(context, "com.meizu.safe", "com.meizu.safe.permission.SmartBGActivity");
            } catch (Exception e) {
                autoStartGeneric(context);
            }
        } else {
            autoStartGeneric(context);
        }
    }

    private void autoStartRealme(Context context) {
        if (isPackageExists(context, "com.coloros.safecenter") || isPackageExists(context, "com.oppo.safe")) {
            try {
                startIntent(context, "com.coloros.safecenter", "com.coloros.safecenter.permission.startup.StartupAppListActivity");
            } catch (Exception e) {
                try {
                    startIntent(context, "com.oppo.safe", "com.oppo.safe.permission.startup.StartupAppListActivity");
                } catch (Exception ex) {
                    try {
                        startIntent(context, "com.coloros.safecenter", "com.coloros.safecenter.startupapp.StartupAppListActivity");
                    } catch (Exception exx) {
                        autoStartGeneric(context);
                    }
                }
            }
        } else {
            autoStartGeneric(context);
        }
    }

    private void autoStartGeneric(Context context) {
        try {
            Intent intent = new Intent(Settings.ACTION_APPLICATION_DETAILS_SETTINGS);
            intent.setData(Uri.parse("package:" + context.getPackageName()));
            context.startActivity(intent);
        } catch (Exception e) {
            Logger.error(e.getMessage());
        }
    }

}
