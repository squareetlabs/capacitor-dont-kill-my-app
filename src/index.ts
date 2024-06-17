import { registerPlugin } from '@capacitor/core';

import type { DontKillMyAppPlugin } from './definitions';

const DontKillMyApp = registerPlugin<DontKillMyAppPlugin>('DontKillMyApp', {
  web: () => import('./web').then(m => new m.DontKillMyAppWeb()),
});

export * from './definitions';
export { DontKillMyApp };
