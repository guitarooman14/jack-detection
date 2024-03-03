import { registerPlugin } from '@capacitor/core';

import type { JackDetectionPlugin } from './definitions';

const JackDetection = registerPlugin<JackDetectionPlugin>('JackDetection', {
  web: () => import('./web').then(m => new m.JackStatusWeb()),
});

export * from './definitions';
export { JackDetection };
