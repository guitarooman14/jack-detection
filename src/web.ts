import { WebPlugin } from '@capacitor/core';

import type { ExamplePlugin } from './definitions';

export class JackStatusWeb extends WebPlugin implements JackDetectionPlugin {
      constructor() {
          super();
      }

      async getStatus(): Promise<boolean> {

      }

    /**
     * Listen for changes of the jack status.
     *
     * @since 1.0.0
     */
    async addListener(
      eventName: 'jackStatusChange',
      listenerFunc: JackStatusChangeListener,
    ): Promise<PluginListenerHandle> & PluginListenerHandle {
    }

    /**
     * Remove all listeners for this plugin.
     *
     * @since 1.0.0
     */
    async removeAllListeners(): Promise<void> {
    }
}
