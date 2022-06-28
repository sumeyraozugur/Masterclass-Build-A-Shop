package com.sum.ecommerce.utils


import android.content.Context
import android.graphics.Typeface
import android.util.AttributeSet
import androidx.appcompat.widget.AppCompatTextView

// TODO Step: Create a custom class which inherits the AppCompactTextView. In this class we will apply the custom font to the TextView.

class NormalTextView(context: Context, attrs: AttributeSet) : AppCompatTextView(context, attrs) {

    init {
        // Call the function to apply the font to the components.
        applyFont()
    }

    private fun applyFont() {

        // This is used to get the file from the assets folder and set it to the title textView.
        val typeface: Typeface =
            Typeface.createFromAsset(context.assets, "Montserrat-Regular.ttf")
        setTypeface(typeface)
    }
}
