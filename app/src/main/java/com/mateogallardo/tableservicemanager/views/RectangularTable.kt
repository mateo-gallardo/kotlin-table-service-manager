package com.mateogallardo.tableservicemanager.views

import android.content.Context
import android.util.AttributeSet
import android.view.LayoutInflater
import android.widget.LinearLayout
import com.mateogallardo.tableservicemanager.R
import kotlinx.android.synthetic.main.rectangular_table.view.*

class RectangularTable(context: Context, attrs: AttributeSet?) : LinearLayout(context, attrs) {

    init {
        LayoutInflater.from(context).inflate(R.layout.rectangular_table, this, true)

        attrs?.let {
            val typedArray = context.obtainStyledAttributes(it, R.styleable.RectangularTable, 0, 0)
            val tableNumber = typedArray.getInt(R.styleable.RectangularTable_tableNumber, 0)

            textView.text = tableNumber.toString()
            typedArray.recycle()
        }
    }

}