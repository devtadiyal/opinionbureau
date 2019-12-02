package com.logzero.opinionbureau.model.model.country;

import android.os.Parcel;
import android.os.Parcelable;

import java.util.ArrayList;

public class CountryModel implements Parcelable {


    protected CountryModel(Parcel in) {
        status = in.readInt();
        message = in.readString();
        data = in.createTypedArrayList(CountryData.CREATOR);
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeInt(status);
        dest.writeString(message);
        dest.writeTypedList(data);
    }

    @Override
    public int describeContents() {
        return 0;
    }

    public static final Creator<CountryModel> CREATOR = new Creator<CountryModel>() {
        @Override
        public CountryModel createFromParcel(Parcel in) {
            return new CountryModel(in);
        }

        @Override
        public CountryModel[] newArray(int size) {
            return new CountryModel[size];
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

    public ArrayList<CountryData> getData() {
        return data;
    }

    public void setData(ArrayList<CountryData> data) {
        this.data = data;
    }

    private int status;
    private String message;
    private ArrayList<CountryData> data;


}
