package com.singpaulee.mcdhore.Model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;
import com.singpaulee.mcdhore.Model.NewsDetail;

import java.util.ArrayList;

/**
 * Created by ASUS on 30/12/2017.
 */

public class ResponseList {
    @SerializedName("twitter")
    @Expose
    private ArrayList<NewsDetail> respons = null;

    @SerializedName("stopword")
    @Expose
    private ArrayList<StopWordModel> stopword = null;

    public ArrayList<NewsDetail> getRespons() {
        return respons;
    }

    public void setTwitter(ArrayList<NewsDetail> respons) {
        this.respons = respons;
    }

    public void setRespons(ArrayList<NewsDetail> respons) {
        this.respons = respons;
    }

    public ArrayList<StopWordModel> getStopword() {
        return stopword;
    }

    public void setStopword(ArrayList<StopWordModel> stopword) {
        this.stopword = stopword;
    }
}
