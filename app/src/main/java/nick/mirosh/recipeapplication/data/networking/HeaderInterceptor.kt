package nick.mirosh.recipeapplication.data.networking

import nick.mirosh.recipeapplication.BuildConfig
import okhttp3.Interceptor
import okhttp3.Response

class HeaderInterceptor : Interceptor {
        override fun intercept(chain: Interceptor.Chain): Response = chain.run {
            proceed(
                    request()
                            .newBuilder()
                            .addHeader("x-api-key", BuildConfig.API_KEY)
                            .build()
            )
        }
    }