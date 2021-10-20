package com.hellofresh.task2.network

import com.hellofresh.task2.model.RecipeItem
import retrofit2.Response
import javax.inject.Inject


class RecipeRepositoryImpl @Inject constructor(private val recipeService: RecipeService) :
    RecipeRepository {
    override suspend fun getAllRecipes(): Response<List<RecipeItem>> = recipeService.getAllRecipes()
}
