package com.logzero.opinionbureau.model.model.language;

import android.os.Parcel;
import android.os.Parcelable;

public class LanguageData implements Parcelable {

    private String phone_no;
    private String email_add;
    private String password;

    private String i_agree;
    private String i_dont_agree;
    private String next;
    private String gdpr_content;
    private String continue_with;
    private String or;

    private String complete_profile_to_earn;
    private String first_name;
    private String last_name;
    private String date_of_birth;
    private String gender;
    private String thank_you;


    protected LanguageData(Parcel in) {
        phone_no = in.readString();
        email_add = in.readString();
        password = in.readString();
        i_agree = in.readString();
        i_dont_agree = in.readString();
        next = in.readString();
        gdpr_content = in.readString();
        continue_with = in.readString();
        or = in.readString();
        complete_profile_to_earn = in.readString();
        first_name = in.readString();
        last_name = in.readString();
        date_of_birth = in.readString();
        gender = in.readString();
        thank_you = in.readString();
        opinion_is_important_to_us = in.readString();
        privacy_page_content = in.readString();
        term_and_condition_page_content = in.readString();
        agree_with_terms_conditon_privacy_policy = in.readString();
        login = in.readString();
        dont_have_an_account = in.readString();
        terms_and_condition = in.readString();
        privacy_policy = in.readString();
        sign_up = in.readString();
        forget_password = in.readString();
        enter_otp = in.readString();
        resend_otp = in.readString();
        oops = in.readString();
        sorry_not_avail_in_country_now_see_list_ofactive_country = in.readString();
        show_list = in.readString();
        back = in.readString();
        your_privacy_istop_priority = in.readString();
        email = in.readString();
        male = in.readString();
        female = in.readString();
        val_phone_email = in.readString();
        val_password = in.readString();
        val_enter_email_add = in.readString();
        val_agree_on_gdpr = in.readString();
        val_enter_firstname = in.readString();
        val_enter_lastname = in.readString();
        val_select_dob = in.readString();
        val_select_gender = in.readString();
        val_enter_phoneno = in.readString();
        we_are_available_inseveral_countries = in.readString();
        phone = in.readString();
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(phone_no);
        dest.writeString(email_add);
        dest.writeString(password);
        dest.writeString(i_agree);
        dest.writeString(i_dont_agree);
        dest.writeString(next);
        dest.writeString(gdpr_content);
        dest.writeString(continue_with);
        dest.writeString(or);
        dest.writeString(complete_profile_to_earn);
        dest.writeString(first_name);
        dest.writeString(last_name);
        dest.writeString(date_of_birth);
        dest.writeString(gender);
        dest.writeString(thank_you);
        dest.writeString(opinion_is_important_to_us);
        dest.writeString(privacy_page_content);
        dest.writeString(term_and_condition_page_content);
        dest.writeString(agree_with_terms_conditon_privacy_policy);
        dest.writeString(login);
        dest.writeString(dont_have_an_account);
        dest.writeString(terms_and_condition);
        dest.writeString(privacy_policy);
        dest.writeString(sign_up);
        dest.writeString(forget_password);
        dest.writeString(enter_otp);
        dest.writeString(resend_otp);
        dest.writeString(oops);
        dest.writeString(sorry_not_avail_in_country_now_see_list_ofactive_country);
        dest.writeString(show_list);
        dest.writeString(back);
        dest.writeString(your_privacy_istop_priority);
        dest.writeString(email);
        dest.writeString(male);
        dest.writeString(female);
        dest.writeString(val_phone_email);
        dest.writeString(val_password);
        dest.writeString(val_enter_email_add);
        dest.writeString(val_agree_on_gdpr);
        dest.writeString(val_enter_firstname);
        dest.writeString(val_enter_lastname);
        dest.writeString(val_select_dob);
        dest.writeString(val_select_gender);
        dest.writeString(val_enter_phoneno);
        dest.writeString(we_are_available_inseveral_countries);
        dest.writeString(phone);
    }

    @Override
    public int describeContents() {
        return 0;
    }

    public static final Creator<LanguageData> CREATOR = new Creator<LanguageData>() {
        @Override
        public LanguageData createFromParcel(Parcel in) {
            return new LanguageData(in);
        }

        @Override
        public LanguageData[] newArray(int size) {
            return new LanguageData[size];
        }
    };

    public String getPhone_no() {
        return phone_no;
    }

    public void setPhone_no(String phone_no) {
        this.phone_no = phone_no;
    }

    public String getEmail_add() {
        return email_add;
    }

    public void setEmail_add(String email_add) {
        this.email_add = email_add;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getI_agree() {
        return i_agree;
    }

    public void setI_agree(String i_agree) {
        this.i_agree = i_agree;
    }

    public String getI_dont_agree() {
        return i_dont_agree;
    }

    public void setI_dont_agree(String i_dont_agree) {
        this.i_dont_agree = i_dont_agree;
    }

    public String getNext() {
        return next;
    }

    public void setNext(String next) {
        this.next = next;
    }

    public String getGdpr_content() {
        return gdpr_content;
    }

    public void setGdpr_content(String gdpr_content) {
        this.gdpr_content = gdpr_content;
    }

    public String getContinue_with() {
        return continue_with;
    }

    public void setContinue_with(String continue_with) {
        this.continue_with = continue_with;
    }

    public String getOr() {
        return or;
    }

    public void setOr(String or) {
        this.or = or;
    }

    public String getComplete_profile_to_earn() {
        return complete_profile_to_earn;
    }

    public void setComplete_profile_to_earn(String complete_profile_to_earn) {
        this.complete_profile_to_earn = complete_profile_to_earn;
    }

    public String getFirst_name() {
        return first_name;
    }

    public void setFirst_name(String first_name) {
        this.first_name = first_name;
    }

    public String getLast_name() {
        return last_name;
    }

    public void setLast_name(String last_name) {
        this.last_name = last_name;
    }

    public String getDate_of_birth() {
        return date_of_birth;
    }

    public void setDate_of_birth(String date_of_birth) {
        this.date_of_birth = date_of_birth;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getThank_you() {
        return thank_you;
    }

    public void setThank_you(String thank_you) {
        this.thank_you = thank_you;
    }

    public String getOpinion_is_important_to_us() {
        return opinion_is_important_to_us;
    }

    public void setOpinion_is_important_to_us(String opinion_is_important_to_us) {
        this.opinion_is_important_to_us = opinion_is_important_to_us;
    }

    public String getPrivacy_page_content() {
        return privacy_page_content;
    }

    public void setPrivacy_page_content(String privacy_page_content) {
        this.privacy_page_content = privacy_page_content;
    }

    public String getTerm_and_condition_page_content() {
        return term_and_condition_page_content;
    }

    public void setTerm_and_condition_page_content(String term_and_condition_page_content) {
        this.term_and_condition_page_content = term_and_condition_page_content;
    }

    public String getAgree_with_terms_conditon_privacy_policy() {
        return agree_with_terms_conditon_privacy_policy;
    }

    public void setAgree_with_terms_conditon_privacy_policy(String agree_with_terms_conditon_privacy_policy) {
        this.agree_with_terms_conditon_privacy_policy = agree_with_terms_conditon_privacy_policy;
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public String getDont_have_an_account() {
        return dont_have_an_account;
    }

    public void setDont_have_an_account(String dont_have_an_account) {
        this.dont_have_an_account = dont_have_an_account;
    }

    public String getTerms_and_condition() {
        return terms_and_condition;
    }

    public void setTerms_and_condition(String terms_and_condition) {
        this.terms_and_condition = terms_and_condition;
    }

    public String getPrivacy_policy() {
        return privacy_policy;
    }

    public void setPrivacy_policy(String privacy_policy) {
        this.privacy_policy = privacy_policy;
    }

    public String getSign_up() {
        return sign_up;
    }

    public void setSign_up(String sign_up) {
        this.sign_up = sign_up;
    }

    public String getForget_password() {
        return forget_password;
    }

    public void setForget_password(String forget_password) {
        this.forget_password = forget_password;
    }

    public String getEnter_otp() {
        return enter_otp;
    }

    public void setEnter_otp(String enter_otp) {
        this.enter_otp = enter_otp;
    }

    public String getResend_otp() {
        return resend_otp;
    }

    public void setResend_otp(String resend_otp) {
        this.resend_otp = resend_otp;
    }

    private String opinion_is_important_to_us;
    private String privacy_page_content;
    private String term_and_condition_page_content;
    private String agree_with_terms_conditon_privacy_policy;
    private String login;
    private String dont_have_an_account;

    private String terms_and_condition;
    private String privacy_policy;
    private String sign_up;
    private String forget_password;
    private String enter_otp;
    private String resend_otp;

    public String getOops() {
        return oops;
    }

    public void setOops(String oops) {
        this.oops = oops;
    }

    public String getSorry_not_avail_in_country_now_see_list_ofactive_country() {
        return sorry_not_avail_in_country_now_see_list_ofactive_country;
    }

    public void setSorry_not_avail_in_country_now_see_list_ofactive_country(String sorry_not_avail_in_country_now_see_list_ofactive_country) {
        this.sorry_not_avail_in_country_now_see_list_ofactive_country = sorry_not_avail_in_country_now_see_list_ofactive_country;
    }

    public String getShow_list() {
        return show_list;
    }

    public void setShow_list(String show_list) {
        this.show_list = show_list;
    }

    public String getBack() {
        return back;
    }

    public void setBack(String back) {
        this.back = back;
    }

    public String getYour_privacy_istop_priority() {
        return your_privacy_istop_priority;
    }

    public void setYour_privacy_istop_priority(String your_privacy_istop_priority) {
        this.your_privacy_istop_priority = your_privacy_istop_priority;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getMale() {
        return male;
    }

    public void setMale(String male) {
        this.male = male;
    }

    public String getFemale() {
        return female;
    }

    public void setFemale(String female) {
        this.female = female;
    }

    public String getVal_phone_email() {
        return val_phone_email;
    }

    public void setVal_phone_email(String val_phone_email) {
        this.val_phone_email = val_phone_email;
    }

    public String getVal_password() {
        return val_password;
    }

    public void setVal_password(String val_password) {
        this.val_password = val_password;
    }

    public String getVal_enter_email_add() {
        return val_enter_email_add;
    }

    public void setVal_enter_email_add(String val_enter_email_add) {
        this.val_enter_email_add = val_enter_email_add;
    }

    public String getVal_agree_on_gdpr() {
        return val_agree_on_gdpr;
    }

    public void setVal_agree_on_gdpr(String val_agree_on_gdpr) {
        this.val_agree_on_gdpr = val_agree_on_gdpr;
    }

    public String getVal_enter_firstname() {
        return val_enter_firstname;
    }

    public void setVal_enter_firstname(String val_enter_firstname) {
        this.val_enter_firstname = val_enter_firstname;
    }

    public String getVal_enter_lastname() {
        return val_enter_lastname;
    }

    public void setVal_enter_lastname(String val_enter_lastname) {
        this.val_enter_lastname = val_enter_lastname;
    }

    public String getVal_select_dob() {
        return val_select_dob;
    }

    public void setVal_select_dob(String val_select_dob) {
        this.val_select_dob = val_select_dob;
    }

    public String getVal_select_gender() {
        return val_select_gender;
    }

    public void setVal_select_gender(String val_select_gender) {
        this.val_select_gender = val_select_gender;
    }

    public String getVal_enter_phoneno() {
        return val_enter_phoneno;
    }

    public void setVal_enter_phoneno(String val_enter_phoneno) {
        this.val_enter_phoneno = val_enter_phoneno;
    }

    private String oops;
    private String sorry_not_avail_in_country_now_see_list_ofactive_country;
    private String show_list;
    private String back;
    private String your_privacy_istop_priority;
    private String email;
    private String male;
    private String female;

    private String val_phone_email;
    private String val_password;
    private String val_enter_email_add;
    private String val_agree_on_gdpr;
    private String val_enter_firstname;
    private String val_enter_lastname;
    private String val_select_dob;
    private String val_select_gender;
    private String val_enter_phoneno;

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    private String phone;

    public String getWe_are_available_inseveral_countries() {
        return we_are_available_inseveral_countries;
    }

    public void setWe_are_available_inseveral_countries(String we_are_available_inseveral_countries) {
        this.we_are_available_inseveral_countries = we_are_available_inseveral_countries;
    }

    private String we_are_available_inseveral_countries;




}
