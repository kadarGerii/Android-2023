package com.tasty.recipesapp.viewmodel

import android.content.Context
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.tasty.recipesapp.api.dto.RecipeDTO
import com.tasty.recipesapp.repositories.RecipeRepository

class RecipeListViewModel(private val recipeRepository: RecipeRepository, private val context: Context): ViewModel() {
    private val _recipes = MutableLiveData<List<RecipeDTO>>()
    val recipes: LiveData<List<RecipeDTO>> get() = _recipes

    fun fetchData() {
        _recipes.value = recipeRepository.getRecipes(context)
    }
}