package com.mateogallardo.tableservicemanager.views

import android.content.Context
import android.util.AttributeSet
import android.widget.LinearLayout
import com.mateogallardo.tableservicemanager.R
import kotlinx.android.synthetic.main.rectangular_table.view.*
import java.util.*

abstract class Table(context: Context, attrs: AttributeSet?) : LinearLayout(context, attrs) {
    var tableNumber: Int = 0
    var seatingCapacity: Int = 0
    var tableShape: String? = null

    init {
        setSeatingCapacity()
    }

    fun setTableNumber(attrs: AttributeSet?) {
        attrs?.let {
            val typedArray = context.obtainStyledAttributes(it, R.styleable.Table, 0, 0)
            tableNumber = typedArray.getInt(R.styleable.Table_tableNumber, 0)

            textView.text = tableNumber.toString()
            typedArray.recycle()
        }
    }

    private fun setSeatingCapacity() {
        seatingCapacity = (2..6).shuffled().first()
    }
}