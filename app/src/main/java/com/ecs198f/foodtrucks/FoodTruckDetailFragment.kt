package com.ecs198f.foodtrucks

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.navigation.fragment.navArgs
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

class FoodTruckDetailFragment : Fragment() {

    private val args: FoodTruckDetailFragmentArgs by navArgs()
    private lateinit var foodTruck: FoodTruck

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
        foodTruck = args.foodTruck

        view.findViewById<RecyclerView>(R.id.foodTruckMenuRecyclerView).apply {
            layoutManager = LinearLayoutManager(context)
            adapter = FoodTruckMenuRecyclerViewAdapter(menuItems)
        }

        return view
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val truckImageView: ImageView = view.findViewById(R.id.foodTruckListItemFragmentImage)
        val locationTextView: TextView = view.findViewById(R.id.foodTruckListItemFragmentLocation)
        val timeTextView: TextView = view.findViewById(R.id.foodTruckListItemFragmentTime)
        val priceTextView: TextView = view.findViewById(R.id.foodTruckListItemFragmentPriceLevel)

        val activity = requireActivity() as MainActivity
        activity.title = foodTruck.name

        //truckImageView.setImageResource(foodTruck.imageUrl)
        locationTextView.text = foodTruck.location
        timeTextView.text = foodTruck.formattedTimeInterval
        priceTextView.text = "$".repeat(foodTruck.priceLevel)

    }


}