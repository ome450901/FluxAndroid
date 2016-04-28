package com.willy.fluxandroid.store;

import com.squareup.otto.Bus;
import com.willy.fluxandroid.action.Action;

/**
 * Created by Willy on 2016/4/28.
 */
public class Store {

    protected Bus mBus;

    public Store(Bus bus){
        mBus = bus;
    }

    public void register(Object obj){
        mBus.register(obj);
    }

    public void unregister(Object obj){
        mBus.unregister(obj);
    }

    public void onAction(Action action){}

    public interface StoreChangeEvent{}
}
