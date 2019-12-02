package com.logzero.opinionbureau.country;

import com.logzero.opinionbureau.model.model.country.CountryModel;
import com.logzero.opinionbureau.mvp.MainView;

public interface CountryPresenter {

     interface View<ViewT> extends MainView<ViewT> {

        void countryResponse(CountryModel response);
    }

    void getCountryCode(String contenttype,String countrycode);


}
