package com.gxz.mymvp.net;

import com.google.gson.annotations.SerializedName;

public class DatasResult<T> {

    @SerializedName("count")
    public int count;

    @SerializedName("rows")
    T rows;

    public T getRows() {
        return rows;
    }

    @Override
    public String toString() {
        return "DatasResult{" +
                "count=" + count +
                ", rows=" + rows +
                '}';
    }
}
