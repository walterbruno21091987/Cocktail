package com.example.cockteil.data.repository

import android.util.Log
import com.example.cockteil.data.local.model.CocktailItem
import com.example.cockteil.data.network.service.CocktailService
import javax.inject.Inject

class CocktailRepository @Inject constructor( private val cocktailService: CocktailService) {
    suspend fun getCocktailByName(query:String):List<CocktailItem>{
        Log.d("API", "Consultando API con query: $query")
       val response=cocktailService.getCocktailList(query)

        Log.d("API", "Respuesta de la API: $response")
        return  response
    }
}