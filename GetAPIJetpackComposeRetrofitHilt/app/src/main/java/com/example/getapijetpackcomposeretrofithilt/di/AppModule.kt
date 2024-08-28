package com.example.getapijetpackcomposeretrofithilt.di

import com.example.getapijetpackcomposeretrofithilt.api.CharactersAPI
import com.example.getapijetpackcomposeretrofithilt.utils.Constants.BASE_URL
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object AppModule {
    @Provides
    @Singleton
    fun provideAPI(): CharactersAPI {
        return Retrofit.Builder()
            .baseUrl(BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .build()
            .create(CharactersAPI::class.java)
    }
}