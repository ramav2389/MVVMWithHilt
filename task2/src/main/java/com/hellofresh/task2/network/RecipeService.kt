package com.hellofresh.task2.network

import com.hellofresh.task2.model.RecipeItem
import retrofit2.Response
import retrofit2.http.GET

interface RecipeService {
    @GET("recipes.json")
    suspend fun getAllRecipes(): Response<List<RecipeItem>>
}