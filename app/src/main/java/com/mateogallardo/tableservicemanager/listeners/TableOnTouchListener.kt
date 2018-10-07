package com.mateogallardo.tableservicemanager.listeners

import android.view.MotionEvent
import android.view.View

class TableOnTouchListener : View.OnTouchListener {
    private var headerHeight: Int = 170

    override fun onTouch(view: View, event: MotionEvent): Boolean {
        if (event.action == MotionEvent.ACTION_MOVE) {
            view.y = event.rawY - view.height / 2 - headerHeight
            view.x = event.rawX - view.width / 2
        }

        return true
    }
}