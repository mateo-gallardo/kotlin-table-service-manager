package com.mateogallardo.tableservicemanager.listeners

import android.support.design.widget.BottomNavigationView
import android.support.v4.app.FragmentManager
import android.view.MenuItem
import com.mateogallardo.tableservicemanager.OrdersFragment
import com.mateogallardo.tableservicemanager.R
import com.mateogallardo.tableservicemanager.TablesFragment

class OnMenuItemSelectedListener(fragmentManager: FragmentManager) : BottomNavigationView.OnNavigationItemSelectedListener {
    private var tablesFragment: TablesFragment = TablesFragment()
    private var ordersFragment: OrdersFragment = OrdersFragment()
    private var supportFragmentManager: FragmentManager = fragmentManager

    init {
        supportFragmentManager.beginTransaction().add(R.id.content, ordersFragment).commit()
        supportFragmentManager.beginTransaction().hide(ordersFragment).commit()
        supportFragmentManager.beginTransaction().add(R.id.content, tablesFragment).commit()
        supportFragmentManager.beginTransaction().show(tablesFragment).commit()
    }

    override fun onNavigationItemSelected(item: MenuItem): Boolean {
        when (item.itemId) {
            R.id.navigation_tables -> {
                supportFragmentManager.beginTransaction().hide(ordersFragment).commit()
                supportFragmentManager.beginTransaction().show(tablesFragment).commit()
                return true
            }
            R.id.navigation_orders -> {
                supportFragmentManager.beginTransaction().hide(tablesFragment).commit()
                supportFragmentManager.beginTransaction().show(ordersFragment).commit()
                return true
            }
        }

        return false
    }
}