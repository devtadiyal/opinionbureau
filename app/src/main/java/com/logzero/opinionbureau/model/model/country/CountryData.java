package com.logzero.opinionbureau.model.model.country;

import android.os.Parcel;
import android.os.Parcelable;

import java.util.ArrayList;

public class CountryData implements Parcelable {


    protected CountryData(Parcel in) {
        country_id = in.readString();
        country_name = in.readString();
        country_code = in.readString();
        country_flag = in.readString();
        languages = in.createTypedArrayList(CountryLanguage.CREATOR);
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(country_id);
        dest.writeString(country_name);
        dest.writeString(country_code);
        dest.writeString(country_flag);
        dest.writeTypedList(languages);
    }

    @Override
    public int describeContents() {
        return 0;
    }

    public static final Creator<CountryData> CREATOR = new Creator<CountryData>() {
        @Override
        public CountryData createFromParcel(Parcel in) {
            return new CountryData(in);
        }

        @Override
        public CountryData[] newArray(int size) {
            return new CountryData[size];
        }
    };

    public String getCountry_id() {
        return country_id;
    }

    public void setCountry_id(String country_id) {
        this.country_id = country_id;
    }

    public String getCountry_name() {
        return country_name;
    }

    public void setCountry_name(String country_name) {
        this.country_name = country_name;
    }

    public String getCountry_code() {
        return country_code;
    }

    public void setCountry_code(String country_code) {
        this.country_code = country_code;
    }

    public String getCountry_flag() {
        return country_flag;
    }

    public void setCountry_flag(String country_flag) {
        this.country_flag = country_flag;
    }

    public ArrayList<CountryLanguage> getLanguages() {
        return languages;
    }

    public void setLanguages(ArrayList<CountryLanguage> languages) {
        this.languages = languages;
    }

    private String country_id;
    private String country_name;
    private String country_code;
    private String country_flag;
    private ArrayList<CountryLanguage> languages;


}
