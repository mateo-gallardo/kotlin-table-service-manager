package com.mateogallardo.tableservicemanager.views

import android.content.Context
import android.util.AttributeSet
import android.view.LayoutInflater
import com.mateogallardo.tableservicemanager.R

class SquareTable(context: Context, attrs: AttributeSet?) : Table(context, attrs) {

    init {
        LayoutInflater.from(context).inflate(R.layout.square_table, this, true)
        setTableNumber(attrs)
    }
}