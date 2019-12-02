package com.logzero.opinionbureau.signup

import android.content.Intent
import android.net.Uri
import android.os.Bundle
import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import com.google.android.gms.auth.api.signin.GoogleSignIn
import com.google.android.gms.auth.api.signin.GoogleSignInAccount
import com.google.android.gms.auth.api.signin.GoogleSignInClient
import com.google.android.gms.auth.api.signin.GoogleSignInOptions
import com.google.android.gms.common.api.ApiException
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.GoogleAuthProvider
import com.logzero.opinionbureau.R
import kotlinx.android.synthetic.main.activity_signup_option.*


class SignupOptionActivity : AppCompatActivity(){
    private lateinit var auth: FirebaseAuth
    private var RC_SIGN_IN: Int = 1
    private lateinit var mGoogleSignInClient:GoogleSignInClient

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_signup_option)


        auth = FirebaseAuth.getInstance()

        email.setOnClickListener {
            val i = Intent(this@SignupOptionActivity, SignupOneActivity::class.java)
            startActivity(i)
        }

        ll.setOnClickListener {
            signIn()
        }

        // Configure Google Sign In
        val gso = GoogleSignInOptions.Builder(GoogleSignInOptions.DEFAULT_SIGN_IN)
            .requestIdToken(getString(R.string.default_web_client_id))
            .requestEmail()
            .build()
        mGoogleSignInClient = GoogleSignIn.getClient(this, gso);


    }

    override fun onResume() {
        super.onResume()
    }

    private fun signIn() {
        //FirebaseAuth.getInstance().signOut()

        val signInIntent = mGoogleSignInClient.signInIntent
        startActivityForResult(signInIntent, RC_SIGN_IN)
        print("DEV 7")

    }
    public override fun onStart() {
        super.onStart()
        // Check if user is signed in (non-null) and update UI accordingly.
        val currentUser = auth.currentUser
        if (currentUser != null) {
            print(currentUser.displayName)
        }
       // updateUI(currentUser)
    }

    private fun firebaseAuthWithGoogle(acct: GoogleSignInAccount) {
        Log.d("", "firebaseAuthWithGoogle:" + acct.id!!)
        print("DEV 6")

        val credential = GoogleAuthProvider.getCredential(acct.idToken, null)
        auth.signInWithCredential(credential)
            .addOnCompleteListener(this) { task ->
                if (task.isSuccessful) {
                    // Sign in success, update UI with the signed-in user's information
                    Log.d("", "signInWithCredential:success")
                    val user = auth.currentUser
                    if (user != null) {
                        print("USER "+user.displayName)
                    }
                    //updateUI(user)
                } else {
                    print("DEV 5")

                    // If sign in fails, display a message to the user.
                    Log.w("", "signInWithCredential:failure", task.exception)
                   // Snackbar.make(main_layout, "Authentication Failed.", Snackbar.LENGTH_SHORT).show()
                    //updateUI(null)
                }

                // ...
            }
    }

    public override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)
        print("DEV 3")

        // Result returned from launching the Intent from GoogleSignInApi.getSignInIntent(...);
        if (requestCode == RC_SIGN_IN) {
            val task = GoogleSignIn.getSignedInAccountFromIntent(data)
            print("DEV 1")

            try {
                print("DEV 2")
                // Google Sign In was successful, authenticate with Firebase
                val account = task.getResult(ApiException::class.java)
                firebaseAuthWithGoogle(account!!)
            } catch (e: ApiException) {
                // Google Sign In failed, update UI appropriately
                Log.w("", "Google sign in failed", e)
                print("DEV 4")

                // ...
            }
        }
    }
}
