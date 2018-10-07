package com.mateogallardo.tableservicemanager

import android.app.Dialog
import android.content.Context
import android.view.View
import android.os.Bundle
import com.mateogallardo.tableservicemanager.views.Table
import kotlinx.android.synthetic.main.table_details_dialog.*

class TableDetailsDialog(context: Context?) : Dialog(context), View.OnClickListener {
    private var table: Table? = null

    constructor(context: Context?, table: Table?) : this(context) {
        this.table = table
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.table_details_dialog)
        okButton.setOnClickListener(this)
        tableNumber.text = table?.tableNumber.toString()
        seatingCapacity.text = table?.seatingCapacity.toString()
        shape.text = table?.tableShape
    }

    override fun onClick(view: View?) {
        when (view?.id) {
            R.id.okButton -> dismiss()
        }
    }
}