package nick.mirosh.recipeapplication.data.repository

import android.util.Log
import nick.mirosh.newsapp.data.entities.Recipe
import nick.mirosh.recipeapplication.data.networking.SpoonacularService
import javax.inject.Inject

class RecipeRemoteDataSource @Inject constructor(private val spoonacularService: SpoonacularService) {
    fun getHeadlines(): List<Recipe> {
        val response = spoonacularService.getRecipes(true, "diet", 1).execute().body()
        Log.d("NewsRemoteDataSource", "getHeadlines() response = ${response!!.recipes?.size}")
        return response.recipes!!
    }
}