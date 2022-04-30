package com.ecs198f.foodtrucks

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.navArgs
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class FoodTruckDetailFragment : Fragment() {

    private val args: FoodTruckDetailFragmentArgs by navArgs()
    private lateinit var foodTruck: FoodTruck

    private val menuItems = listOf<FoodItem>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        var foodTruckItemAdapter = FoodTruckMenuRecyclerViewAdapter(emptyList())
        foodTruck = args.foodTruck
        val activity = requireActivity() as MainActivity
        activity.title = foodTruck.name
        // Inflate the layout for this fragment
        val view = inflater.inflate(R.layout.fragment_food_truck_detail, container, false)
        val truckImageView: ImageView = view.findViewById(R.id.foodTruckListItemFragmentImage)
        val locationTextView: TextView = view.findViewById(R.id.foodTruckListItemFragmentLocation)
        val timeTextView: TextView = view.findViewById(R.id.foodTruckListItemFragmentTime)
        val priceTextView: TextView = view.findViewById(R.id.foodTruckListItemFragmentPriceLevel)

        view.findViewById<RecyclerView>(R.id.foodTruckMenuRecyclerView).apply {
            layoutManager = LinearLayoutManager(context)
            adapter = foodTruckItemAdapter
        }
        val service = (requireActivity() as MainActivity).service
        service.getFoodTruckItems(foodTruck.id).enqueue(object : Callback<List<FoodItem>> {
            override fun onResponse(
                call: Call<List<FoodItem>>,
                response: Response<List<FoodItem>>
            ) {
                foodTruckItemAdapter.updateFoodItems(response.body()!!)
                locationTextView.text = foodTruck.location
                timeTextView.text = foodTruck.formattedTimeInterval
                priceTextView.text = "$".repeat(foodTruck.priceLevel)
                Glide.with(view.context)
                    .load(foodTruck.imageUrl)
                    .into(truckImageView)
            }

            override fun onFailure(call: Call<List<FoodItem>>, t: Throwable) {
                throw t
            }

        })

        return view
    }

}