package com.tasty.recipesapp.viewmodel

import android.content.Context
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.tasty.recipesapp.repositories.RecipeRepository

class RecipeListViewModelFactory(
    private val context: Context,
    private val recipeRepository: RecipeRepository
) : ViewModelProvider.Factory {

    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        if (modelClass.isAssignableFrom(RecipeListViewModel::class.java)) {
            return RecipeListViewModel(recipeRepository, context) as T
        }
        throw IllegalArgumentException("Unknown ViewModel class")
    }
}
