package com.ecs198f.foodtrucks

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class FoodTruckMenuRecyclerViewAdapter(private var menuItems: List<FoodItem>): RecyclerView.Adapter<FoodTruckMenuRecyclerViewAdapter.ViewHolder>() {

    class ViewHolder(itemView: View): RecyclerView.ViewHolder(itemView) {
        val menuItemNameTextView: TextView = itemView.findViewById(R.id.menuItemNameText)
        val menuItemDescriptionTextView: TextView = itemView.findViewById(R.id.menuItemDescriptionText)
        val menuItemPriceTextView: TextView = itemView.findViewById(R.id.menuItemPriceText)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater
            .from(parent.context)
            .inflate(R.layout.menu_item, parent, false)

        return ViewHolder(view)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val menuItem = menuItems[position]

        holder.apply {
            menuItemNameTextView.text = menuItem.name
            menuItemDescriptionTextView.text = menuItem.description
            menuItemPriceTextView.text = "$${menuItem.price} (tax included)"
        }
    }

    override fun getItemCount() = menuItems.size

}