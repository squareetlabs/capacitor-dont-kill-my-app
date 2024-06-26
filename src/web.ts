import { WebPlugin } from '@capacitor/core';
import type { DontKillMyAppPlugin } from './definitions';

export class DontKillMyAppWeb extends WebPlugin implements DontKillMyAppPlugin {

    constructor() {
        super();
    }

    async requestAutoStart(): Promise<{ requested: boolean }> {
        return new Promise<{ requested: boolean }>((resolve) => {
            console.log('Request auto start!');
            resolve({ requested: true });
        });
    }

    async requestKeepAppActive(): Promise<{ requested: boolean }> {
        return new Promise<{ requested: boolean }>((resolve) => {
            console.log('Request keep app active!');
            resolve({ requested: true });
        });
    }

    async requestRunInBackground(): Promise<{ requested: boolean }> {
        return new Promise<{ requested: boolean }>((resolve) => {
            console.log('Request run in background!');
            resolve({ requested: true });
        });
    }

    async isIgnoringBatteryOptimizations(): Promise<{ ignoring: boolean }> {
        return new Promise<{ ignoring: boolean }>((resolve) => {
            console.log('Request if is ignoring battery optimizations!');
            resolve({ ignoring: true });
        });
    }


    async openAppInfo(): Promise<{ opened: boolean }> {
        return new Promise<{ opened: boolean }>((resolve) => {
            console.log('Open app info!');
            resolve({ opened: true });
        });
    }
}
