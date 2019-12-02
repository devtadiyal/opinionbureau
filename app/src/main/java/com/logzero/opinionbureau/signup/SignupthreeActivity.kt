package com.logzero.opinionbureau.signup

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.logzero.opinionbureau.R
import android.text.InputType
import android.text.method.PasswordTransformationMethod
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_signup_two.*
import kotlinx.android.synthetic.main.activity_signupthree.*
import kotlinx.android.synthetic.main.activity_signupthree.next


class SignupthreeActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_signupthree)

        next.setOnClickListener {
            if(email.text.toString().length==0)
            {
                Toast.makeText(this@SignupthreeActivity,"Please enter email address", Toast.LENGTH_SHORT).show()
            }
            else if(phone.text.toString().length==0)
            {
                Toast.makeText(this@SignupthreeActivity,"Please enter phone number", Toast.LENGTH_SHORT).show()

            }
            else if(password.text.toString().length==0)
            {
                Toast.makeText(this@SignupthreeActivity,"Please enter password", Toast.LENGTH_SHORT).show()

            }
            else if(check.isChecked==false)
            {
                Toast.makeText(this@SignupthreeActivity,"Please agree with terms & condition and privacy policy", Toast.LENGTH_SHORT).show()

            }
            else
            {
                val i = Intent(this@SignupthreeActivity, ThanksActivity::class.java)
                startActivity(i)
            }


        }

        password.setInputType(InputType.TYPE_TEXT_VARIATION_PASSWORD);
        password.setTransformationMethod(PasswordTransformationMethod.getInstance());

    }


}
