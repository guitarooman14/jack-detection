import type { PluginListenerHandle } from '@capacitor/core';

export interface JackDetectionPlugin {
  /**
   * Query the current status of the jack.
   *
   * @since 1.0.0
   */
  getStatus(): Promise<boolean>;

  /**
   * Listen for changes of the jack status.
   *
   * @since 1.0.0
   */
  addListener(
    eventName: 'jackStatusChange',
    listenerFunc: JackStatusChangeListener,
  ): Promise<PluginListenerHandle> & PluginListenerHandle;

  /**
   * Remove all listeners for this plugin.
   *
   * @since 1.0.0
   */
  removeAllListeners(): Promise<void>;
}

/**
 * Represents the state and type of the network connection.
 *
 * @since 1.0.0
 */
export interface JackStatus {
  /**
   * Whether the jack is plugged or not.
   *
   * @since 1.0.0
   */
  connected: boolean;
}

/**
 * Callback to receive the status change notifications.
 *
 * @since 1.0.0
 */
export type JackStatusChangeListener = (status: JackStatus) => void;

/**
 * @deprecated Use `JackStatusChangeListener`.
 * @since 1.0.0
 */
export type JackStatusChangeCallback = JackStatusChangeListener;