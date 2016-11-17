package com.toda.broker.model;

/**
 * Created by Zhao Haibin on 2016/3/17.
 */
public interface RequestSuccessListener<T> {
    public void onSuccess(T t);
}
