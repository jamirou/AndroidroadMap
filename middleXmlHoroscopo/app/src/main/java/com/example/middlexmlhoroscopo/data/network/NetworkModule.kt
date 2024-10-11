package com.example.middlexmlhoroscopo.data.network

import com.example.middlexmlhoroscopo.BuildConfig.BASE_URL
import com.example.middlexmlhoroscopo.data.RepositoryImplementation
import com.example.middlexmlhoroscopo.data.core.interceptors.AuthInterceptor
import com.example.middlexmlhoroscopo.domain.Repository
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object NetworkModule {
    @Provides
    @Singleton
    fun provideRetrofit(okHttpClient: OkHttpClient): Retrofit {
        return Retrofit
            .Builder()
            .baseUrl(BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .client(okHttpClient)
            .build()
    }

    @Provides
    @Singleton
    fun provideOkkHttpClient(authInterceptor: AuthInterceptor): OkHttpClient {

        val interceptor = HttpLoggingInterceptor().setLevel(HttpLoggingInterceptor.Level.BODY)
        return OkHttpClient
            .Builder()
            .addInterceptor(interceptor)
            .addInterceptor(authInterceptor)
            .build()
    }

    @Provides
    fun provideHoroscopoApiService(retrofit: Retrofit): HoroscopoApiService {
        return retrofit.create(HoroscopoApiService::class.java)
    }

    @Provides
    fun provideRepository(apiService: HoroscopoApiService):Repository {
        return RepositoryImplementation(apiService)
    }

}