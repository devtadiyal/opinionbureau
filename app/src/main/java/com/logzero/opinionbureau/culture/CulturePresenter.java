package com.logzero.opinionbureau.culture;

import com.logzero.opinionbureau.model.model.country.CountryModel;
import com.logzero.opinionbureau.mvp.MainView;

public interface CulturePresenter {

     interface View<ViewT> extends MainView<ViewT> {

        void countryResponse(CountryModel response);
    }

    void getCountryCode(String contenttype,String countrycode);


}
