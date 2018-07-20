package com.lfyt.mobile.android.livemodel;

public class ValueEvent<TYPE> extends Event {


    private TYPE value;

    public ValueEvent(TYPE value){
        this.value = value;
    }

    public TYPE getValue() {
        return value;
    }
}
