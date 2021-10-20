package com.hellofresh.task2.presentation

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.hellofresh.task2.databinding.AdapterRecipeBinding
import com.hellofresh.task2.model.RecipeItem
import com.hellofresh.task2.util.DateUtil
import com.hellofresh.task2.util.DateUtil.Companion.toString
import java.util.*
import javax.inject.Inject

class RecipeAdapter @Inject constructor() : RecyclerView.Adapter<RecipeViewHolder>() {

    private var recipes = mutableListOf<RecipeItem>()

    fun setRecipeList(recipe: List<RecipeItem>) {
        this.recipes = recipe.toMutableList()
        notifyDataSetChanged()
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecipeViewHolder {
        val inflater = LayoutInflater.from(parent.context)

        val binding = AdapterRecipeBinding.inflate(inflater, parent, false)
        return RecipeViewHolder(binding)
    }

    override fun onBindViewHolder(holder: RecipeViewHolder, position: Int) {
        when (position) {
            0 -> {
                holder.binding.dateLayout.visibility = View.VISIBLE
            }
            else -> {
                holder.binding.dateLayout.visibility = View.GONE
            }
        }

        val recipe = recipes[position]
        holder.binding.name.text = recipe.name
        /**
         * Adding Date can be done in different approach also by introducing ViewType
         * here as date has to be displayed in first  only so i chose this approach
         */
        (DateUtil.getCurrentDateTime()
            .toString(
                DateUtil.dd_MMM,
                Locale.getDefault()
            ) + " Recipes").also { holder.binding.date.text = it }
        holder.binding.headline.text = recipe.headline
        Glide.with(holder.itemView.context).load(recipe.image).into(holder.binding.imageview)
    }

    override fun getItemCount(): Int {
        return recipes.size
    }
}

class RecipeViewHolder(val binding: AdapterRecipeBinding) : RecyclerView.ViewHolder(binding.root)
