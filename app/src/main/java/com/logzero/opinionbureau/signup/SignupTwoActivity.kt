package com.logzero.opinionbureau.signup

import android.app.DatePickerDialog
import android.content.Intent
import android.graphics.Typeface
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.AdapterView
import android.widget.ArrayAdapter
import android.widget.Toast
import com.logzero.opinionbureau.R
import kotlinx.android.synthetic.main.activity_gdpr.*
import kotlinx.android.synthetic.main.activity_selection.culture
import kotlinx.android.synthetic.main.activity_signup_two.*
import kotlinx.android.synthetic.main.activity_signup_two.next
import me.srodrigo.androidhintspinner.HintAdapter
import me.srodrigo.androidhintspinner.HintSpinner
import java.text.SimpleDateFormat
import java.util.*




class SignupTwoActivity : AppCompatActivity(), AdapterView.OnItemSelectedListener {
    val myCalendar = Calendar.getInstance()!!

    val c = Calendar.getInstance()!!
    val year = c.get(Calendar.YEAR)
    val month = c.get(Calendar.MONTH)
    val day = c.get(Calendar.DAY_OF_MONTH)
    var list_of_items = arrayOf("Gender*","Male","Female")
    private val stockAvaillist = ArrayList<String>()
    private var stock_adapter: HintAdapter<String>? = null


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_signup_two)

        culture!!.setOnItemSelectedListener(this)
       // genderSpinner()

        val font = Typeface.createFromAsset(assets, "fonts/SegoeUI_gdi.ttf")
       // gender.setLayerType(font)
        next.setOnClickListener {


            if (dob.text.toString().length == 0) {
                Toast.makeText(this@SignupTwoActivity, "Please select DOB", Toast.LENGTH_SHORT)
                    .show()
            } else if (gender.getSelectedItem().toString().equals("Gender*")) {
                Toast.makeText(this@SignupTwoActivity, "Please select gender", Toast.LENGTH_SHORT)
                    .show()

            } else {
                val i = Intent(this@SignupTwoActivity, SignupthreeActivity::class.java)
                startActivity(i)
            }
        }

        val myCalendar = Calendar.getInstance()

        val date = DatePickerDialog.OnDateSetListener { view, year, monthOfYear, dayOfMonth ->
            // TODO Auto-generated method stub
            myCalendar.set(Calendar.YEAR, year)
            myCalendar.set(Calendar.MONTH, monthOfYear)
            myCalendar.set(Calendar.DAY_OF_MONTH, dayOfMonth)
            updateLabel()
        }

        dob.setOnClickListener {


            // TODO Auto-generated method stub
            DatePickerDialog(
                this@SignupTwoActivity, date, myCalendar
                    .get(Calendar.YEAR), myCalendar.get(Calendar.MONTH),
                myCalendar.get(Calendar.DAY_OF_MONTH)
            ).show()

        }

        val adapter = ArrayAdapter<String>(
            this,
            R.layout.spin_layout, list_of_items
        )
        adapter.setDropDownViewResource(R.layout.spin_layout)
        gender.setAdapter(adapter)
    }

    override fun onItemSelected(parent: AdapterView<*>?, view: View?, position: Int, id: Long) {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun onNothingSelected(parent: AdapterView<*>?) {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    private fun updateLabel() {
        val myFormat = "dd/MMM/yyyy" //In which you need put here
        val sdf = SimpleDateFormat(myFormat, Locale.US)

        dob.setText(sdf.format(myCalendar.getTime()))
    }

    fun genderSpinner() {
        stockAvaillist.add("Male")
        stockAvaillist.add("Female")

        gender.setAdapter(
            ArrayAdapter(
                this,
                R.layout.spin_layout,
                stockAvaillist
            )
        )
        stock_adapter = HintAdapter<String>(this, "Gender*", stockAvaillist)
        val stockSpinner = HintSpinner(
            gender,
            // Default layout - You don't need to pass in any layout id, just your hint text and
            // your list data
            stock_adapter,
            HintSpinner.Callback { position, itemAtPosition ->
                // Here you handle the on item selected event (this skips the hint selected event)
                //  Log.e(TAG, "stock select "+String.valueOf(position)+" "+ stockAvaillist.get(position));
                if (stockAvaillist[position].equals(
                        "Male",
                        ignoreCase = true
                    )
                ) {
                    //stock_avail_flag = "1"
                } else if (stockAvaillist[position].equals(
                        "Female",
                        ignoreCase = true
                    )
                ) {
                }
            })
        stockSpinner.init()
    }
}
