package com.hellofresh.task2.model


data class RecipeItem(
    val calories: String?,
    val carbos: String?,
    val country: String?,
    val description: String?,
    val difficulty: Int?= 0,
    val fats: String?,
    val headline: String?,
    val id: String?,
    val image: String?,
    val name: String?,
    val proteins: String?,
    val thumb: String?,
    val time: String?
)