package com.logzero.opinionbureau.networking;

import com.logzero.opinionbureau.api_content.WebApiKey;
import com.logzero.opinionbureau.model.model.country.CountryModel;

import retrofit2.Call;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.Header;
import retrofit2.http.POST;

public interface ApiInterface {



    @POST("get_language_country_by_countryCode")
    @FormUrlEncoded
    Call<CountryModel> getCulture(
            @Field(WebApiKey.KEY_COUNTRYCODE) String country_code);



}