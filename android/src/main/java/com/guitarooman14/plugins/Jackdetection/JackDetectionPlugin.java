package com.guitarooman14.plugins.JackDetection;

import com.getcapacitor.JSObject;
import com.getcapacitor.Plugin;
import com.getcapacitor.PluginCall;
import com.getcapacitor.PluginMethod;
import com.getcapacitor.annotation.CapacitorPlugin;

@CapacitorPlugin(name = "JackDetection")
public class JackDetectionPlugin extends Plugin {
    public static final String JACK_CHANGE_EVENT = "jackStatusChange";
    private JackDetection implementation;

    @Override
    public void load() {
        implementation = new JackDetection(getContext());
        implementation.setStatusChangeListener(this::updateJackStatus);
    }

    /**
     * Clean up callback to prevent leaks.
     */
    @Override
    protected void handleOnDestroy() {
        implementation.setStatusChangeListener(null);
    }

    /**
     * Get current jack status information.
     * @param call
     */
    @PluginMethod
    public void getStatus(PluginCall call) {
        call.resolve(getStatusJSObject(implementation.getJackStatus()));
    }

    /**
     * Register the IntentReceiver on resume
     */
    @Override
    protected void handleOnResume() {
        implementation.startMonitoring(getActivity());
    }

    /**
     * Unregister the IntentReceiver on pause to avoid leaking it
     */
    @Override
    protected void handleOnPause() {
        implementation.stopMonitoring(getActivity());
    }

    private void updateJackStatus() {
        notifyListeners(JACK_CHANGE_EVENT, getStatusJSObject(implementation.getJackStatus()));
    }

    /**
     * Map the jack status into our JSObject for returning to client
     * @param isJackConnected
     * @return
     */
    private JSObject getStatusJSObject(boolean isJackConnected) {
        JSObject ret = new JSObject();
        ret.put("connected", isJackConnected);
        return ret;
    }
}
