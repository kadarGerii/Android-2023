package com.tasty.recipesapp.repositories

import android.content.Context
import android.util.Log
import com.google.firebase.crashlytics.buildtools.reloc.com.google.common.reflect.TypeToken
import com.google.gson.Gson
import com.tasty.recipesapp.api.dto.RecipeDTO
import java.io.IOException

class RecipeRepository {


    fun getRecipes(context: Context): List<RecipeDTO> {
        val gson = Gson()
        var recipeList = listOf<RecipeDTO>()
        val assetManager = context.assets
        try {
            val inputStream = assetManager.open("more_recipes.json")
            val size = inputStream.available()
            val buffer = ByteArray(size)
            inputStream.read(buffer)
            inputStream.close()
            val jsonString = String(buffer, Charsets.UTF_8)

            // Parse JSON array directly since the input JSON is an array, not an object
            val type = object : TypeToken<List<RecipeDTO>>() {}.type
            recipeList = gson.fromJson(jsonString, type)

            Log.i("GSON", recipeList.toString())
        } catch (e: IOException) {
            e.printStackTrace()
        }
        return recipeList
    }
}