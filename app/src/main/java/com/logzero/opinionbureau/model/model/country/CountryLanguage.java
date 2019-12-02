package com.logzero.opinionbureau.model.model.country;

import android.os.Parcel;
import android.os.Parcelable;

public class CountryLanguage implements Parcelable {

    private String lang_id;
    private String language;

    public String getLang_id() {
        return lang_id;
    }

    public void setLang_id(String lang_id) {
        this.lang_id = lang_id;
    }

    public String getLanguage() {
        return language;
    }

    public void setLanguage(String language) {
        this.language = language;
    }

    protected CountryLanguage(Parcel in) {
        lang_id = in.readString();
        language = in.readString();
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(lang_id);
        dest.writeString(language);
    }

    @Override
    public int describeContents() {
        return 0;
    }

    public static final Creator<CountryLanguage> CREATOR = new Creator<CountryLanguage>() {
        @Override
        public CountryLanguage createFromParcel(Parcel in) {
            return new CountryLanguage(in);
        }

        @Override
        public CountryLanguage[] newArray(int size) {
            return new CountryLanguage[size];
        }
    };


}
