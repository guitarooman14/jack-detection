import { registerPlugin } from '@capacitor/core';

import type { JackDetectionPlugin } from './definitions';

// const JackDetection = registerPlugin<JackDetectionPlugin>('Jack', {
//   web: () => import('./web').then(m => new m.JackStatusWeb()),
// });
const JackDetection = registerPlugin<JackDetectionPlugin>('JackDetection');

export * from './definitions';
export { JackDetection };
