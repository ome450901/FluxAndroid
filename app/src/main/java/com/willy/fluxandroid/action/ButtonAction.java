package com.willy.fluxandroid.action;

import java.util.HashMap;

/**
 * Created by Willy on 2016/4/28.
 */
public class ButtonAction extends Action{

    public ButtonAction(String type, HashMap<String, Object> data) {
        super(type, data);
    }

    public interface ButtonActionType {
        String CLICk = "click";
        String OTHER = "other";
    }
}
