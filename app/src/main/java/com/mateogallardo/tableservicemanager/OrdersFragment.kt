package com.mateogallardo.tableservicemanager


import android.os.Bundle
import android.support.v4.app.Fragment
import android.support.v7.widget.LinearLayoutManager
import android.support.v7.widget.OrientationHelper
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.mateogallardo.tableservicemanager.adapters.OrdersAdapter
import com.mateogallardo.tableservicemanager.entities.Order
import com.mateogallardo.tableservicemanager.entities.OrderLine
import kotlinx.android.synthetic.main.fragment_orders.*

class OrdersFragment : Fragment() {
    private val dishes: Array<String> = arrayOf("Milkshake", "Steak", "Fish & Chips", "Burger")
    private val comments: Array<String> = arrayOf("Whole milk", "Well done", "No salt", "No mayo")

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        return inflater.inflate(R.layout.fragment_orders, container, false)
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        orders_list.layoutManager = LinearLayoutManager(context, OrientationHelper.HORIZONTAL, false)
        val orders = Array(10) { createRandomOrder() }
        orders_list.adapter = OrdersAdapter(orders)
    }

    private fun createRandomOrder(): Order {
        val amountOfLines = (1..5).shuffled().first()
        val orderLines = Array(amountOfLines) { createRandomOrderLine() }
        val tableNumber = (1..20).shuffled().first()
        return Order(orderLines, tableNumber)
    }

    private fun createRandomOrderLine(): OrderLine {
        val amount = (1..5).shuffled().first()
        val dish = dishes[(0 until dishes.size).shuffled().first()]
        val comment = comments[(0 until comments.size).shuffled().first()]

        return OrderLine(amount, dish, comment)
    }
}
