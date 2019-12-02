package com.logzero.opinionbureau.country

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import com.hbb20.CountryCodePicker
import com.logzero.opinionbureau.R
import kotlinx.android.synthetic.main.activity_country.*

class CountryActivity : AppCompatActivity(), CountryCodePicker.OnCountryChangeListener {

    private var countryCode:String?=null
    private var countryName:String?=null
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_country)

        country_code_picker!!.setOnCountryChangeListener(this)

        //to set default country code as Japan

        country_code_picker!!.setDefaultCountryUsingNameCode("JP")
    }

    override fun onCountrySelected() {
        countryCode = country_code_picker!!.selectedCountryCode
        countryName = country_code_picker!!.selectedCountryName

        Toast.makeText(this, "Country Code " + countryCode, Toast.LENGTH_SHORT).show()
        Toast.makeText(this, "Country Name " + countryName, Toast.LENGTH_SHORT).show()
    }
}
/*
To hide flag
app:ccp_showFlag=”false”

To hide Name code
app:ccp_showNameCode=”false”*/
