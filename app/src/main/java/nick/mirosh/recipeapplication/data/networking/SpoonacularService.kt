package nick.mirosh.recipeapplication.data.networking

import nick.mirosh.newsapp.data.entities.RecipesResponse
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Query


interface SpoonacularService {

    @GET("recipes/random")
    fun getRecipes(
        @Query("limitLicense") limitLicense: Boolean,
        @Query("tags") tags: String,
        @Query("number") number: Int,
    ): Call<RecipesResponse>

}