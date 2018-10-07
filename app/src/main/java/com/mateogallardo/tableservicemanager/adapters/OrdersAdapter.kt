package com.mateogallardo.tableservicemanager.adapters

import android.content.Context
import android.graphics.Color
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.LinearLayout
import android.widget.TextView
import com.mateogallardo.tableservicemanager.R
import com.mateogallardo.tableservicemanager.entities.Order
import com.mateogallardo.tableservicemanager.entities.OrderLine

class OrdersAdapter(placedOrders: Array<Order>) : RecyclerView.Adapter<OrdersAdapter.ViewHolder>() {
    private val orders: Array<Order> = placedOrders
    private var context: Context? = null

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        context = parent.context
        val view: View = LayoutInflater.from(context).inflate(R.layout.order, parent, false)
        return ViewHolder(view)
    }

    override fun getItemCount(): Int {
        return orders.size
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.tableNumber.text = "Table #${orders[position].tableNumber}"
        holder.orderLines.removeAllViews()
        orders[position].lines.forEach {
            addDish(it, holder.orderLines)
        }
    }

    private fun addDish(orderLine: OrderLine, linearLayout: LinearLayout) {
        val dishLayoutParams = LinearLayout.LayoutParams(LinearLayout.LayoutParams.MATCH_PARENT, LinearLayout.LayoutParams.WRAP_CONTENT)
        val dishTextView = TextView(context)
        dishTextView.layoutParams = dishLayoutParams
        dishTextView.setTextColor(Color.parseColor("#212121"))
        dishTextView.setPadding(20, 5, 0, 0)
        dishTextView.text = "${orderLine.amount}  ${orderLine.dish}"
        linearLayout.addView(dishTextView)

        val commentLayoutParams = LinearLayout.LayoutParams(LinearLayout.LayoutParams.MATCH_PARENT, LinearLayout.LayoutParams.WRAP_CONTENT)
        val commentTextView = TextView(context)
        commentTextView.layoutParams = commentLayoutParams
        commentTextView.setPadding(50, 5, 0, 10)
        commentTextView.text = orderLine.comment
        linearLayout.addView(commentTextView)
    }

    class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val tableNumber: TextView = itemView.findViewById(R.id.orderTableNumber)
        val orderLines: LinearLayout = itemView.findViewById(R.id.orderLines)
    }
}