package com.tasty.recipesapp.api.dto

import com.tasty.recipesapp.models.ComponentModel
import com.tasty.recipesapp.models.InstructionModel
import com.tasty.recipesapp.models.NutritionModel
import java.io.Serializable

data class RecipeDTO (
    val recipeId: Int,
    val name: String,
    val description: String,
    val thumbnailUrl: String,
    val keywords: String,
    val isPublic: Boolean,
    val userEmail: String,
    val originalVideoUrl: String,
    val country: String,
    val numServings: Int,
    val components: List<ComponentModel>,
    val instructions: List<InstructionModel>,
    val nutritions: NutritionModel
): Serializable