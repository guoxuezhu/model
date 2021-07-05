package com.gxz.mymvp.net;

import com.google.gson.annotations.SerializedName;

public class HttpResult<T> {

    @SerializedName("flag")
    public String flag;

    @SerializedName("msg")
    public String msg;

    @SerializedName("data")
    T data;

    public T getData() {
        return data;
    }

    @Override
    public String toString() {
        return "HttpResult{" +
                "flag='" + flag + '\'' +
                ", msg='" + msg + '\'' +
                ", data=" + data +
                '}';
    }
}
