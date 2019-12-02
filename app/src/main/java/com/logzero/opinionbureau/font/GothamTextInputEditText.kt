package com.logzero.opinionbureau.font

import android.content.Context
import android.graphics.Typeface
import android.util.AttributeSet
import android.widget.AutoCompleteTextView
import androidx.appcompat.widget.AppCompatTextView
import com.google.android.material.textfield.TextInputEditText

class GothamTextInputEditText(context: Context?, attrs: AttributeSet?) : TextInputEditText(context, attrs) {
    init {
        val typeface = Typeface.createFromAsset(getContext().assets,
            "fonts/GothamMedium.ttf")
        if (android.os.Build.VERSION.SDK_INT
            < android.os.Build.VERSION_CODES.HONEYCOMB ||
                android.os.Build.VERSION.SDK_INT >
            android.os.Build.VERSION_CODES.HONEYCOMB_MR2) {
            setTypeface(typeface)
        }
    }
}