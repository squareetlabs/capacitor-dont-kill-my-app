import { WebPlugin } from '@capacitor/core';

import type { DontKillMyAppPlugin } from './definitions';

export class DontKillMyAppWeb extends WebPlugin implements DontKillMyAppPlugin {
  async echo(options: { value: string }): Promise<{ value: string }> {
    console.log('ECHO', options);
    return options;
  }
}
