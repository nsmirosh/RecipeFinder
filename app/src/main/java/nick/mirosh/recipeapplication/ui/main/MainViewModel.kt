package nick.mirosh.recipeapplication.ui.main

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.launch
import nick.mirosh.recipeapplication.data.repository.RecipeRepository
import nick.mirosh.recipeapplication.di.IoDispatcher
import javax.inject.Inject

@HiltViewModel
class MainViewModel @Inject constructor(
    @IoDispatcher private val dispatcher: CoroutineDispatcher,
    private val recipeRepository: RecipeRepository
) : ViewModel() {

    fun getRecipes() {
        viewModelScope.launch(dispatcher) {
            recipeRepository.getRecipes()
        }
    }
}