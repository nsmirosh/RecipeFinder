package nick.mirosh.recipeapplication.data.repository

import nick.mirosh.newsapp.data.entities.Recipe
import nick.mirosh.recipeapplication.data.networking.SpoonacularService
import javax.inject.Inject

class RecipeRepositoryImpl @Inject constructor(private val spoonacularService: SpoonacularService) :
    RecipeRepository {

    override suspend fun getRecipes(): List<Recipe>? {
        val response = spoonacularService.getRecipes(true, "diet", 1).execute().body()
        return response?.recipes
    }
}