package nick.mirosh.recipeapplication.ui.main

import android.util.Log
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.launch
import nick.mirosh.recipeapplication.data.repository.RecipeRepository
import nick.mirosh.recipeapplication.di.IoDispatcher
import nick.mirosh.recipeapplication.domain.usecase.GetRecipesUseCase
import javax.inject.Inject

private const val TAG = "MainViewModel"

@HiltViewModel
class MainViewModel @Inject constructor(
    private val getRecipesUseCase: GetRecipesUseCase
) : ViewModel() {

    fun getRecipes() {
        viewModelScope.launch {
            val response = getRecipesUseCase()
            Log.d(TAG, "getRecipes: response = $response")
        }
    }
}