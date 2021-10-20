package com.hellofresh.task2.presentation

import android.app.Application
import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.hellofresh.task2.base.BaseCoroutinesViewModel
import com.hellofresh.task2.util.Resource
import com.hellofresh.task2.util.Status
import com.hellofresh.task2.model.RecipeItem
import com.hellofresh.task2.network.RecipeRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class RecipeViewModel @Inject constructor(private val repository: RecipeRepository) :
    BaseCoroutinesViewModel(application = Application()) {

    private val _recipeList = MutableLiveData<List<RecipeItem>>()
    val recipeList: LiveData<List<RecipeItem>>
        get() = _recipeList
    private val _errorMessage = MutableLiveData<String>()
    val errorMessage: LiveData<String>
        get() = _errorMessage
    private val _showLoader = MutableLiveData<Boolean>(false)
    val showLoader: LiveData<Boolean>
        get() = _showLoader

    fun getAllRecipes() {
        launchNetworkJob(networkRequest = {
            repository.getAllRecipes()
        }, onResult = {
            parseResponse(it)
        })
    }

    private fun parseResponse(result: Resource<List<RecipeItem>>) {
        when (result.status) {
            Status.SUCCESS -> {
                result.data?.let {
                    _recipeList.postValue(it)
                }
                _showLoader.postValue(false)
            }
            Status.ERROR -> {
                Log.d("", "error in fetching recipes")
                _showLoader.postValue(false)
                _errorMessage.postValue("error in fetching recipes")
            }
            Status.LOADING -> {
                _showLoader.postValue(true)
            }

        }
    }

    override fun onCleared() {
        super.onCleared()
        job?.cancel()
    }
}