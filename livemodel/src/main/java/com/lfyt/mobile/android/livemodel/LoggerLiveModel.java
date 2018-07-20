package com.lfyt.mobile.android.livemodel;

import com.lfyt.mobile.android.log.Logger;

public class LoggerLiveModel extends Logger {



    public static void EVENT(Object object, Event event) {
        debug(object, tagify("EVENT"), name(event));
    }

    static void EVENT_ERROR(Object object, String message, Object... args) {
        error(object, tagify("EVENT"), message, args);
    }
}
