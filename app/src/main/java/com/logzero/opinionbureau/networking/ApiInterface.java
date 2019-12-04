package com.logzero.opinionbureau.networking;

import com.logzero.opinionbureau.api_content.WebApiKey;
import com.logzero.opinionbureau.model.model.country.CountryModel;
import com.logzero.opinionbureau.model.model.culture.CultureModel;
import com.logzero.opinionbureau.model.model.language.LanguageModel;
import retrofit2.Call;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.POST;

public interface ApiInterface {


    @POST("get_language_country_by_countryCode")
    @FormUrlEncoded
    Call<CountryModel> getCountryID(
            @Field(WebApiKey.KEY_COUNTRYCODE) String country_code);


    @POST("get_culture")
    @FormUrlEncoded
    Call<CultureModel> getCultureID(
            @Field(WebApiKey.KEY_COUNTRYID) String country_id,
            @Field(WebApiKey.KEY_LANGID) String lang_id,
            @Field(WebApiKey.KEY_DEVICEIMEI) String device_imei,
            @Field(WebApiKey.KEY_DEVICETYPE) String device_type,
            @Field(WebApiKey.KEY_IPADDRESS) String ip_address);


    @POST("page_content_before_signup")
    @FormUrlEncoded
    Call<LanguageModel> getLanguage(
            @Field(WebApiKey.KEY_CULTUREID) String culture_id);




}