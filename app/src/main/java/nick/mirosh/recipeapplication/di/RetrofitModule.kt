package nick.mirosh.recipeapplication.di

import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import nick.mirosh.recipeapplication.BuildConfig
import nick.mirosh.recipeapplication.data.networking.HeaderInterceptor
import nick.mirosh.recipeapplication.data.networking.SpoonacularService
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

@Module
@InstallIn(SingletonComponent::class)
class RetrofitModule {

    @Provides
    fun provideSpoonacularService(
        okHttpClient: OkHttpClient
    ): SpoonacularService {

        val retrofit = Retrofit.Builder()
            .baseUrl(BuildConfig.BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .client(okHttpClient)
            .build()

        return retrofit.create(SpoonacularService::class.java)
    }

    @Provides
    fun provideOkHttpWithLogger(
    ): OkHttpClient {
        return OkHttpClient.Builder()
            .addInterceptor(HttpLoggingInterceptor().apply {
                level = HttpLoggingInterceptor.Level.BODY
            })
            .addInterceptor(HeaderInterceptor())
            .build()
    }
}