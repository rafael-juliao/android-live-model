package com.lfyt.mobile.android.livemodel;

/**
 * Interface used by every class that intent to be a live model
 * The class must be able to have subscribers, where it can
 * post events to any one interested.
 *
 * The best way to achieve this is implementing this interface
 * and create a channel to handle the observer pattern.@{@link Channel}
 */
public interface LiveModelAPI {
	
	void post(Event event);
	
	void subscribe(Object subscriber);
	
	void unsubscribe(Object subscriber);
	
	int getSubscribersCount();
}
