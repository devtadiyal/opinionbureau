package com.logzero.opinionbureau.utility;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class ProjectUtil {

    public static boolean isValidEmail(String email) {

        boolean isValid = false;
        String expression = "^[\\w.-]+@([\\w\\-]+\\.)+[A-Z]{2,4}$";

        Pattern pattern = Pattern.compile(expression, Pattern.CASE_INSENSITIVE);
        Matcher matcher = pattern.matcher(email);
        if (matcher.matches()) {
            isValid = true;
        }
        return isValid;
    }

    public static boolean isInValidPhone(String phone) {
        return !android.util.Patterns.PHONE.matcher(phone).matches();
        /*|| !validateUsing_libphonenumber("91", phone);*/
    }

    private static void isPhoneOrFixedLineNumber() {

        /*PhoneNumberUtil.PhoneNumberType isMobile = phoneNumberUtil.getNumberType(phoneNumber);
        if(PhoneNumberUtil.PhoneNumberType.MOBILE==isMobile){
            showSnackMessage( "Mobile Number is Valid " + internationalFormat);
        }
        else if(PhoneNumberUtil.PhoneNumberType.FIXED_LINE==isMobile){
            showSnackMessage( "Fixed Line is Valid " + internationalFormat);
        }*/
    }

    public static String getCountryCode(String codeInDigit) {
        String code = null;
        switch (codeInDigit) {
            case "1":
                code = "US";
                break;
            case "91":
                code = "IN";
                break;
            case "1-264":
                code = "AI";
                break;
            case "1-268":
                code = "AG";
                break;
            case "297":
                code = "AW";
                break;
            case "1-242":
                code = "BS";
                break;
            case "1-246":
                code = "BB";
                break;
            case "1-345":
                code = "KY";
                break;
            case "53":
                code = "CU";
                break;
            case "599":
                code = "CW";
                break;
            case "1-767":
                code = "DM";
                break;
            case "1-809":
                code = "DO";
                break;
            case "1-829":
                code = "DO";
                break;
            case "1-849":
                code = "DO";
                break;
            case "1-473":
                code = "GD";
                break;
            case "590":
                code = "GP";
                break;
            case "509":
                code = "HT";
                break;
            case "1-876":
                code = "JM";
                break;
            case "596":
                code = "MQ";
                break;
            case "1-664":
                code = "MS";
                break;
            case "1-869":
                code = "KN";
                break;
            case "1-758":
                code = "LC";
                break;
            case "1-784":
                code = "VC";
                break;
            case "1-868":
                code = "TT";
                break;
        }

        return code;
    }

    public static String getPhoneCountryCode(String codeInDigit) {
        String code = null;
        switch (codeInDigit) {
            case "1":
                code = "USA";
                break;
            case "91":
                code = "IND";
                break;
            case "1-264":
                code = "AIA";
                break;
            case "1-268":
                code = "ATG";
                break;
            case "297":
                code = "ABW";
                break;
            case "1-242":
                code = "BHS";
                break;
            case "1-246":
                code = "BRB";
                break;
            case "1-345":
                code = "CYM";
                break;
            case "53":
                code = "CUB";
                break;
            case "599":
                code = "CUW";
                break;
            case "1-767":
                code = "DMA";
                break;
            case "1-809":
                code = "DOM";
                break;
            case "1-829":
                code = "DOM";
                break;
            case "1-849":
                code = "DOM";
                break;
            case "1-473":
                code = "GRD";
                break;
            case "590":
                code = "GLP";
                break;
            case "509":
                code = "HTI";
                break;
            case "1-876":
                code = "JAM";
                break;
            case "596":
                code = "MTQ";
                break;
            case "1-664":
                code = "MSR";
                break;
            case "1-869":
                code = "KNA";
                break;
            case "1-758":
                code = "LCA";
                break;
            case "1-784":
                code = "VCT";
                break;
            case "1-868":
                code = "TTO";
                break;
        }

        return code;
    }


}