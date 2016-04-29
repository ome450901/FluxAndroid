package com.willy.fluxandroid.action;

import com.willy.fluxandroid.dispatcher.Dispatcher;

/**
 * Created by Willy on 2016/4/28.
 */
public class ActionCreator {

    private volatile static ActionCreator instance;

    private Dispatcher mDispatcher;

    public static ActionCreator getInstance() {
        if (instance == null) {
            synchronized (ActionCreator.class) {
                if (instance == null) {
                    instance = new ActionCreator(Dispatcher.getInstance());
                }
            }
        }
        return instance;
    }

    public ActionCreator(Dispatcher dispatcher) {
        mDispatcher = dispatcher;
    }

    public void createClickAction() {
        Action.ActionBuilder actionBuilder = new Action.ActionBuilder();
        actionBuilder.setType(ButtonActions.CLICk);
        actionBuilder.put("text", "On Click Action!");

        mDispatcher.dispatch(actionBuilder.build());
    }

    public void createOtherAction() {
        Action.ActionBuilder actionBuilder = new Action.ActionBuilder();
        actionBuilder.setType(ButtonActions.OTHER);
        actionBuilder.put("text", "On Other Action!");

        mDispatcher.dispatch(actionBuilder.build());
    }
}
