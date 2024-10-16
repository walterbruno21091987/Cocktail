package com.example.cockteil.ui.screen.searchByName

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.cockteil.data.local.model.CocktailItem
import com.example.cockteil.domain.usecase.GetCocktailByName
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject
@HiltViewModel
class SearchByNameViewModel @Inject constructor(private val getCocktailByName: GetCocktailByName): ViewModel() {
    private val _cocktailListByName= MutableStateFlow<List<CocktailItem>>(emptyList())
    val cocktailListByName= _cocktailListByName.asStateFlow()

    fun searchCoktailByName(query:String){
    viewModelScope.launch {     val list=getCocktailByName(query)
                if(list.isNotEmpty()){
                    _cocktailListByName.value=list
                }
    }
   }
}