package com.guitarooman14.plugins.JackDetection;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.media.AudioManager;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

public class JackDetection {
    @Nullable
    private JackStatusChangeListener statusChangeListener;
    private AudioManager audioManager;
    private BroadcastReceiver receiver;
    /**
     * Create jack detection monitoring object.
     *
     * @param context
     */
    public JackDetection(@NonNull Context context) {
        audioManager = (AudioManager) context.getSystemService(Context.AUDIO_SERVICE);
        receiver =
                new BroadcastReceiver() {
                    @Override
                    public void onReceive(Context context, Intent intent) {
                        if (intent.getAction().equals(Intent.ACTION_HEADSET_PLUG)) {
                            statusChangeListener.onJackStatusChanged();
                        }
                    }
                };
    }

    /**
     * Get the current jack status.
     *
     * @return boolean
     */
    public boolean getJackStatus() {
        return audioManager.isWiredHeadsetOn();
    }

    /**
     * Return the object that is receiving the callbacks.
     *
     * @return
     */
    @Nullable
    public JackStatusChangeListener getStatusChangeListener() {
        return statusChangeListener;
    }

    /**
     * Set the object to receive callbacks.
     *
     * @param listener
     */
    public void setStatusChangeListener(@Nullable JackStatusChangeListener listener) {
        this.statusChangeListener = listener;
    }

    /**
     * Register a Intent Receiver in the activity.
     *
     * @param activity
     */
    public void startMonitoring(@NonNull AppCompatActivity activity) {
        IntentFilter filter = new IntentFilter(AudioManager.ACTION_HEADSET_PLUG);
        activity.registerReceiver(receiver, filter);
    }

    /**
     * Unregister the IntentReceiver to avoid leaking it.
     *
     * @param activity
     */
    public void stopMonitoring(@NonNull AppCompatActivity activity) {
        activity.unregisterReceiver(receiver);
    }

    /**
     * Interface for callbacks when jack status changes.
     */
    interface JackStatusChangeListener {
        void onJackStatusChanged();
    }
}
