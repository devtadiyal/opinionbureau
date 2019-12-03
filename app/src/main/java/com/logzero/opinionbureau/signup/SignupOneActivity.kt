package com.logzero.opinionbureau.signup

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.logzero.opinionbureau.R
import kotlinx.android.synthetic.main.activity_signup_two.next
import android.widget.TextView.BufferType
import android.text.Html
import android.widget.Toast
import com.logzero.opinionbureau.utility.Preference
import kotlinx.android.synthetic.main.activity_signup_one.*
import kotlinx.android.synthetic.main.activity_signup_option.*


class SignupOneActivity : AppCompatActivity() {
  //  private lateinit var email : String
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_signup_one)

        val bundle: Bundle? = intent.extras
        if (bundle != null) {
            val name: String = intent.getStringExtra("name")
           //  email = intent.getStringExtra("email")

            firstname.setText(name)
            //lastname.setText(name)

        }

        val text =
            "Complete your profile to earn This is an <u><font color=\"#D81B60\">xxxx</font></u> \n  points."
        heading.setText(Html.fromHtml(text), BufferType.SPANNABLE)
        next.setOnClickListener {
            if (firstname.text.toString().length == 0) {
                Toast.makeText(
                    this@SignupOneActivity,
                    "Please enter first name",
                    Toast.LENGTH_SHORT
                ).show()
            } else if (lastname.text.toString().length == 0) {
                Toast.makeText(this@SignupOneActivity, "Please enter last name", Toast.LENGTH_SHORT)
                    .show()

            } else {
                val i = Intent(this@SignupOneActivity, SignupTwoActivity::class.java)
                //i.putExtra("email",email)
                startActivity(i)
            }

        }


    }

    override fun onResume() {
        super.onResume()

        heading.setText(Preference.getInstance(this).getFromPreference("completeprofiletoearn"))
        firstname.setHint(Preference.getInstance(this).getFromPreference("firstname"))
        lastname.setHint(Preference.getInstance(this).getFromPreference("lastname"))
        nextbutton.setText(Preference.getInstance(this).getFromPreference("next"))
    }
}
