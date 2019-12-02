package com.logzero.opinionbureau.country

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.logzero.opinionbureau.R
import android.widget.SimpleAdapter
import android.view.View
import android.view.Window
import android.widget.ListView
import kotlinx.android.synthetic.main.activity_country_dialog_picker.*


class CountryDialogPicker : AppCompatActivity() {

    // Array of strings storing country names
    var countries = arrayOf(
        "India (IN)",
        "Pakistan (PK)",
        "Sri Lanka (LK)",
        "China (CN)",
        "Bangladesh (BD)",
        "Nepal (NP)",
        "Afghanistan (AFG)",
        "North Korea (NK)",
        "South Korea (SK)",
        "Japan (JPN)"
    )

    // Array of integers points to images stored in /res/drawable-ldpi/
    var flags = intArrayOf(
        R.drawable.flag_india,
        R.drawable.flag_pakistan,
        R.drawable.flag_sri_lanka,
        R.drawable.flag_china,
        R.drawable.flag_bangladesh,
        R.drawable.flag_nepal,
        R.drawable.flag_afghanistan,
        R.drawable.flag_north_korea,
        R.drawable.flag_south_korea,
        R.drawable.flag_japan
    )

    // Array of strings to store currencies
    var currency = arrayOf(
        "",
        "",
        "",
        "",
        "",
        "",
        "",
        "",
        "",
        ""
    )
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        requestWindowFeature(Window.FEATURE_NO_TITLE); //before

        setContentView(R.layout.activity_country_dialog_picker)

// Each row in the list stores country name, currency and flag
        val aList = ArrayList<HashMap<String, String>>()

        for (i in 0..9) {
            val hm = HashMap<String, String>()
            hm["txt"] = countries[i]
            hm["cur"] = currency[i]
            hm["flag"] = Integer.toString(flags[i])
            aList.add(hm)
        }

        // Keys used in Hashmap
        val from = arrayOf("flag", "txt", "cur")

        // Ids of views in listview_layout
        val to = intArrayOf(R.id.flag, R.id.txt, R.id.cur)

        // Instantiating an adapter to store each items
        // R.layout.listview_layout defines the layout of each item
        val adapter = SimpleAdapter(baseContext, aList, R.layout.country_list_item, from, to)

        // Getting a reference to listview of main.xml layout file
        val listView = findViewById<View>(R.id.listview) as ListView

        // Setting the adapter to the listView
        listView.setAdapter(adapter)


        back.setOnClickListener { finish() }
    }
}
