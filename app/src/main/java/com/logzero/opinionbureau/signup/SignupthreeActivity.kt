package com.logzero.opinionbureau.signup

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.logzero.opinionbureau.R
import android.text.InputType
import android.text.method.PasswordTransformationMethod
import android.widget.Toast
import com.logzero.opinionbureau.utility.Preference
import kotlinx.android.synthetic.main.activity_signupthree.*


class SignupthreeActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_signupthree)

        next.setOnClickListener {
            if (email.text.toString().length == 0) {
                Toast.makeText(
                    this@SignupthreeActivity,
                    Preference.getInstance(this).getFromPreference("val_enter_email_add"),
                    Toast.LENGTH_SHORT
                ).show()
            } else if (phone.text.toString().length == 0) {
                Toast.makeText(
                    this@SignupthreeActivity,
                    Preference.getInstance(this).getFromPreference("val_enter_phoneno"),
                    Toast.LENGTH_SHORT
                ).show()

            } else if (password.text.toString().length == 0) {
                Toast.makeText(
                    this@SignupthreeActivity,
                    Preference.getInstance(this).getFromPreference("val_password"),
                    Toast.LENGTH_SHORT
                ).show()

            } else if (check.isChecked == false) {
                Toast.makeText(
                    this@SignupthreeActivity,
                    "Please agree with terms & condition and privacy policy",
                    Toast.LENGTH_SHORT
                ).show()

            } else {
                val i = Intent(this@SignupthreeActivity, ThanksActivity::class.java)
                startActivity(i)
            }


        }

        password.setInputType(InputType.TYPE_TEXT_VARIATION_PASSWORD);
        password.setTransformationMethod(PasswordTransformationMethod.getInstance());

    }

    override fun onResume() {
        super.onResume()

        //  heading.setText(Preference.getInstance(this).getFromPreference("completeprofiletoearn"))
        email.setHint(Preference.getInstance(this).getFromPreference("emailaddress"))
        phone.setHint(Preference.getInstance(this).getFromPreference("phoneno"))
        password.setHint(Preference.getInstance(this).getFromPreference("password"))
        termsandcond.setText(Preference.getInstance(this).getFromPreference("agreewithtermsandprivacy"))
        signup.setText(Preference.getInstance(this).getFromPreference("signup"))
    }
}
