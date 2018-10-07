package com.mateogallardo.tableservicemanager.listeners

import android.support.design.widget.BottomNavigationView
import android.support.v4.app.FragmentManager
import android.support.v7.app.ActionBar
import android.view.MenuItem
import com.mateogallardo.tableservicemanager.OrdersFragment
import com.mateogallardo.tableservicemanager.R
import com.mateogallardo.tableservicemanager.TablesFragment

private const val TABLES_TITLE = "Table distribution"
private const val ORDERS_TITLE = "Orders placed"

class OnMenuItemSelectedListener(fragmentManager: FragmentManager, actionBar: ActionBar) : BottomNavigationView.OnNavigationItemSelectedListener {
    private var tablesFragment: TablesFragment = TablesFragment()
    private var ordersFragment: OrdersFragment = OrdersFragment()
    private var supportFragmentManager: FragmentManager = fragmentManager
    private var supportActionBar : ActionBar = actionBar

    init {
        supportFragmentManager.beginTransaction().add(R.id.content, ordersFragment).commit()
        supportFragmentManager.beginTransaction().hide(ordersFragment).commit()
        supportFragmentManager.beginTransaction().add(R.id.content, tablesFragment).commit()
        supportFragmentManager.beginTransaction().show(tablesFragment).commit()
        supportActionBar.title = TABLES_TITLE
    }

    override fun onNavigationItemSelected(item: MenuItem): Boolean {
        when (item.itemId) {
            R.id.navigation_tables -> {
                supportFragmentManager.beginTransaction().hide(ordersFragment).commit()
                supportFragmentManager.beginTransaction().show(tablesFragment).commit()
                supportActionBar.title = TABLES_TITLE
                return true
            }
            R.id.navigation_orders -> {
                supportFragmentManager.beginTransaction().hide(tablesFragment).commit()
                supportFragmentManager.beginTransaction().show(ordersFragment).commit()
                supportActionBar.title = ORDERS_TITLE
                return true
            }
        }

        return false
    }
}