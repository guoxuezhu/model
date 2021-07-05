package com.gxz.mymvp.data.model;

import com.google.gson.annotations.SerializedName;

public class ZksDevice {

    @SerializedName("id")
    public int id;

    @SerializedName("title")
    public String title;

    @SerializedName("ip")
    public String ip;

    @Override
    public String toString() {
        return "ZksDevice{" +
                "id=" + id +
                ", title='" + title + '\'' +
                ", ip='" + ip + '\'' +
                '}';
    }
}
