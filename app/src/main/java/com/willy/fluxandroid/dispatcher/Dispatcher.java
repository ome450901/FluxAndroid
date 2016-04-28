package com.willy.fluxandroid.dispatcher;

/**
 * Created by Willy on 2016/4/28.
 */
public class Dispatcher {

    private static Dispatcher instance;

    public static Dispatcher getInstance() {
        if (instance == null) {

            synchronized (Dispatcher.class) {
                if (instance == null) {
                    instance = new Dispatcher();
                }
            }
        }
        return instance;
    }
}
