package com.logzero.opinionbureau.utility


import android.app.Activity
import android.os.Bundle
import androidx.appcompat.app.AlertDialog
import androidx.appcompat.app.AppCompatActivity
import com.airbnb.lottie.LottieAnimationView
import com.logzero.opinionbureau.R
import kotlinx.android.synthetic.main.alertdialoglogout.view.*
import android.content.Intent
import android.view.*
import android.view.inputmethod.InputMethodManager
import com.logzero.opinionbureau.MainActivity
import com.logzero.opinionbureau.country.CountryDialogPicker
import kotlinx.android.synthetic.main.alertdialogerror.view.*
import kotlinx.android.synthetic.main.alertdialoglogout.*


open class BaseActivity : AppCompatActivity() {
    var progressBar: LottieAnimationView? = null
    var dialogBuilder: AlertDialog.Builder? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)


    }


    fun showProgressDialog() {
// Get the LayoutInflater from Context
        val layoutInflater: LayoutInflater = LayoutInflater.from(applicationContext)

        // Inflate the layout using LayoutInflater
        val view: View = layoutInflater.inflate(
            R.layout.progressbar, // Custom view/ layout
            linear, // Root layout to attach the view
            true // Attach with root layout or not
        )
        // Find the text view from custom layout
        val label = view.findViewById<LottieAnimationView>(R.id.progress)

    }

    fun dismissProgressDialog() {
        progressBar?.visibility = View.GONE

    }

    fun showAlertDialog(title: String, msg: String) {
        val mDialogView = LayoutInflater.from(this).inflate(R.layout.alertdialogerror, null)
        //AlertDialogBuilder
        val mBuilder = AlertDialog.Builder(this)
            .setView(mDialogView)
            .setTitle(title)
            .setMessage(msg)


        //show dialog
        val mAlertDialog = mBuilder.show()
        //Create custom message


        mDialogView.dialogCancelBtn.setOnClickListener {
            //dismiss dialog
            val i = Intent(this@BaseActivity, CountryDialogPicker::class.java)
            startActivity(i)
            mAlertDialog.dismiss()

        }
    }


    /**
     * method to hide keyboard
     */
    fun hideKeyboard(activity: Activity) {
        val imm = activity.getSystemService(Activity.INPUT_METHOD_SERVICE) as InputMethodManager
        //Find the currently focused view, so we can grab the correct window token from it.
        var view = activity.currentFocus
        //If no view currently has focus, create a new one, just so we can grab a window token from it
        if (view == null) {
            view = View(activity)
        }
        imm?.hideSoftInputFromWindow(view.windowToken, 0)
    }


    fun NetworkError() {
        val layoutInflater: LayoutInflater = LayoutInflater.from(applicationContext)

        // Inflate the layout using LayoutInflater
        val view: View = layoutInflater.inflate(
            R.layout.networkerror, // Custom view/ layout
            linear, // Root layout to attach the view
            true // Attach with root layout or not
        )


    }

    fun logout() {
        val mDialogView = LayoutInflater.from(this).inflate(R.layout.alertdialoglogout, null)
        //AlertDialogBuilder
        val mBuilder = AlertDialog.Builder(this)
            .setView(mDialogView)
        //  .setTitle("Login Form")
        //show dialog
        val mAlertDialog = mBuilder.show()
        //login button click of custom layout
        mDialogView.yes.setOnClickListener {
            //dismiss dialog
            mAlertDialog.dismiss()
            //get text from EditTexts of custom layout
            val intent = Intent(applicationContext, MainActivity::class.java)
            intent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP)
            startActivity(intent)
        }
        //cancel button click of custom layout
        mDialogView.no.setOnClickListener {
            //dismiss dialog
            mAlertDialog.dismiss()
        }

    }
}