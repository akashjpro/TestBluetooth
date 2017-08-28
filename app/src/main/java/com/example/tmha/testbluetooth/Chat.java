package com.example.tmha.testbluetooth;

/**
 * Created by tmha on 8/28/2017.
 */

public class Chat {

    private String mMessage;
    private byte[] mPhoto;

    public Chat() {
    }

    public Chat(String mMessage, byte[] mPhoto) {
        this.mMessage = mMessage;
        this.mPhoto = mPhoto;
    }

    public String getmMessage() {
        return mMessage;
    }

    public void setmMessage(String mMessage) {
        this.mMessage = mMessage;
    }

    public byte[] getmPhoto() {
        return mPhoto;
    }

    public void setmPhoto(byte[] mPhoto) {
        this.mPhoto = mPhoto;
    }
}
