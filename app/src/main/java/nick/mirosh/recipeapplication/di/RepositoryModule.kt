package nick.mirosh.recipeapplication.di

import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ViewModelComponent
import dagger.hilt.android.scopes.ViewModelScoped
import nick.mirosh.recipeapplication.data.repository.RecipeRepository
import nick.mirosh.recipeapplication.data.repository.RecipeRepositoryImpl

@Module
@InstallIn(ViewModelComponent::class)
abstract class RepositoryModule {

    @Binds
    @ViewModelScoped
    abstract fun provideRecipesRepository(
        recipeRepositoryImpl: RecipeRepositoryImpl
    ): RecipeRepository
}