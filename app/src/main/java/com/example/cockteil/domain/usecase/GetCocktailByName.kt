package com.example.cockteil.domain.usecase

import android.annotation.SuppressLint
import com.example.cockteil.data.local.model.CocktailItem
import com.example.cockteil.data.repository.CocktailRepository
import com.example.cockteil.domain.services.GetCoktailByNameService
import javax.inject.Inject

class GetCocktailByName @Inject constructor(private val cocktailrepository: CocktailRepository): GetCoktailByNameService{
    @SuppressLint("SuspiciousIndentation")
    override suspend fun invoke(query: String): List<CocktailItem> {
      val cockatilListFromApi=cocktailrepository.getCocktailByName(query)
        return if(cockatilListFromApi.isEmpty()){
            emptyList()
        }else{
            cockatilListFromApi
        }
    }
}