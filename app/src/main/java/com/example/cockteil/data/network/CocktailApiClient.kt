package com.example.cockteil.data.network

import com.example.cockteil.data.local.model.CocktailDataResponse
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Query

interface CocktailApiClient  {
    @GET("json/v1/1/search.php")
    suspend fun getCocktailByName(@Query("s") superHeroName: String): Response<CocktailDataResponse>
}