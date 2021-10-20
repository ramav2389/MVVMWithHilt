package com.hellofresh.task2.network

import com.hellofresh.task2.model.RecipeItem
import retrofit2.Response


interface RecipeRepository {
    suspend fun getAllRecipes(): Response<List<RecipeItem>>
}