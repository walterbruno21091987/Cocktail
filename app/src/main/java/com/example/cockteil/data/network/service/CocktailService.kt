package com.example.cockteil.data.network.service


import com.example.cockteil.data.local.model.CocktailItem
import com.example.cockteil.data.network.CocktailApiClient
import javax.inject.Inject

class CocktailService @Inject constructor(private val cocktailApiClient: CocktailApiClient) {

    suspend fun getCocktailList(query:String):List<CocktailItem>{
        val response = cocktailApiClient.getCocktailByName(query)
        return response.body()?.cocktails ?: emptyList()
    }
}