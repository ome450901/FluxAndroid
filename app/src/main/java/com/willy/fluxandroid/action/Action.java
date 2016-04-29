package com.willy.fluxandroid.action;

import java.util.HashMap;

/**
 * Created by Willy on 2016/4/28.
 */
public class Action {

    private final String mType;
    private final HashMap<String, Object> mData;

    public Action(String type, HashMap<String, Object> data) {
        mType = type;
        mData = data;
    }

    public HashMap<String, Object> getData() {
        return mData;
    }

    public String getType() {
        return mType;
    }

    public static class ActionBuilder {

        private String mType;
        private HashMap<String, Object> mData = new HashMap<>();

        void setType(String type) {
            mType = type;
        }

        void put(String key, Object value) {

            if (key == null) {
                throw new IllegalArgumentException("Key may not be null.");
            }

            if (value == null) {
                throw new IllegalArgumentException("Value may not be null.");
            }

            mData.put(key, value);
        }

        Action build(){
            return new Action(mType, mData);
        }

    }
}
