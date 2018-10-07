package com.mateogallardo.tableservicemanager.listeners

import android.content.Context
import android.view.GestureDetector
import android.view.MotionEvent
import android.view.View
import com.mateogallardo.tableservicemanager.views.Table

class TableOnTouchListener : View.OnTouchListener {
    private var headerHeight: Int = 170
    private var tapListener: GestureDetector? = null

    constructor(context: Context, table: Table) {
        tapListener = GestureDetector(context, TableTapListener(context, table))
    }

    override fun onTouch(view: View, event: MotionEvent): Boolean {
        tapListener?.onTouchEvent(event)

        if (event.action == MotionEvent.ACTION_MOVE) {
            view.y = event.rawY - view.height / 2 - headerHeight
            view.x = event.rawX - view.width / 2
        }

        return true
    }
}