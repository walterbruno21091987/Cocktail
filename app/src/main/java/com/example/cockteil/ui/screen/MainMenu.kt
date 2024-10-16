package com.example.cockteil.ui.screen

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.navigation.NavHostController
import androidx.compose.ui.Alignment
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.compose.rememberNavController
import com.example.cockteil.R
import com.example.cockteil.ui.component.ButtonWithBackgroundImage
import com.example.cockteil.ui.navigation.Routes

@Preview
@Composable
fun MainMenuTest(){
    val navigationController = rememberNavController()
    MainMenu(navigationController)
}

@Composable
fun MainMenu(navController: NavHostController) {

    Box(
        modifier = Modifier
            .fillMaxSize()
    ) {
        // Imagen de fondo
        Image(
            painter = painterResource(id = R.drawable.refresco),
            contentDescription = null,
            contentScale = ContentScale.Crop,
            modifier = Modifier.matchParentSize()
        )


        Column(

            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Top
        ) {
/*
        {

    }
  */ Text(
            text = "COCKTAIL",
            Modifier.padding(top = 80.dp),
            fontFamily = FontFamily(Font(R.font.crushnburn_regular)),
            color = Color.Red,
            fontSize = 80.sp
        )
            Column(
                modifier = Modifier.weight(1f),
                verticalArrangement = Arrangement.Center, horizontalAlignment = Alignment.CenterHorizontally
            ) {
                ButtonWithBackgroundImage(
                    imageResId = R.drawable.button_cock,
                    onClick = {
                            navController.navigate(Routes.SearchByName.route)
                    },
                    modifier = Modifier.size(400.dp,100.dp)

                    ) {
                    Text(
                        text = stringResource(id = R.string.SBN),
                        fontWeight = FontWeight.Bold,

                        fontStyle = FontStyle.Italic,
                        fontSize = 28.sp,
                        color = Color.Black
                    )
                }




                ButtonWithBackgroundImage(
                    imageResId = R.drawable.button_cock,
                    onClick = {

                    },
                    modifier = Modifier
                        .size(500.dp, 100.dp)



                    ) {
                    Text(
                        text = stringResource(id = R.string.SBI),
                        fontWeight = FontWeight.Bold,

                        fontStyle = FontStyle.Italic,
                        fontSize = 28.sp,
                        color = Color.Black
                    )
                }
                ButtonWithBackgroundImage(
                    imageResId = R.drawable.button_cock,
                    onClick = {

                    },
                    modifier = Modifier
                        .size(500.dp, 100.dp)



                ) {
                    Text(
                        text = stringResource(id = R.string.NC),
                        fontWeight = FontWeight.Bold,

                        fontStyle = FontStyle.Italic,
                        fontSize = 28.sp,
                        color = Color.Black
                    )
                }

            }
        }
    }
}


