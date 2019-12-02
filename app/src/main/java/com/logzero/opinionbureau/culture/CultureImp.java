package com.logzero.opinionbureau.culture;

import com.logzero.opinionbureau.model.model.country.CountryModel;
import com.logzero.opinionbureau.mvp.BasePresenter;
import com.logzero.opinionbureau.networking.ApiClient;
import com.logzero.opinionbureau.networking.ApiInterface;
import com.logzero.opinionbureau.utility.Constant;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class CultureImp extends BasePresenter<CulturePresenter.View> implements CulturePresenter {


    public CultureImp(View mview) {
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
    public void getCountryCode(String content_type, String country_code) {
        try {
            view.showLoadingLayout();
            if (view == null) {
                return;
            }

            ApiInterface apiInterface = ApiClient.getClient().create(ApiInterface.class);
            apiInterface.getCulture(country_code)
                    .enqueue(new Callback<CountryModel>() {

                        @Override
                        public void onResponse(Call<CountryModel> call, Response<CountryModel> response) {
                            view.hideLoadingLayout();
                            if (response.body() != null) {
                                CountryModel loginModel = response.body();
                                view.countryResponse(loginModel);
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
                        public void onFailure(Call<CountryModel> call, Throwable t) {
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
