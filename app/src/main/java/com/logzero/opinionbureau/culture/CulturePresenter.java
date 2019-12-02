package com.logzero.opinionbureau.culture;

import com.logzero.opinionbureau.model.model.country.CountryModel;
import com.logzero.opinionbureau.model.model.culture.CultureModel;
import com.logzero.opinionbureau.mvp.MainView;

public interface CulturePresenter {

    interface View<ViewT> extends MainView<ViewT> {

        void cultureResponse(CultureModel response);
    }

    void getCultureID(String countryid, String langid,
                      String deviceimei, String devicetype,
                      String ipaddress);
}

