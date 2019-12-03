package com.logzero.opinionbureau.lang;

import com.logzero.opinionbureau.model.model.culture.CultureModel;
import com.logzero.opinionbureau.model.model.language.LanguageModel;
import com.logzero.opinionbureau.mvp.MainView;

public interface LanguagePresenter {

    interface View<ViewT> extends MainView<ViewT> {

        void languageResponse(LanguageModel response);
    }

    void getLanguage(String cultureid);
}
