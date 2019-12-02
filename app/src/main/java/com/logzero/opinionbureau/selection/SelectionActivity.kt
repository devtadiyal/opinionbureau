package com.logzero.opinionbureau.selection

import android.Manifest
import android.app.PendingIntent
import android.content.Context
import android.content.DialogInterface
import android.content.Intent
import android.content.pm.PackageManager
import android.net.Uri
import android.os.Bundle
import android.telephony.TelephonyManager
import android.util.Log
import android.view.View
import android.widget.AdapterView
import android.widget.ArrayAdapter
import androidx.appcompat.app.AlertDialog
import androidx.browser.customtabs.CustomTabsIntent
import androidx.core.app.ActivityCompat
import androidx.core.content.ContextCompat
import com.logzero.opinionbureau.R
import com.logzero.opinionbureau.api_content.WebApiKey
import com.logzero.opinionbureau.culture.CultureImp
import com.logzero.opinionbureau.culture.CulturePresenter
import com.logzero.opinionbureau.login.LoginActivity
import com.logzero.opinionbureau.model.model.country.CountryModel
import com.logzero.opinionbureau.signup.GDPRActivity
import com.logzero.opinionbureau.splash.SplashActivity.Companion.REQUEST_ID_MULTIPLE_PERMISSIONS
import com.logzero.opinionbureau.utility.BaseActivity
import com.logzero.opinionbureau.webview.CustomTabHelper
import com.logzero.opinionbureau.webview.WebViewActivity
import kotlinx.android.synthetic.main.activity_selection.*
import kotlin.collections.ArrayList
import kotlin.collections.HashMap


class SelectionActivity : BaseActivity(), AdapterView.OnItemSelectedListener,
    CulturePresenter.View<View> {

    private var customTabHelper: CustomTabHelper = CustomTabHelper()
    lateinit var cultureimp: CultureImp
    val languagelist = arrayListOf<String>()


    companion object {
        private const val Terms = "https://opinionbureau.com/T&C"
        private const val Privacy = "https://opinionbureau.com/privacyPolicy"
    }

    val TAG = SelectionActivity::class.java.name

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_selection)



        culture!!.setOnItemSelectedListener(this)
        cultureimp = CultureImp(this)
        val tel = getSystemService(Context.TELEPHONY_SERVICE) as TelephonyManager

        cultureimp.getCountryCode(
            WebApiKey.KEY_CONTENTTYPEVALUE,
            tel.networkCountryIso.toUpperCase()
        )
        // Create an ArrayAdapter using a simple spinner layout and languages array


        weare.setOnClickListener {
            showAlertDialog("", "")
        }
        signup.setOnClickListener {
            val i = Intent(this@SelectionActivity, GDPRActivity::class.java)
            startActivity(i)
        }

        login.setOnClickListener {
            val i = Intent(this@SelectionActivity, LoginActivity::class.java)
            startActivity(i)
        }


        terms.setOnClickListener {
            openTermsAndPrivacy(Terms)
        }

        privacy.setOnClickListener {
            openTermsAndPrivacy(Privacy)
        }

        //SuitCase()
        checkAndRequestPermissions()



    }


    fun openTermsAndPrivacy(url: String) {
        val builder = CustomTabsIntent.Builder()
        builder.enableUrlBarHiding()

        // modify toolbar color
        builder.setToolbarColor(ContextCompat.getColor(this@SelectionActivity, R.color.blue))

        // add share button to overflow menu
        builder.addDefaultShareMenuItem()

        val anotherCustomTab = CustomTabsIntent.Builder().build()

        val requestCode = 100
        val intent = anotherCustomTab.intent
        intent.setData(Uri.parse(url))

        val pendingIntent = PendingIntent.getActivity(
            this,
            requestCode,
            intent,
            PendingIntent.FLAG_UPDATE_CURRENT
        )

        // add menu item to oveflow
        builder.addMenuItem("Sample item", pendingIntent)

        // menu item icon
        // val bitmap = BitmapFactory.decodeResource(getResources(), R.mipmap.ic_launcher)
        // builder.setActionButton(bitmap, "Android", pendingIntent, true)

        // modify back button icon
        // builder.setCloseButtonIcon(bitmap)

        // show website title
        builder.setShowTitle(true)

        // animation for enter and exit of tab
        builder.setStartAnimations(this, android.R.anim.fade_in, android.R.anim.fade_out)
        builder.setExitAnimations(this, android.R.anim.fade_in, android.R.anim.fade_out)

        val customTabsIntent = builder.build()

        // check is chrom available
        val packageName = customTabHelper.getPackageNameToUse(this, url)

        if (packageName == null) {
            // if chrome not available open in web view
            val intentOpenUri = Intent(this, WebViewActivity::class.java)
            intentOpenUri.putExtra(WebViewActivity.EXTRA_URL, Uri.parse(url).toString())
            startActivity(intentOpenUri)
        } else {
            customTabsIntent.intent.setPackage(packageName)
            customTabsIntent.launchUrl(this, Uri.parse(url))
        }
    }


    private fun checkAndRequestPermissions(): Boolean {
        val camerapermission = ContextCompat.checkSelfPermission(this, Manifest.permission.CAMERA)
        val writepermission =
            ContextCompat.checkSelfPermission(this, Manifest.permission.WRITE_EXTERNAL_STORAGE)
        val permissionLocation =
            ContextCompat.checkSelfPermission(this, Manifest.permission.ACCESS_FINE_LOCATION)
        val permissionRecordAudio =
            ContextCompat.checkSelfPermission(this, Manifest.permission.RECORD_AUDIO)


        val listPermissionsNeeded = ArrayList<String>()

        if (camerapermission != PackageManager.PERMISSION_GRANTED) {
            listPermissionsNeeded.add(Manifest.permission.CAMERA)
        }
        if (writepermission != PackageManager.PERMISSION_GRANTED) {
            listPermissionsNeeded.add(Manifest.permission.WRITE_EXTERNAL_STORAGE)
        }
        if (permissionLocation != PackageManager.PERMISSION_GRANTED) {
            listPermissionsNeeded.add(Manifest.permission.ACCESS_FINE_LOCATION)
        }
        if (permissionRecordAudio != PackageManager.PERMISSION_GRANTED) {
            listPermissionsNeeded.add(Manifest.permission.RECORD_AUDIO)
        }
        if (!listPermissionsNeeded.isEmpty()) {
            ActivityCompat.requestPermissions(
                this,
                listPermissionsNeeded.toTypedArray(),
                REQUEST_ID_MULTIPLE_PERMISSIONS
            )
            return false
        }
        return true
    }


    override fun onRequestPermissionsResult(
        requestCode: Int,
        permissions: Array<String>, grantResults: IntArray
    ) {
        Log.d(TAG, "Permission callback called-------")
        when (requestCode) {
            REQUEST_ID_MULTIPLE_PERMISSIONS -> {

                val perms = HashMap<String, Int>()
                // Initialize the map with both permissions
                perms[Manifest.permission.CAMERA] = PackageManager.PERMISSION_GRANTED
                perms[Manifest.permission.WRITE_EXTERNAL_STORAGE] =
                    PackageManager.PERMISSION_GRANTED
                perms[Manifest.permission.ACCESS_FINE_LOCATION] = PackageManager.PERMISSION_GRANTED
                perms[Manifest.permission.RECORD_AUDIO] = PackageManager.PERMISSION_GRANTED
                // Fill with actual results from user
                if (grantResults.size > 0) {
                    for (i in permissions.indices)
                        perms[permissions[i]] = grantResults[i]
                    // Check for both permissions
                    if (perms[Manifest.permission.CAMERA] == PackageManager.PERMISSION_GRANTED
                        && perms[Manifest.permission.WRITE_EXTERNAL_STORAGE] == PackageManager.PERMISSION_GRANTED
                        && perms[Manifest.permission.ACCESS_FINE_LOCATION] == PackageManager.PERMISSION_GRANTED
                        && perms[Manifest.permission.RECORD_AUDIO] == PackageManager.PERMISSION_GRANTED
                    ) {
                        Log.d(TAG, "sms & location services permission granted")
                        // process the normal flow
                        /* val i = Intent(this@SelectionActivity, LoginActivity::class.java)
                         startActivity(i)
                         finish()*/
                        //else any one or both the permissions are not granted
                    } else {
                        Log.d(TAG, "Some permissions are not granted ask again ")
                        //permission is denied (this is the first time, when "never ask again" is not checked) so ask again explaining the usage of permission
                        //                        // shouldShowRequestPermissionRationale will return true
                        //show the dialog or snackbar saying its necessary and try again otherwise proceed with setup.
                        if (ActivityCompat.shouldShowRequestPermissionRationale(
                                this,
                                Manifest.permission.CAMERA
                            )
                            || ActivityCompat.shouldShowRequestPermissionRationale(
                                this,
                                Manifest.permission.WRITE_EXTERNAL_STORAGE
                            )
                            || ActivityCompat.shouldShowRequestPermissionRationale(
                                this,
                                Manifest.permission.ACCESS_FINE_LOCATION
                            )
                            || ActivityCompat.shouldShowRequestPermissionRationale(
                                this,
                                Manifest.permission.RECORD_AUDIO
                            )
                        ) {
                            showDialogOK("Service Permissions are required for this app",
                                DialogInterface.OnClickListener { dialog, which ->
                                    when (which) {
                                        DialogInterface.BUTTON_POSITIVE -> checkAndRequestPermissions()
                                        DialogInterface.BUTTON_NEGATIVE -> funDO()
                                        // proceed with logic by disabling the related features or quit the app.
                                    }
                                })
                        } else {
                            explain("You need to give some mandatory permissions to continue. Do you want to go to app settings?")
                            //                            //proceed with logic by disabling the related features or quit the app.
                        }//permission is denied (and never ask again is  checked)
                        //shouldShowRequestPermissionRationale will return false
                    }
                }
            }
        }

    }

    fun funDO() {

    }

    private fun showDialogOK(message: String, okListener: DialogInterface.OnClickListener) {
        AlertDialog.Builder(this)
            .setMessage(message)
            .setPositiveButton("OK", okListener)
            .setNegativeButton("Cancel", okListener)
            .create()
            .show()
    }

    private fun explain(msg: String) {
        val dialog = AlertDialog.Builder(this)
        dialog.setMessage(msg)
            .setPositiveButton("Yes") { paramDialogInterface, paramInt ->
                //  permissionsclass.requestPermission(type,code);
                startActivity(
                    Intent(
                        android.provider.Settings.ACTION_APPLICATION_DETAILS_SETTINGS,
                        Uri.parse("package:com.example.parsaniahardik.kotlin_marshmallowpermission")
                    )
                )
            }
            .setNegativeButton("Cancel") { paramDialogInterface, paramInt -> finish() }
        dialog.show()
    }


    override fun onItemSelected(arg0: AdapterView<*>, arg1: View, position: Int, id: Long) {
        // use position to know the selected item
    }

    override fun onNothingSelected(arg0: AdapterView<*>) {

    }

    override fun showError(response: String?) {
        //TODO: implement later
        println("ERROR " + response)
    }

    override fun showLoadingLayout() {
        //TODO: implement later

    }

    override fun hideLoadingLayout() {
        //TODO: implement later
    }

    override fun countryResponse(response: CountryModel?) {
        //TODO: implement later
        if (response != null) {
            //println("RESPONSE "+response.message)
            for (element in response.data) {
                //println(element.country_code)
                //println(element.country_name)
                //println(element.country_flag)

                for (element in element.languages) {
                    //println(element.language)
                    //println(element.lang_id)
                    languagelist.add(element.language.toString())

                }
            }
        }
        val aa = ArrayAdapter(
            this,
            R.layout.spinner_dropdown_item,
            languagelist
        )
        // Set layout to use when the list of choices appear
        aa.setDropDownViewResource(R.layout.spinner_dropdown_item)
        // Set Adapter to Spinner
        culture!!.setAdapter(aa)
    }


}