package com.ecs198f.foodtrucks

import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Path

interface FoodTruckService {
    @GET("/food-trucks")
    fun listFoodTrucks(): Call<List<FoodTruck>>

    @GET("/food-trucks/{id}")
    fun getFoodTruck(@Path("id") id: String): Call<FoodTruck>

    @GET("/food-trucks/{truckId}/items")
    fun getFoodTruckItems(@Path("truckId") truckId: String): Call<List<FoodItem>>
}