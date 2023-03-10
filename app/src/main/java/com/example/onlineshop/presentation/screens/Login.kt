package com.example.onlineshop.presentation.screens

import android.util.Log
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.capitalize
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController
import com.example.onlineshop.R
import com.example.onlineshop.presentation.navigation.AppDestination
import com.example.onlineshop.presentation.navigation.Page1Screen
import com.example.onlineshop.presentation.navigation.navigateSingleTopTo
import com.example.onlineshop.presentation.viewmodel.MainViewModel
import java.util.*

@Composable
fun Login(
    navController: NavHostController,
    currentScreen: AppDestination,
    vm: MainViewModel
) {

    val state by vm.viewState.collectAsState()

    LaunchedEffect(state.isLogged) {
        if (state.isLogged) {
            navController.navigateSingleTopTo(Page1Screen.route)
        }
    }

    Surface(
        color = MaterialTheme.colors.primary,
        modifier = Modifier.fillMaxSize()
    ) {
        var firstName by remember { mutableStateOf("") }
        var password by remember { mutableStateOf("") }


        Box(
            modifier = Modifier.fillMaxSize(),
            contentAlignment = Alignment.Center
        ) {

            Column(
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                Box(
                    modifier = Modifier
                        .padding(bottom = 50.dp)
                        .width(200.dp)
                        .height(50.dp)
                ) {
                    Text(
                        text = "Welcome back",
                        fontFamily = FontFamily(Font(R.font.montserrat, FontWeight.Bold)),
                        fontWeight = FontWeight.W600,
                        fontSize = 26.sp,
                        letterSpacing = (-0.3).sp,
                        lineHeight = 31.69.sp,
                        textAlign = TextAlign.Center,
                        modifier = Modifier
                            .fillMaxWidth(),
                        color = Color.Black
                    )
                }

                Column(
                    verticalArrangement = Arrangement.Center,
                    horizontalAlignment = Alignment.CenterHorizontally,
                    modifier = Modifier
                        .padding(horizontal = 44.dp)
                ) {
                    val textStyle = TextStyle(
                        fontFamily = FontFamily(Font(R.font.montserrat, FontWeight.Normal)),
                        fontWeight = FontWeight.W500,
                        fontSize = 11.sp,
                        lineHeight = 13.sp,
                        textAlign = TextAlign.Start,
                        letterSpacing = (-0.3).sp,
                        color = Color(0xFF7B7B7B)
                    )
                    TextField(
                        value = firstName,
                        onValueChange = { firstName = it },
                        modifier = Modifier
                            .height(50.dp)
                            .fillMaxWidth(),
                        shape = RoundedCornerShape(15.dp),
                        placeholder = {
                            Text(
                                modifier = Modifier
                                    .fillMaxSize(),
                                text = "First name",
                                fontFamily = FontFamily(Font(R.font.montserrat, FontWeight.Normal)),
                                fontWeight = FontWeight.W500,
                                fontSize = 11.sp,
                                lineHeight = 13.sp,
                                textAlign = TextAlign.Center,
                                letterSpacing = (-0.3).sp,
                                color = Color(0xFF7B7B7B)
                            )
                        },
                        colors = TextFieldDefaults.textFieldColors(
                            unfocusedIndicatorColor = Color.Transparent,
                            backgroundColor = Color(0xFFE8E8E8)
                        ),
                        textStyle = textStyle
                    )
                    Spacer(modifier = Modifier.height(30.dp))
                    TextField(
                        value = password,
                        onValueChange = { password = it },
                        modifier = Modifier
                            .height(50.dp)
                            .fillMaxWidth(),
                        shape = RoundedCornerShape(15.dp),
                        placeholder = {
                            Row(
                                modifier = Modifier
                                    .fillMaxSize(),
                                verticalAlignment = Alignment.CenterVertically,
                                horizontalArrangement = Arrangement.SpaceBetween
                            ) {
                                Text(
                                    modifier = Modifier
                                        .padding(vertical = 2.dp)
                                        .weight(1f),
                                    text = "Password",
                                    fontFamily = FontFamily(
                                        Font(
                                            R.font.montserrat,
                                            FontWeight.Normal
                                        )
                                    ),
                                    fontWeight = FontWeight.W500,
                                    fontSize = 11.sp,
                                    lineHeight = 13.sp,
                                    textAlign = TextAlign.Center,
                                    letterSpacing = (-0.3).sp,
                                    color = Color(0xFF7B7B7B)
                                )
                                Image(
                                    painter = painterResource(id = R.drawable.eye_of),
                                    contentDescription = "SVG image",
                                    modifier = Modifier.size(15.dp)
                                )
                            }

                        },
                        colors = TextFieldDefaults.textFieldColors(
                            unfocusedIndicatorColor = Color.Transparent,
                            backgroundColor = Color(0xFFE8E8E8)
                        ),
                        textStyle = textStyle
                    )
                }

                Box(
                    modifier = Modifier
                        .padding(top = 50.dp, start = 44.dp, end = 44.dp)
                        .fillMaxWidth()
                ) {
                    Column(
                    ) {
                        Button(
                            modifier = Modifier
                                .fillMaxWidth()
                                .height(50.dp),
                            colors = ButtonDefaults.buttonColors(
                                backgroundColor = Color(0xFF4E55D7),
                                contentColor = Color.White
                            ),
                            shape = RoundedCornerShape(15.dp),
                            onClick = {
                                Log.d("TAG-Login", "firstName = $firstName, password = $password")
                                firstName.replaceFirstChar{ it.uppercase() }
                                vm.logIn(firstName)
                            }
                        ) {
                            Text(
                                modifier = Modifier
                                    .fillMaxSize()
                                    .padding(vertical = 8.dp),
                                text = "Login",
                                fontFamily = FontFamily(Font(R.font.montserrat, FontWeight.Normal)),
                                fontWeight = FontWeight.W700,
                                fontSize = 14.sp,
                                lineHeight = (17.07).sp,
                                textAlign = TextAlign.Center,
                                letterSpacing = (-0.3).sp,
                                color = Color(0xFFEAEAEA)
                            )
                        }
                    }
                }

            }
        }

    }
}