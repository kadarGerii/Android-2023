package com.tasty.recipesapp.models

data class ComponentModel (
    val rawText: String,
    val extraComment: String,
    val ingredient: IngredientModel,
    val measurement: MeasurementModel
)