package com.willy.fluxandroid.store;

import com.squareup.otto.Bus;
import com.squareup.otto.Subscribe;
import com.willy.fluxandroid.action.Action;
import com.willy.fluxandroid.action.ButtonActions;

/**
 * Created by Willy on 2016/4/28.
 */
public class MainStore extends Store {

    private volatile static MainStore instance;

    public static MainStore getInstance() {
        if (instance == null) {
            synchronized (MainStore.class) {
                if (instance == null) {
                    instance = new MainStore(new Bus());
                }
            }
        }
        return instance;
    }

    private String mText;

    public MainStore(Bus bus) {
        super(bus);
    }

    @Override
    @Subscribe
    public void onAction(Action action) {
        super.onAction(action);
        switch (action.getType()) {
            case ButtonActions.CLICk:
                //do something
                mText = action.getData().get("text").toString();
                break;
            case ButtonActions.OTHER:
                //do something
                mText = action.getData().get("text").toString();
        }
        emitChange();
    }

    private void emitChange() {
        mBus.post(new MainStoreChangeEvent());
    }

    public class MainStoreChangeEvent implements StoreChangeEvent {

    }

    public String getText() {
        return mText;
    }
}
