package com.mateogallardo.tableservicemanager

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import com.mateogallardo.tableservicemanager.listeners.OnMenuItemSelectedListener
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        navigation.setOnNavigationItemSelectedListener(OnMenuItemSelectedListener(supportFragmentManager, supportActionBar!!))
    }
}
