package com.willy.fluxandroid.action;

import java.util.HashMap;

/**
 * Created by Willy on 2016/4/28.
 */
public class Action {

    private final String mType;
    private final HashMap<String, Object> mData;

    public Action(String type, HashMap<String, Object> data){
        mType = type;
        mData = data;
    }

    public HashMap<String, Object> getData() {
        return mData;
    }

    public String getType() {
        return mType;
    }
}
