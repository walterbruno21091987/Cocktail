package com.example.cockteil.ui.screen.searchByName

import android.util.Log
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.layout.wrapContentWidth
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.selection.selectable
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.HorizontalDivider
import androidx.compose.material3.SearchBar
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import coil.compose.rememberAsyncImagePainter
import com.example.cockteil.R


@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun SearchByName( searchByNameViewModel: SearchByNameViewModel){
    var query by remember { mutableStateOf("") }
    var isActive by remember { mutableStateOf(false) }
    val cocktailList by searchByNameViewModel.cocktailListByName.collectAsState()
    Column (
        Modifier
            .fillMaxSize()
            .background(color = Color.Black)) {



        SearchBar(
            query = query,
            onQueryChange = { query = it },
            onSearch = {searchByNameViewModel.searchCoktailByName(query) },
            placeholder ={ Text(text = "Enter name  a drink",fontSize = 20.sp)},
            active = false,
            onActiveChange = { isActive = it },
            modifier=Modifier.align(Alignment.CenterHorizontally)) {}

        val list=cocktailList
        if(list.isNotEmpty()){
        Column(
            modifier = Modifier
                .fillMaxWidth()
                .padding(top = 16.dp)
        ) {
            Text(
                text = "Select image to view full",
                color = Color.White,
                fontSize = 20.sp,
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(top = 10.dp, bottom = 20.dp)
                    .wrapContentWidth(Alignment.CenterHorizontally)
            )
        }}

        LazyColumn (modifier=Modifier.fillMaxSize()){
          
            items(list){
                HorizontalDivider(
                    modifier = Modifier
                        .fillMaxWidth()
                        .size(4.dp)
                        .padding(top = 6.dp, bottom = 6.dp),
                    color = Color.White
                )
                Spacer(modifier = Modifier.height(8.dp))

                Row(){
                    Image(
                        painter = rememberAsyncImagePainter(it.imageurl),
                        contentDescription = null,
                        contentScale = ContentScale.Crop,
                        modifier = Modifier
                            .height(200.dp)
                            .width(200.dp).clickable {  }

                    )
                    Column () {
                        Text(text = it.nameCocktail.uppercase(), color = Color.Red,fontFamily = FontFamily(Font(R.font.creepster_regular)),fontSize = 25.sp,modifier=Modifier.padding(start = 20.dp))
                        Text(text = it.instructions, color = Color.White,fontSize = 15.sp,modifier=Modifier.padding(start = 20.dp,top=10.dp, bottom = 20.dp),maxLines = 5,overflow = TextOverflow.Ellipsis)


                    }

                }
                Spacer(modifier = Modifier.height(8.dp))
                HorizontalDivider(
                    modifier = Modifier
                        .fillMaxWidth()
                        .size(4.dp)
                        .padding(top = 6.dp, bottom = 6.dp),
                    color = Color.White
                )

                
            }
            
        }
    }

}