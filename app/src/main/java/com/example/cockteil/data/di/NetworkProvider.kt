package com.example.cockteil.data.di

import com.example.cockteil.data.network.CocktailApiClient
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)

object NetworkProvider {

    @Singleton
    @Provides
    fun getRetrofitProvider(): Retrofit {
        return Retrofit.Builder()
            .baseUrl("https://www.thecocktaildb.com/api/")
            .addConverterFactory(GsonConverterFactory.create())
            .build()
    }

    @Singleton
    @Provides
    fun getCocktailApiClient(retrofit: Retrofit): CocktailApiClient {
        return retrofit.create(CocktailApiClient::class.java)
    }


}