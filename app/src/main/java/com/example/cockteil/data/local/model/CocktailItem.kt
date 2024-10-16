package com.example.cockteil.data.local.model

import com.google.gson.annotations.SerializedName

data class CocktailItem(
    @SerializedName("strDrink") var nameCocktail:String,
    @SerializedName("strCategory") var category:String,
@SerializedName("strInstructions") var instructions:String,
@SerializedName("strDrinkThumb") var imageurl:String,
    @SerializedName("strIngredient1") val ingredient1: String?,
@SerializedName("strIngredient2") val ingredient2: String?,
@SerializedName("strIngredient3") val ingredient3: String?


)
