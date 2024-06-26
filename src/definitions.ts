/**
 * Interface for the DontKillMyAppPlugin.
 * This interface provides methods to manage the auto-start and battery saver permissions on Android devices.
 */
export interface DontKillMyAppPlugin {
    /**
     * This method checks if the auto-start permission is available on the device.
     *
     * @returns A Promise that resolves with an object containing a `ignoring` property. The `ignoring` is a boolean that indicates whether the app is ignoring battery optimizations.
     */
    isIgnoringBatteryOptimizations(): Promise<{ ignoring: boolean }>;

    /**
     * This method requests to add the app to the auto-start whitelist.
     * This opens the settings screen specific to the device's brand where the user can allow the app to auto-start on device boot.
     *
     * @returns A Promise that resolves with an object containing a `requested` property. The `requested` is a boolean that indicates whether the request was made.
     */
    requestAutoStart(): Promise<{ requested: boolean }>;

    /**
     * This method requests to keep the app active and prevent it from being paused.
     * This ensures that the app is allowed to ignore battery optimizations.
     *
     * @returns A Promise that resolves with an object containing a `requested` property. The `requested` is a boolean that indicates whether the request was made.
     */
    requestKeepAppActive(): Promise<{ requested: boolean }>;

    /**
     * This method requests to allow the app to run in the background.
     * This combines the functionality of requesting to ignore battery optimizations and requesting auto-start permissions.
     *
     * @returns A Promise that resolves with an object containing a `requested` property. The `requested` is a boolean that indicates whether the request was made.
     */
    requestRunInBackground(): Promise<{ requested: boolean }>;


    /**
     * This method checks if the battery saver permission is available on the device.
     *
     * @returns A Promise that resolves with an object containing an `isAvailable` property. The `isAvailable` is a boolean that indicates whether the battery saver permission is available.
     */
    openAppInfo(): Promise<{ opened: boolean }>;

}
