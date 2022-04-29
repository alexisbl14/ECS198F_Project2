package com.ecs198f.foodtrucks

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

class FoodTruckDetailFragment : Fragment() {

    private val menuItems = listOf(
        FoodItem(
            "Thai BBQ Chicken",
            "Rice bowl combo with salad (400 cal)",
            12.0
        ),
        FoodItem(
            "Lemongrass Tofu",
            "Rice bowl combo with salad (Vegan) (390 cal)",
            10.0
        ),
        FoodItem(
            "Teriyaki Chicken",
            "Rice bowl combo with salad (565 cal)",
            12.0
        ),
        FoodItem(
            "Spring Roll",
            "2 rolls (120 cal)",
            3.5
        )
    )

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        val view = inflater.inflate(R.layout.fragment_food_truck_detail, container, false)
        view.findViewById<RecyclerView>(R.id.foodTruckMenuRecyclerView).apply {
            layoutManager = LinearLayoutManager(context)
            adapter = FoodTruckMenuRecyclerViewAdapter(menuItems)
        }

        return view
    }


}