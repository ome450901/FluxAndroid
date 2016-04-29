package com.willy.fluxandroid.action;

import com.willy.fluxandroid.dispatcher.Dispatcher;

import static com.willy.fluxandroid.action.ButtonAction.ButtonActionType.CLICk;
import static com.willy.fluxandroid.action.ButtonAction.ButtonActionType.OTHER;

/**
 * Created by Willy on 2016/4/28.
 */
public class ActionCreator {

    private volatile static ActionCreator instance;

    private Dispatcher mDispatcher;

    public static ActionCreator getInstance(){
        if(instance == null){
            synchronized (ActionCreator.class){
                if(instance == null){
                    instance = new ActionCreator(Dispatcher.getInstance());
                }
            }
        }
        return instance;
    }

    public ActionCreator(Dispatcher dispatcher){
        mDispatcher = dispatcher;
    }

    public void createClickAction(){
        mDispatcher.dispatch(new ButtonAction(CLICk,null));
    }

    public void createOtherAction(){
        mDispatcher.dispatch(new ButtonAction(OTHER,null));
    }
}
