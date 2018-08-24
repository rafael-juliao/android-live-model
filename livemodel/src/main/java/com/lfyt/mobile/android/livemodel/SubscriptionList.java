package com.lfyt.mobile.android.livemodel;

import java.util.ArrayList;
import java.util.Arrays;

public final class SubscriptionList extends ArrayList<LiveModelAPI>{

    public final void add(LiveModelAPI... list){
        super.addAll(Arrays.asList(list));
    }

    public final void set(LiveModelAPI... list){
        super.addAll(Arrays.asList(list));
    }
    public final boolean addAll(LiveModelAPI... list) {
        return super.addAll(Arrays.asList(list));
    }

    public final void subscribe(Object object){
        for(int i = 0 ; i < size() ; i++){
            get(i).subscribe(object);
        }
    }

    public final void unsubscribe(Object object){
        for(int i = 0 ; i < size() ; i++){
            get(i).subscribe(object);
        }
    }
}
