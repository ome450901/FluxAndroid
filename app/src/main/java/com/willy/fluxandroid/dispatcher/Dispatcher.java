package com.willy.fluxandroid.dispatcher;

import com.squareup.otto.Bus;
import com.willy.fluxandroid.action.Action;

/**
 * Created by Willy on 2016/4/28.
 */
public class Dispatcher {

    private static Dispatcher instance;

    private final Bus mBus;

    public static Dispatcher getInstance() {
        if (instance == null) {

            synchronized (Dispatcher.class) {
                if (instance == null) {
                    instance = new Dispatcher(new Bus());
                }
            }
        }
        return instance;
    }

    public Dispatcher(Bus bus) {
        mBus = bus;
    }

    public void dispatch(Action action){
        post(action);
    }

    public void register(Object obj){
        mBus.register(obj);
    }

    public void unregister(Object obj){
        mBus.unregister(obj);
    }

    public void post(Object event){
        mBus.post(event);
    }
}
