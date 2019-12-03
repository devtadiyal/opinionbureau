package com.logzero.opinionbureau.lang;

import com.logzero.opinionbureau.culture.CulturePresenter;
import com.logzero.opinionbureau.model.model.culture.CultureModel;
import com.logzero.opinionbureau.model.model.language.LanguageModel;
import com.logzero.opinionbureau.mvp.BasePresenter;
import com.logzero.opinionbureau.networking.ApiClient;
import com.logzero.opinionbureau.networking.ApiInterface;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class LanguageImp extends BasePresenter<LanguagePresenter.View> implements LanguagePresenter {


    public LanguageImp(View mview) {
        view = mview;
    }

    @Override
    public void onViewActive(View view) {
        super.onViewActive(view);
    }

    @Override
    public void onViewInActive() {
        super.onViewInActive();
    }


    @Override
    public void getLanguage(String cultureid) {
        try {
            view.showLoadingLayout();
            if (view == null) {
                return;
            }

            ApiInterface apiInterface = ApiClient.getClient().create(ApiInterface.class);
            apiInterface.getLanguage(cultureid)
                    .enqueue(new Callback<LanguageModel>() {

                        @Override
                        public void onResponse(Call<LanguageModel> call, Response<LanguageModel> response) {
                            view.hideLoadingLayout();
                            if (response.body() != null) {
                                LanguageModel loginModel = response.body();
                                view.languageResponse(loginModel);
                            } else {
                       /* ResponseBody body = response.errorBody();
                        try {
                            JSONObject json = (JSONObject) new JSONTokener(body.string()).nextValue();
                            JSONObject json2 = json.getJSONObject("error");
                            String errorMessage = (String) json2.get("msg");
                            view.showError(errorMessage);
                        } catch (IOException e) {
                            e.printStackTrace();
                        } catch (JSONException e) {
                            e.printStackTrace();
                        }*/
                            }
                        }

                        @Override
                        public void onFailure(Call<LanguageModel> call, Throwable t) {
                            if (view != null) {
                                view.hideLoadingLayout();
                                view.showError(t.getMessage());
                            }
                        }
                    });
        } catch (Exception e) {
            e.printStackTrace();
        }

    }
}
