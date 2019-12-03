package com.logzero.opinionbureau.model.model.language;

import android.os.Parcel;
import android.os.Parcelable;

import java.util.ArrayList;

public class LanguageModel implements Parcelable {

    protected LanguageModel(Parcel in) {
        status = in.readInt();
        message = in.readString();
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeInt(status);
        dest.writeString(message);
    }

    @Override
    public int describeContents() {
        return 0;
    }

    public static final Creator<LanguageModel> CREATOR = new Creator<LanguageModel>() {
        @Override
        public LanguageModel createFromParcel(Parcel in) {
            return new LanguageModel(in);
        }

        @Override
        public LanguageModel[] newArray(int size) {
            return new LanguageModel[size];
        }
    };

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public LanguageData getData() {
        return data;
    }

    public void setData(LanguageData data) {
        this.data = data;
    }

    private int status;
    private String message;
    private LanguageData data;


}
