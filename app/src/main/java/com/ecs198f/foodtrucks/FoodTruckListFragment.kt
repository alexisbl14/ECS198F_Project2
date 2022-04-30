package com.ecs198f.foodtrucks

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class FoodTruckListFragment : Fragment() {

    private val foodTrucks = listOf<FoodTruck>()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        val activity = requireActivity() as MainActivity
        activity.title = "Food Trucks"
        var foodTruckListAdapter = FoodTruckListRecyclerViewAdapter(emptyList())

        val view = inflater.inflate(R.layout.fragment_food_truck_list, container, false)
        view.findViewById<RecyclerView>(R.id.foodTruckListFragmentRecyclerView).apply {
            layoutManager = LinearLayoutManager(context)
            adapter = foodTruckListAdapter
        }
        val service = (requireActivity() as MainActivity).service
        service.listFoodTrucks().enqueue(object : Callback<List<FoodTruck>> {
            override fun onResponse(
                call: Call<List<FoodTruck>>,
                response: Response<List<FoodTruck>>
            ) {
                Log.d("my MSG", response.body().toString())
                foodTruckListAdapter.updateFoodTrucks(response.body()!!)
            }

            override fun onFailure(call: Call<List<FoodTruck>>, t: Throwable) {
                throw t
            }

        })
        return view
    }





}