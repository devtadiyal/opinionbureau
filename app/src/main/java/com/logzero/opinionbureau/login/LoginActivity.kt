package com.logzero.opinionbureau.login

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.CountDownTimer
import android.text.method.PasswordTransformationMethod
import android.text.InputType
import kotlinx.android.synthetic.main.activity_login.*
import android.text.Editable
import android.text.TextWatcher
import android.view.View
import android.view.View.*
import com.logzero.opinionbureau.forgot.ForgotPasswordActivity
import com.logzero.opinionbureau.utility.ProjectUtil
import kotlinx.android.synthetic.main.activity_login.next
import kotlinx.android.synthetic.main.activity_login.password


class LoginActivity : AppCompatActivity() {
    // 60 seconds (1 minute)
    val minute: Long = 1000 * 60 // 1000 milliseconds = 1 second

    // 1 day 2 hours 35 minutes 50 seconds
    val millisInFuture: Long = (minute * 1440) + (minute * 155) + (1000 * 50)

    // Count down interval 1 second
    val countDownInterval: Long = 1000

    private val mobileCode = "91"
    private var isCancelled = false

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(com.logzero.opinionbureau.R.layout.activity_login)

        password.setInputType(InputType.TYPE_TEXT_VARIATION_PASSWORD);
        password.setTransformationMethod(PasswordTransformationMethod.getInstance());

        linear3.visibility = GONE
        forgot.visibility = GONE

        forgot.setOnClickListener {
            if (forgot.text.toString().equals("Re-send OTP")) {

            } else {
                val i = Intent(this@LoginActivity, ForgotPasswordActivity::class.java)
                startActivity(i)
            }

        }
        next.setOnClickListener {
        }



        inputfield.addTextChangedListener(object : TextWatcher {

            override fun onTextChanged(
                s: CharSequence, start: Int, before: Int,
                count: Int
            ) {
                // TODO Auto-generated method stub

            }

            override fun beforeTextChanged(
                s: CharSequence, start: Int, count: Int,
                after: Int
            ) {
                // TODO Auto-generated method stub

            }

            override fun afterTextChanged(s: Editable) {
                // TODO Auto-generated method stub

                // TODO Auto-generated method stub
                val userInput = inputfield.getText().toString().trim()
                //var v = if (a) b else c

                val userName =
                    if (ProjectUtil.isValidEmail(userInput)) userInput else mobileCode + userInput


                val pin = password.getText().toString().trim()

                if (userInput.isEmpty()) {
                    linear3.visibility = GONE
                    forgot.visibility = GONE
                } else if (userName.matches("[0-9]+".toRegex()) && userInput.length < 10) {
                    linear3.visibility = VISIBLE
                    forgot.visibility = VISIBLE


                    forgot.text = "Re-send OTP"

                    // password.setHint("Enter OTP")
                    password.setInputType(InputType.TYPE_CLASS_NUMBER);

                } else if (!userName.matches("[0-9]+".toRegex()) && !ProjectUtil.isValidEmail(
                        userInput
                    )
                ) {
                    linear3.visibility = VISIBLE
                    forgot.visibility = VISIBLE


                    forgot.text = "Forgot Password?"
                    //  password.setHint("Password")
                    password.setInputType(InputType.TYPE_TEXT_VARIATION_PASSWORD);

                } else if (pin.isEmpty()) {
                    linear3.visibility = VISIBLE
                    forgot.visibility = VISIBLE
                    timer.visibility = View.VISIBLE

                    OTPtimer("")


                } else {
                    timer.visibility = View.VISIBLE
                    OTPtimer("")
                }
            }


        })

    }

    fun OTPtimer(msg: String) {
        object : CountDownTimer(60000, 1000) {

            override fun onTick(millisUntilFinished: Long) {
                timer.setText("01:" + millisUntilFinished / 1000)
            }

            override fun onFinish() {
                timer.setText("")

            }
        }.start()
    }
}




