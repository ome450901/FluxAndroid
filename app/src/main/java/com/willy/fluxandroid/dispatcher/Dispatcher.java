package com.willy.fluxandroid.dispatcher;

import com.squareup.otto.Bus;
import com.willy.fluxandroid.action.Action;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Willy on 2016/4/28.
 */
public class Dispatcher {

    private volatile static Dispatcher instance;

    private final Bus mBus;

    private List<Object> mRegisteredObjectList;

    public static Dispatcher getInstance() {
        if (instance == null) {

            synchronized (Dispatcher.class) {
                if (instance == null) {
                    instance = new Dispatcher(new Bus(), new ArrayList<>());
                }
            }
        }
        return instance;
    }

    public Dispatcher(Bus bus, List<Object> registeredObjectList) {
        mBus = bus;
        mRegisteredObjectList = registeredObjectList;
    }

    public void dispatch(Action action) {
        post(action);
    }

    public void register(Object obj) {
        if (!mRegisteredObjectList.contains(obj)) {
            mRegisteredObjectList.add(obj);
            mBus.register(obj);
        }
    }

    public void unregister(Object obj) {
        mRegisteredObjectList.remove(obj);
        mBus.unregister(obj);
    }

    public void post(Object event) {
        mBus.post(event);
    }
}
