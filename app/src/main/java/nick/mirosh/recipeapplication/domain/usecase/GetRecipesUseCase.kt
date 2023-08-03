package nick.mirosh.recipeapplication.domain.usecase

import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.withContext
import nick.mirosh.recipeapplication.data.repository.RecipeRepository
import nick.mirosh.recipeapplication.di.IoDispatcher
import javax.inject.Inject

class GetRecipesUseCase @Inject constructor(
    private val recipeRepository: RecipeRepository,
    @IoDispatcher private val coroutineDispatcher: CoroutineDispatcher
) {

    suspend operator fun invoke() {
        withContext(coroutineDispatcher) {
            recipeRepository.getRecipes()
        }
    }
}