package com.example.onlineshop.presentation.screens.components

import android.util.Log
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController
import com.example.onlineshop.R
import com.example.onlineshop.presentation.navigation.AppDestination
import com.example.onlineshop.presentation.navigation.Page1Screen
import com.example.onlineshop.presentation.navigation.ProfileScreen
import com.example.onlineshop.presentation.navigation.navigateSingleTopTo

@Composable
fun BottomItems(
    navController: NavHostController,
    currentScreen: AppDestination,
) {
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .background(Color(0xFFFAF9FF))
            .padding(bottom = 15.dp),
        horizontalArrangement = Arrangement.SpaceEvenly,
        verticalAlignment = Alignment.CenterVertically
    ) {

        Box(
            modifier = Modifier
                .let {
                    if (currentScreen.route == Page1Screen.route) {
                        Modifier
                            .clip(CircleShape)
                            .background(Color(0xFFEEEFF4))
                    } else {
                        it
                    }
                }
                .size(50.dp)
                .align(Alignment.CenterVertically)

        ) {
            Image(
                painter = painterResource(id = R.drawable.home),
                contentDescription = "Home",
                contentScale = ContentScale.Fit,
                modifier = Modifier
                    .size(20.dp)
                    .align(Alignment.Center)
                    .clickable(onClick = {
                        Log.d(
                            "TAG-Bottom-Nav",
                            "${currentScreen.route}  CLICKED"
                        )
                        navController.navigateSingleTopTo(Page1Screen.route)
                    })
            )
        }
        Box(
            modifier = Modifier
                .size(50.dp)
                .clip(CircleShape)
                .align(Alignment.CenterVertically)
        ) {
            Image(
                painter = painterResource(id = R.drawable.favorites),
                contentDescription = "Favorites",
                contentScale = ContentScale.Fit,
                modifier = Modifier
                    .size(20.dp)
                    .align(Alignment.Center)
            )
        }
        Box(
            modifier = Modifier
                .size(50.dp)
                .clip(CircleShape)
                .align(Alignment.CenterVertically)
        ) {
            Image(
                painter = painterResource(id = R.drawable.shopping_cart),
                contentDescription = "Shop cart",
                contentScale = ContentScale.Fit,
                modifier = Modifier
                    .size(20.dp)
                    .align(Alignment.Center)
            )
        }
        Box(
            modifier = Modifier
                .size(50.dp)
                .clip(CircleShape)
                .align(Alignment.CenterVertically)
        ) {
            Image(
                painter = painterResource(id = R.drawable.message),
                contentDescription = "Message",
                contentScale = ContentScale.Fit,
                modifier = Modifier
                    .size(20.dp)
                    .align(Alignment.Center)
            )
        }
        Box(
            modifier = Modifier
                .let {
                    if (currentScreen.route == ProfileScreen.route) {
                        Modifier
                            .clip(CircleShape)
                            .background(Color(0xFFEEEFF4))
                    } else {
                        it
                    }
                }
                .size(50.dp)
                .align(Alignment.CenterVertically)

        ) {
            Image(
                painter = painterResource(id = R.drawable.profile),
                contentDescription = "Profile Image",
                contentScale = ContentScale.Fit,
                modifier = Modifier
                    .size(20.dp)
                    .align(Alignment.Center)
                    .clickable(onClick = {
                        Log.d(
                            "TAG-Bottom-Nav",
                            "${currentScreen.route}  CLICKED"
                        )
                        navController.navigateSingleTopTo(ProfileScreen.route)
                    })
            )
        }


    }
}