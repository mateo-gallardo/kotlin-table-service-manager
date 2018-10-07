package com.mateogallardo.tableservicemanager

import android.os.Bundle
import android.support.v4.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.mateogallardo.tableservicemanager.listeners.TableOnTouchListener
import com.mateogallardo.tableservicemanager.views.Table
import kotlinx.android.synthetic.main.fragment_tables.*

class TablesFragment : Fragment() {
    private var tables: Array<Table>? = null

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        return inflater.inflate(R.layout.fragment_tables, container, false)
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        tables = arrayOf(table10, table11, table12, table13, table14, table18, table19, table20, table21)
        tables?.forEach {
            it.setOnTouchListener(TableOnTouchListener(context!!, it))
        }
    }
}
