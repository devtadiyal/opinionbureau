package com.logzero.opinionbureau.signup

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.logzero.opinionbureau.R
import com.logzero.opinionbureau.utility.Preference
import kotlinx.android.synthetic.main.activity_thanks.*

class ThanksActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_thanks)
    }

    override fun onResume() {
        super.onResume()

        header.setText(Preference.getInstance(this).getFromPreference("thankyou"))
        text.setText(Preference.getInstance(this).getFromPreference("opinionimptous"))

    }
}
