package com.polygraphene.alvr;

public class GvrTracking {

    static {
        System.loadLibrary("native-lib");
    }

    private long handle;

    /**
     * @param nativeGvrContext Gvr API context for native code to get controller info.
     */
    public GvrTracking(long nativeGvrContext) {
        handle = initializeNative(nativeGvrContext);
    }

    public void sendTrackingInfo(long udpManager, long frameIndex, float[] headOrientation, float[] headPosition) {
        sendTrackingInfoNative(handle, udpManager, frameIndex, headOrientation, headPosition);
    }

    private native long initializeNative(long nativeGvrContext);
    private native void sendTrackingInfoNative(long nativeHandle, long udpManager
            , long frameIndex, float[] headOrientation, float[] headPosition);
}