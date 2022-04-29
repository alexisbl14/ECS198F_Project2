package com.ecs198f.foodtrucks

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.navigation.findNavController
import androidx.recyclerview.widget.RecyclerView
import com.ecs198f.foodtrucks.databinding.FoodTruckListItemBinding

class FoodTruckListRecyclerViewAdapter(private val items: List<FoodTruck>) :
    RecyclerView.Adapter<FoodTruckListRecyclerViewAdapter.ViewHolder>() {

    class ViewHolder(itemView: View, var foodTruck: FoodTruck? = null) : RecyclerView.ViewHolder(itemView) {
        val nameTextView: TextView = itemView.findViewById(R.id.foodTruckListItemTitle)
        val priceTextView: TextView = itemView.findViewById(R.id.foodTruckListItemPriceLevel)
        val locationTextView: TextView = itemView.findViewById(R.id.foodTruckListItemLocation)
        val timeTextView: TextView = itemView.findViewById(R.id.foodTruckListItemTime)
        val truckImageView: ImageView = itemView.findViewById(R.id.foodTruckListItemImage)

        init {
            itemView.setOnClickListener {
                foodTruck?.let {
                    val action = FoodTruckListFragmentDirections.actionFoodTruckListFragmentToFoodTruckDetailFragment(it)
                    itemView.findNavController().navigate(action)
                }
            }
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater
            .from(parent.context)
            .inflate(R.layout.food_truck_list_item, parent, false)
        return ViewHolder(view)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val foodTruck = items[position]

        items[position].let {
            holder.apply {
                nameTextView.text = it.name
                priceTextView.text = "$".repeat(it.priceLevel)
                truckImageView.setImageResource(it.imageResId)
                locationTextView.text = it.location
                timeTextView.text = it.formattedTimeInterval
            }
        }

        holder.foodTruck = items[position]
        /*holder.itemView.setOnClickListener{
            val action = FoodTruckListFragmentDirections.actionFoodTruckListFragmentToFoodTruckDetailFragment(items[position])
            holder.findNavController().navigate(action)

        }*/
    }

    override fun getItemCount() = items.size
}