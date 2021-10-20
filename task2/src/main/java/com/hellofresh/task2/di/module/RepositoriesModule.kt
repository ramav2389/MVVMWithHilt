package com.hellofresh.task2.di.module


import com.hellofresh.task2.network.RecipeRepository
import com.hellofresh.task2.network.RecipeRepositoryImpl
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ViewModelComponent

@Module
@InstallIn(ViewModelComponent::class)
interface RepositoriesModule {

    @Binds
    fun recipeRepository(recipeRepositoryImpl: RecipeRepositoryImpl): RecipeRepository
}