package com.lfyt.mobile.android.livemodel;

import android.os.Handler;
import android.os.Looper;

import com.lfyt.mobile.android.log.Logger;
import com.squareup.otto.Bus;
import com.squareup.otto.ThreadEnforcer;

;

/**
 * This class is used as the implementation of the observer pattern,
 * creating a Channel where subscribers can listen for events posted.
 *
 * This message bus allows you to post a message from any thread
 * and it will get handled and then posted to the main thread for you.
 */
public final class Channel extends Bus
{
	public int subscribers;

	public Channel()
    {
        super(ThreadEnforcer.MAIN);
    }

    @Override
    public void post(final Object event)
    {
        if (Looper.myLooper() != Looper.getMainLooper())
        {
            // We're not in the main loop, so we need to get into it.
            (new Handler(Looper.getMainLooper())).post(new Runnable()
            {
                @Override
                public void run()
                {
                    // We're now in the main loop, we can post now
                    Channel.super.post(event);
                }
            });
        }
        else
        {
            super.post(event);
        }
    }
	
	@Override
	public void register(Object object)
	{
		//  Lots of edge cases with subscribe/unsubscribe that sometimes throw.
		try
		{
			super.register(object);
			subscribers++;
		}
		catch (IllegalArgumentException e)
		{
			LoggerLiveModel.EVENT_ERROR(this, "SUBSCRIBING | IllegalArgumentException ==> " + e.getMessage(), e);
		}
		catch (Exception e){
			Logger.EXP(this, "SUBSCRIBING | Exception -> " + e.getClass().getSimpleName() + " ==> " + e.getMessage(), e);
		}
		
	}
	
	@Override
    public void unregister(final Object object)
    {
        //  Lots of edge cases with subscribe/unsubscribe that sometimes throw.
        try
        {
            super.unregister(object);
	        subscribers--;
        }
        catch (IllegalArgumentException e)
        {
            LoggerLiveModel.EVENT_ERROR(this, "UNSUBSCRIBING | IllegalArgumentException ==> " + e.getMessage(), e);
        }
        catch (Exception e){
            Logger.EXP(this, "UNSUBSCRIBING | Exception -> " + e.getClass().getSimpleName() + " ==> " + e.getMessage(), e);
        }
        
    }
}