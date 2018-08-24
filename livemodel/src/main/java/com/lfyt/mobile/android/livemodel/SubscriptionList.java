package com.lfyt.mobile.android.livemodel;

import java.util.ArrayList;
import java.util.Arrays;

public class SubscriptionList extends ArrayList<LiveModelAPI>{


    public boolean addAll(LiveModelAPI... liveModelAPIS) {
        return super.addAll(Arrays.asList(liveModelAPIS));
    }

    void subscribe(Object object){
        for(int i = 0 ; i < size() ; i++){
            get(i).subscribe(object);
        }
    }

    void unsubscribe(Object object){
        for(int i = 0 ; i < size() ; i++){
            get(i).subscribe(object);
        }
    }
}
