package com.example.cockteil.domain.services

import com.example.cockteil.data.local.model.CocktailItem

interface GetCoktailByNameService {
    suspend operator fun invoke(query: String): List<CocktailItem>
}