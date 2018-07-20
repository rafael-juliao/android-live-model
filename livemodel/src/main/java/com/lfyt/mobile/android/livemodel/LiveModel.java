package com.lfyt.mobile.android.livemodel;


import android.support.annotation.CallSuper;


/**
 * Live Model implementation
 * that can:
 * 		*post event to subscribers
 */
public abstract class LiveModel implements LiveModelAPI {


    protected LiveModel(){
        setupChannel();
    }


    ///////////////////////////////////////////////////////////////////////////
    // Live Model Event Channel Setup
    ///////////////////////////////////////////////////////////////////////////

    private Channel channel;

    private void setupChannel() {
        channel = new Channel();
    }




    ///////////////////////////////////////////////////////////////////////////
    // Post Event to Subscribers
    ///////////////////////////////////////////////////////////////////////////

    public void post(Event event){
        if( event.log ) LoggerLiveModel.EVENT(this, event);
        channel.post(event);
    }




    ///////////////////////////////////////////////////////////////////////////
    // Subscribers Management
    ///////////////////////////////////////////////////////////////////////////

    @CallSuper
    public void subscribe(Object subscriber){
        channel.register(subscriber);
    }

    @CallSuper
    public void unsubscribe(Object subscriber){
        channel.unregister(subscriber);
    }

    public final int getSubscribersCount() {
        return channel.subscribers;
    }



    

}
