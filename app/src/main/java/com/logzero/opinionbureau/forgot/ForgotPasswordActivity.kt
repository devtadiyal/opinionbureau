package com.logzero.opinionbureau.forgot

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import com.logzero.opinionbureau.R
import com.logzero.opinionbureau.signup.SignupthreeActivity
import kotlinx.android.synthetic.main.activity_forgot_password.*
import kotlinx.android.synthetic.main.activity_forgot_password.next
import kotlinx.android.synthetic.main.activity_signup_two.*

class ForgotPasswordActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_forgot_password)


        next.setOnClickListener {
            if(email.text.toString().isEmpty())
            {
                Toast.makeText(this@ForgotPasswordActivity,"Please enter email address", Toast.LENGTH_SHORT).show()
            }
            else
            {
                //val i = Intent(this@ForgotPasswordActivity, SignupthreeActivity::class.java)
                //startActivity(i)
            }
        }
    }
}
