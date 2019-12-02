package com.logzero.opinionbureau.splash


import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.view.View
import android.view.WindowManager
import android.view.animation.Animation
import android.view.animation.AnimationUtils
import com.logzero.opinionbureau.selection.SelectionActivity
import com.logzero.opinionbureau.utility.BaseActivity
import kotlinx.android.synthetic.main.activity_splash.*
import com.bumptech.glide.Glide
import com.logzero.opinionbureau.R


class SplashActivity : BaseActivity() {
    lateinit var uptodown: Animation
    lateinit var downtoup: Animation


    val TAG = SplashActivity::class.java.name
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_splash)

        uptodown = AnimationUtils.loadAnimation(this, R.anim.uptodown)
        downtoup = AnimationUtils.loadAnimation(this, R.anim.downtoup)

        Glide.with(this).load(R.drawable.totem2).into(imageView2)
        imageView2.startAnimation(downtoup)
        imageView1.startAnimation(uptodown)

        getWindow().setFlags(
            WindowManager.LayoutParams.FLAG_FULLSCREEN,
            WindowManager.LayoutParams.FLAG_FULLSCREEN


        )

        /* val rotate = RotateAnimation(
             0f,
             720f,
             Animation.RELATIVE_TO_SELF,
             0.5f,
             Animation.RELATIVE_TO_SELF,
             0.5f
         )
         rotate.duration = 3000
         rotate.interpolator = LinearInterpolator()
         imageView2.startAnimation(rotate)*/


        val myThread = object : Thread() {
            override fun run() {
                try {
                    Thread.sleep(4000)
                    val intent = Intent(applicationContext, SelectionActivity::class.java)
                    startActivity(intent)
                    finish()
                } catch (e: InterruptedException) {
                    e.printStackTrace()
                }

            }
        }
        myThread.start()


    }

    companion object {

        const val REQUEST_ID_MULTIPLE_PERMISSIONS = 1
        private const val SPLASH_TIME_OUT = 2000
    }
}