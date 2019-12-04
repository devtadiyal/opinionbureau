package com.logzero.opinionbureau.signup

import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.google.android.gms.auth.api.Auth
import com.google.android.gms.auth.api.signin.*
import com.google.android.gms.common.ConnectionResult
import com.google.android.gms.common.api.GoogleApiClient
import com.google.firebase.auth.FirebaseAuth
import com.logzero.opinionbureau.R
import com.logzero.opinionbureau.utility.Preference
import kotlinx.android.synthetic.main.activity_signup_option.*


class SignupOptionActivity : AppCompatActivity(), GoogleApiClient.OnConnectionFailedListener {
    private lateinit var auth: FirebaseAuth
    private var RC_SIGN_IN: Int = 1
    private var mGoogleApiClient: GoogleApiClient? = null

    override fun onConnectionFailed(connectionResult: ConnectionResult) {
        Log.d("bett", "onConnectionFailed:" + connectionResult);
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(
            R.layout.activity_signup_option
        )

        email.setOnClickListener {
            val i = Intent(this@SignupOptionActivity, SignupOneActivity::class.java)
            startActivity(i)
        }

        ll.setOnClickListener {
            val signInIntent = Auth.GoogleSignInApi.getSignInIntent(mGoogleApiClient)
            startActivityForResult(signInIntent, RC_SIGN_IN)
        }

        val gso = GoogleSignInOptions.Builder(GoogleSignInOptions.DEFAULT_SIGN_IN)
            .requestEmail()
            .build()

        mGoogleApiClient = GoogleApiClient.Builder(this)
            .enableAutoManage(this /* FragmentActivity */, this /* OnConnectionFailedListener */)
            .addApi(Auth.GOOGLE_SIGN_IN_API, gso)
            .build()

    }


    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)

        if (requestCode == RC_SIGN_IN) {
            val result = Auth.GoogleSignInApi.getSignInResultFromIntent(data)
            handleSignInResult(result)
        }
    }

    private fun handleSignInResult(result: GoogleSignInResult) {
        if (result.isSuccess) {
            println("DEV " + result.signInAccount?.displayName)
            println("DEV " + result.signInAccount?.id)
            println("DEV " + result.signInAccount?.account)
            println("DEV " + result.signInAccount?.familyName)

            Auth.GoogleSignInApi.signOut(mGoogleApiClient).setResultCallback {
            }
            val i = Intent(this@SignupOptionActivity, SignupOneActivity::class.java)
            i.putExtra("name", result.signInAccount?.displayName)
            i.putExtra("email", result.signInAccount?.email)
            startActivity(i)

        } else {
            sequenceOf(Toast.makeText(this, result.status.toString(), Toast.LENGTH_SHORT))
        }
    }

    override fun onResume() {
        super.onResume()

        login.setText(Preference.getInstance(this).getFromPreference("continuewith"))
        or.setText(Preference.getInstance(this).getFromPreference("or"))
        email.setText(Preference.getInstance(this).getFromPreference("email"))
    }
}
