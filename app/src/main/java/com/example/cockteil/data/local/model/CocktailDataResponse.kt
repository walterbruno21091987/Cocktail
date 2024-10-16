package com.example.cockteil.data.local.model

import com.google.gson.annotations.SerializedName

data class CocktailDataResponse(
    @SerializedName("drinks") val cocktails: List<CocktailItem>
)
