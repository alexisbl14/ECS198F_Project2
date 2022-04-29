package com.ecs198f.foodtrucks

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.ecs198f.foodtrucks.databinding.ActivityMainBinding
import java.time.LocalDateTime

class FoodTruckListFragment : Fragment() {

    private val foodTrucks = listOf(
        FoodTruck(
            "1",
            "Shah's Halal",
            R.drawable.shah_s_halal,
            3,
            "Silo Patio",
            LocalDateTime.of(2021, 10, 4, 11, 0, 0, 0),
            LocalDateTime.of(2021, 10, 4, 16, 0, 0, 0),
        ),
        FoodTruck(
            "2",
            "Hefty Gyros",
            R.drawable.hefty_gyros,
            2,
            "West Quad",
            LocalDateTime.of(2021, 10, 4, 11, 0, 0, 0),
            LocalDateTime.of(2021, 10, 4, 15, 0, 0, 0),
        ),
        FoodTruck(
            "3",
            "Star Ginger",
            R.drawable.starginger,
            3,
            "Silo Patio",
            LocalDateTime.of(2021, 10, 4, 13,0, 0, 0),
            LocalDateTime.of(2021, 10, 4, 16,0, 0, 0),
        ),
        FoodTruck(
            "4",
            "Bangin Bowls",
            R.drawable.banginbowls,
            2,
            "Tercero DC",
            LocalDateTime.of(2021, 10, 4, 14,0, 0, 0),
            LocalDateTime.of(2021, 10, 4, 18,0, 0, 0),
        ),
        FoodTruck(
            "5",
            "Authentic Street Taco",
            R.drawable.authenticstreettacos,
            3,
            "Silo Patio",
            LocalDateTime.of(2021, 10, 4, 11,0, 0, 0),
            LocalDateTime.of(2021, 10, 4, 16,0, 0, 0),
        )
    )

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        val activity = requireActivity() as MainActivity
        activity.title = "Food Trucks"

        val view = inflater.inflate(R.layout.fragment_food_truck_list, container, false)
        view.findViewById<RecyclerView>(R.id.foodTruckListFragmentRecyclerView).apply {
            layoutManager = LinearLayoutManager(context)
            adapter = FoodTruckListRecyclerViewAdapter(foodTrucks)
        }

        return view
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        view.findViewById<RecyclerView>(R.id.foodTruckMenuRecyclerView)
    }




}