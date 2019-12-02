package com.logzero.opinionbureau.signup

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.logzero.opinionbureau.R
import kotlinx.android.synthetic.main.activity_signup_two.next
import android.widget.TextView.BufferType
import android.text.Html
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_signup_one.*


class SignupOneActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_signup_one)

        val text = "Complete your profile to earn This is an <u><font color=\"#D81B60\">xxxx</font></u> \n  points."
        heading.setText(Html.fromHtml(text), BufferType.SPANNABLE)
        next.setOnClickListener {
            if(firstname.text.toString().length==0)
            {
                Toast.makeText(this@SignupOneActivity,"Please enter first name", Toast.LENGTH_SHORT).show()
            }
            else if(lastname.text.toString().length==0)
            {
                Toast.makeText(this@SignupOneActivity,"Please enter last name", Toast.LENGTH_SHORT).show()

            }
            else
            {
                val i = Intent(this@SignupOneActivity, SignupTwoActivity::class.java)
                startActivity(i)
            }

        }


    }
}
