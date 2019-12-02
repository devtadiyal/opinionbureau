package com.logzero.opinionbureau.signup

import android.animation.AnimatorSet
import android.animation.ObjectAnimator
import android.app.Application
import android.content.Intent
import android.graphics.Rect
import android.os.Bundle
import android.widget.RadioButton
import android.widget.RadioGroup
import android.widget.Toast
import com.logzero.opinionbureau.R
import com.logzero.opinionbureau.utility.BaseActivity
import kotlinx.android.synthetic.main.activity_gdpr.*
import kotlinx.android.synthetic.main.activity_signup_two.next
import android.graphics.Typeface
import android.view.View
import android.view.ViewGroup
import android.view.animation.AccelerateInterpolator
import android.view.animation.BounceInterpolator
import kotlinx.android.synthetic.main.app_bar_main.*


class GDPRActivity : BaseActivity() {
    var getText: String = ""
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_gdpr)


        next.setOnClickListener {
            if (getText.equals("I agree")) {

                val i = Intent(this@GDPRActivity, SignupOptionActivity::class.java)
                startActivity(i)


            } else if (getText.equals("")) {
                Toast.makeText(this@GDPRActivity, "Please agree on gdpr", Toast.LENGTH_SHORT).show()
            } else {
                finish()
            }


        }

        // Get radio group selected item using on checked change listener
        groupradio.setOnCheckedChangeListener(
            RadioGroup.OnCheckedChangeListener { group, checkedId ->
                val radio: RadioButton = findViewById(checkedId)
                /*Toast.makeText(applicationContext," On checked change :"+
                        " ${radio.text}",
                    Toast.LENGTH_SHORT).show()*/
                getText = radio.text.toString()
                if (getText.equals("I agree")) {
                    //lottie.visibility=View.VISIBLE
                    //lottie.setAnimation("accept.json")
                    //  lottie.visibility=View.INVISIBLE

                }
            })

        val font = Typeface.createFromAsset(assets, "fonts/SegoeUI_gdi.ttf")
        radia_id1.typeface = font
        radia_id2.typeface = font
        radia_id1.setTextColor(resources.getColor(R.color.colorPrimary))
        radia_id2.setTextColor(getResources().getColor(R.color.colorPrimary))


    }

    override fun onResume() {
        super.onResume()
        fade(linearlay)
    }

    fun fade(view: ViewGroup) {
        var fade = ObjectAnimator.ofFloat(view, View.ALPHA, 0.2f, 1.0f)
        fade.setDuration(2000)
        fade.start()
    }

    override fun onPause() {
        super.onPause()
        var fade = ObjectAnimator.ofFloat(view, View.ALPHA, 0.2f, 1.0f)

        fade.end()
    }
}