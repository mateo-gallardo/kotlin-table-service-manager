package com.mateogallardo.tableservicemanager.listeners

import android.content.Context
import android.view.GestureDetector
import android.view.MotionEvent
import com.mateogallardo.tableservicemanager.TableDetailsDialog
import com.mateogallardo.tableservicemanager.views.Table

class TableTapListener(context: Context, table: Table) : GestureDetector.SimpleOnGestureListener() {
    private var context: Context? = context
    private var table: Table? = null

    init {
        this.context = context
        this.table = table
    }

    override fun onSingleTapConfirmed(e: MotionEvent): Boolean {
        TableDetailsDialog(context, table).show()
        return true
    }
}