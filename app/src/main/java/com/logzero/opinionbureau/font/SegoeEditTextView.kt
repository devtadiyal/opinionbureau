package com.logzero.opinionbureau.font

import android.content.Context
import android.graphics.Typeface
import android.util.AttributeSet
import androidx.appcompat.widget.AppCompatEditText
import androidx.appcompat.widget.AppCompatTextView

class SegoeEditTextView(context: Context?, attrs: AttributeSet?) : AppCompatEditText(context, attrs) {
    init {
        val typeface = Typeface.createFromAsset(getContext().assets,
            "fonts/SegoeUI_gdi.ttf")
        if (android.os.Build.VERSION.SDK_INT
            < android.os.Build.VERSION_CODES.HONEYCOMB ||
                android.os.Build.VERSION.SDK_INT >
            android.os.Build.VERSION_CODES.HONEYCOMB_MR2) {
            setTypeface(typeface)
        }
    }
}