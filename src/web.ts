import { PluginListenerHandle, WebPlugin } from '@capacitor/core';

import { JackDetectionPlugin, JackStatus, JackStatusChangeListener } from './definitions';

export class JackStatusWeb extends WebPlugin implements JackDetectionPlugin {
  getStatus(): Promise<JackStatus> {
    throw new Error('Method not implemented on web');
  }

  /**
   * Listen for changes of the jack status.
   *
   * @since 1.0.0
   */
  addListener(
    eventName: 'jackStatusChange',
    listenerFunc: JackStatusChangeListener,
  ): Promise<PluginListenerHandle> & PluginListenerHandle {
    return super.addListener(eventName, listenerFunc);
  }

  /**
   * Remove all listeners for this plugin.
   *
   * @since 1.0.0
   */
  async removeAllListeners(): Promise<void> {
    return super.removeAllListeners();
  }
}
