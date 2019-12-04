package com.logzero.opinionbureau.signup

import android.animation.ObjectAnimator
import android.content.Intent
import android.graphics.Typeface
import android.os.Bundle
import android.text.Html
import android.view.View
import android.widget.RadioButton
import android.widget.RadioGroup
import android.widget.TextView
import android.widget.Toast
import com.logzero.opinionbureau.R
import com.logzero.opinionbureau.font.SegoeUITextView
import com.logzero.opinionbureau.utility.BaseActivity
import com.logzero.opinionbureau.utility.Preference
import kotlinx.android.synthetic.main.activity_gdpr.*


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
                Toast.makeText(this@GDPRActivity, Preference.getInstance(this).getFromPreference("val_agree_on_gdpr"), Toast.LENGTH_SHORT).show()
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
        fade(header)
        //header.setText(Preference.getInstance(this).getFromPreference(""))
        //  gdpr.setText(Preference.getInstance(this).getFromPreference(""))
        //  bottom.setText(Preference.getInstance(this).getFromPreference(""))
        val text = Preference.getInstance(this).getFromPreference("gdprcontent")
        header.setText(Html.fromHtml(text))
        radia_id1.setText(Preference.getInstance(this).getFromPreference("iagree"))
        radia_id2.setText(Preference.getInstance(this).getFromPreference("idontagree"))
        buttonnext.setText(Preference.getInstance(this).getFromPreference("next"))

    }

    fun fade(view: SegoeUITextView) {
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
