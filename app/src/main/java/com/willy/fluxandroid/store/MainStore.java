package com.willy.fluxandroid.store;

import com.squareup.otto.Bus;
import com.squareup.otto.Subscribe;
import com.willy.fluxandroid.action.Action;

import static com.willy.fluxandroid.action.ButtonAction.ButtonActionType.CLICk;
import static com.willy.fluxandroid.action.ButtonAction.ButtonActionType.OTHER;

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
            case CLICk:
                mText = "On Click Action!";
                //do something
                break;
            case OTHER:
                mText = "On Other Action!";
                //do something
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
