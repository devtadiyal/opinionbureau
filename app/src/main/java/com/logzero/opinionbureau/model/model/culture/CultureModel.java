package com.logzero.opinionbureau.model.model.culture;

import android.os.Parcel;
import android.os.Parcelable;

public class CultureModel implements Parcelable {


    protected CultureModel(Parcel in) {
        status = in.readInt();
        culture_id = in.readInt();
        message = in.readString();
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeInt(status);
        dest.writeInt(culture_id);
        dest.writeString(message);
    }

    @Override
    public int describeContents() {
        return 0;
    }

    public static final Creator<CultureModel> CREATOR = new Creator<CultureModel>() {
        @Override
        public CultureModel createFromParcel(Parcel in) {
            return new CultureModel(in);
        }

        @Override
        public CultureModel[] newArray(int size) {
            return new CultureModel[size];
        }
    };

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    public int getCulture_id() {
        return culture_id;
    }

    public void setCulture_id(int culture_id) {
        this.culture_id = culture_id;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    private int status;
    private int culture_id;
    private String message;

}
