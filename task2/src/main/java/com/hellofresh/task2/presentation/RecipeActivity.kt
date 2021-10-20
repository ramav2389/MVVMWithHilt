package com.hellofresh.task2.presentation

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.Toast
import androidx.activity.viewModels
import com.hellofresh.task2.R
import com.hellofresh.task2.databinding.ActivityMainBinding
import com.hellofresh.task2.util.DateUtil
import com.hellofresh.task2.util.DateUtil.Companion.toString
import com.hellofresh.task2.util.snack
import dagger.hilt.android.AndroidEntryPoint
import java.util.*
import javax.inject.Inject

@AndroidEntryPoint
class RecipeActivity : AppCompatActivity() {

    @Inject
    lateinit var adapter: RecipeAdapter
    private lateinit var binding: ActivityMainBinding
    private val viewModel: RecipeViewModel by viewModels()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        observeRecipes()
        observeError()
        observeLoader()
    }

    private fun observeRecipes() {
        binding.recyclerview.adapter = adapter
        viewModel.recipeList.observe(this, {
            adapter.setRecipeList(it)
        })
        viewModel.getAllRecipes()
    }

    private fun observeError() {
        viewModel.errorMessage.observe(this, {
            Toast.makeText(this, it, Toast.LENGTH_SHORT).show()
            binding.root.snack(it)
        })

    }

    private fun observeLoader() {
        viewModel.showLoader.observe(this, {
            if (it) {
                binding.progressDialog.visibility = View.VISIBLE
            } else {
                binding.progressDialog.visibility = View.GONE
            }
        })

    }

}