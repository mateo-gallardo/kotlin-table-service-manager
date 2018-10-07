package com.mateogallardo.tableservicemanager

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import com.mateogallardo.tableservicemanager.listeners.TableOnTouchListener
import com.mateogallardo.tableservicemanager.views.Table
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {
    private var tables: Array<Table>? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        tables = arrayOf(table10, table11, table12, table13, table14, table18, table19, table20, table21)
        tables?.forEach {
            it.setOnTouchListener(TableOnTouchListener())
        }
    }
}
