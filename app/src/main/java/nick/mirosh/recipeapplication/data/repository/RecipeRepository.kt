package nick.mirosh.recipeapplication.data.repository

import nick.mirosh.newsapp.data.entities.Recipe

interface RecipeRepository {

    suspend fun getRecipes(): List<Recipe>?

}