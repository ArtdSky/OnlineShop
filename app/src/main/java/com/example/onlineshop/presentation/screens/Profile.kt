package com.example.onlineshop.presentation.screens

import android.util.Log
import androidx.compose.foundation.*
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
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
import com.example.onlineshop.presentation.navigation.ProfileScreen
import com.example.onlineshop.presentation.navigation.navigateSingleTopTo
import com.example.onlineshop.presentation.screens.components.BottomItems

@Composable
fun Profile(
    navController: NavHostController,
    currentScreen: AppDestination,
) {
    Box(
        modifier = Modifier
            .fillMaxSize()
    ) {
        Column(
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Center,
            modifier = Modifier
                .verticalScroll(rememberScrollState())
                .fillMaxSize()
        ) {

            Row(
                verticalAlignment = Alignment.CenterVertically,
                horizontalArrangement = Arrangement.SpaceBetween,
                modifier = Modifier
                    .padding(top = 30.dp)
                    .fillMaxWidth()
            ) {
                IconButton(
                    onClick = {
                        Log.d(
                            "TAG-Profile-Arrow",
                            "${currentScreen.route}  CLICKED"
                        )
                        navController.navigateSingleTopTo(Page1Screen.route)
                    },
                    modifier = Modifier
                        .padding(start = 20.dp)
                        .size(24.dp)
                ) {
                    Icon(
                        imageVector = Icons.Default.ArrowBack,
                        contentDescription = "Back",
                        tint = Color.Black,
                        modifier = Modifier.size(24.dp)
                    )
                }

                Text(
                    text = "Profile",
                    fontFamily = FontFamily(Font(R.font.montserrat)),
                    fontWeight = FontWeight.W700,
                    fontSize = 15.sp,
                    lineHeight = (18.29).sp,
                    letterSpacing = (-0.3).sp,
                    textAlign = TextAlign.Center,
                    modifier = Modifier
                        .weight(1f)
                        .padding(end = 36.dp)
                )
            }
            Box(
                contentAlignment = Alignment.TopCenter,
                modifier = Modifier
                    .fillMaxSize()
            ) {
                Column(
                    horizontalAlignment = Alignment.CenterHorizontally,
                    verticalArrangement = Arrangement.Center
                ) {

                    Spacer(modifier = Modifier.height(20.dp))
                    Box {
                        Image(
                            painter = painterResource(id = R.drawable.black_cat),
                            contentDescription = "avatar",
                            contentScale = ContentScale.Crop,
                            modifier = Modifier
                                .size(62.dp)
                                .clip(CircleShape)
                        )
                    }
                    Spacer(modifier = Modifier.height(6.dp))
                    Text(
                        text = "Change photo",
                        fontFamily = FontFamily(Font(R.font.montserrat)),
                        fontWeight = FontWeight.W500,
                        fontSize = 8.sp,
                        lineHeight = (9.75).sp,
                        letterSpacing = (-0.3).sp,
                        textAlign = TextAlign.Center
                    )
                    Spacer(modifier = Modifier.height(17.dp))
                    Text(
                        text = "Satria Adhi Pradana",
                        fontFamily = FontFamily(Font(R.font.montserrat)),
                        fontWeight = FontWeight.W700,
                        fontSize = 15.sp,
                        lineHeight = (18.29).sp,
                        letterSpacing = (-0.3).sp,
                        textAlign = TextAlign.Center
                    )
                    Spacer(modifier = Modifier.height(36.dp))
                    Button(
                        onClick = {
                            Log.d("TAG=Profile", "Button: Upload item")
                        },
                        colors = ButtonDefaults.outlinedButtonColors(
                            backgroundColor = Color(0xFF4E55D7),
                            contentColor = Color(0xFFEAEAEA)
                        ),
                        shape = RoundedCornerShape(15.dp),
                        modifier = Modifier
                            .width(290.dp)
                            .height(40.dp)
                    ) {
                        Row(
                            modifier = Modifier.fillMaxSize(),
                            horizontalArrangement = Arrangement.SpaceEvenly,
                            verticalAlignment = Alignment.CenterVertically
                        ) {
                            Image(
                                painter = painterResource(id = R.drawable.upload),
                                contentDescription = "avatar",
                                modifier = Modifier
                                    .size(15.dp)
                                    .weight(1f)
                            )
                            Text(
                                modifier = Modifier
                                    .weight(2f),
                                text = "Upload item",
                                fontFamily = FontFamily(Font(R.font.montserrat)),
                                fontWeight = FontWeight.W600,
                                fontSize = 14.sp,
                                lineHeight = (17.07).sp,
                                letterSpacing = (-0.3).sp,
                            )
                        }
                    }
                    Spacer(modifier = Modifier.height(14.dp))
                }
            }

            Column(
                modifier = Modifier
                    .fillMaxSize()
                    .padding(start = 40.dp, end = 40.dp, bottom = 82.dp),
                verticalArrangement = Arrangement.Bottom,
                horizontalAlignment = Alignment.CenterHorizontally,
            ) {
                Box(
                    modifier = Modifier
                        .fillMaxWidth(),
                    contentAlignment = Alignment.TopStart
                ) {
                    Row(
                        horizontalArrangement = Arrangement.Center,
                        verticalAlignment = Alignment.CenterVertically
                    ) {
                        Box(
                            modifier = Modifier
                                .size(40.dp)
                                .clip(CircleShape)
                                .background(Color(0xFFEEEFF4))
                                .align(Alignment.CenterVertically)
                        ) {
                            Image(
                                painter = painterResource(id = R.drawable.credit_card),
                                contentDescription = "Trade store",
                                modifier = Modifier
                                    .size(24.dp)
                                    .align(Alignment.Center)
                            )
                        }
                        Spacer(modifier = Modifier.width(6.dp))
                        Text(
                            text = "Trade store",
                            modifier = Modifier
                                .weight(1f)
                        )
                        Image(
                            painter = painterResource(id = R.drawable.arrow),
                            contentDescription = "Arrow",
                            modifier = Modifier
                                .height(10.dp)
                                .width(6.dp)
                        )
                    }
                }
                Spacer(modifier = Modifier.height(25.dp))
                Box(
                    modifier = Modifier
                        .fillMaxWidth(),
                    contentAlignment = Alignment.TopStart
                ) {
                    Row(
                        horizontalArrangement = Arrangement.Center,
                        verticalAlignment = Alignment.CenterVertically
                    ) {
                        Box(
                            modifier = Modifier
                                .size(40.dp)
                                .clip(CircleShape)
                                .background(Color(0xFFEEEFF4))
                                .align(Alignment.CenterVertically)
                        ) {
                            Image(
                                painter = painterResource(id = R.drawable.credit_card),
                                contentDescription = "Payment method",
                                modifier = Modifier
                                    .size(24.dp)
                                    .align(Alignment.Center)
                            )
                        }
                        Spacer(modifier = Modifier.width(6.dp))
                        Text(
                            text = "Payment method",
                            modifier = Modifier
                                .weight(1f)
                        )
                        Image(
                            painter = painterResource(id = R.drawable.arrow),
                            contentDescription = "Arrow",
                            modifier = Modifier
                                .height(10.dp)
                                .width(6.dp)
                        )
                    }
                }
                Spacer(modifier = Modifier.height(25.dp))
                Box(
                    modifier = Modifier
                        .fillMaxWidth(),
                    contentAlignment = Alignment.TopStart
                ) {
                    Row(
                        horizontalArrangement = Arrangement.Center,
                        verticalAlignment = Alignment.CenterVertically
                    ) {
                        Box(
                            modifier = Modifier
                                .size(40.dp)
                                .clip(CircleShape)
                                .background(Color(0xFFEEEFF4))
                                .align(Alignment.CenterVertically)
                        ) {
                            Image(
                                painter = painterResource(id = R.drawable.credit_card),
                                contentDescription = "Balance",
                                modifier = Modifier
                                    .size(24.dp)
                                    .align(Alignment.Center)
                            )
                        }
                        Spacer(modifier = Modifier.width(6.dp))
                        Text(
                            text = "Balance",
                            modifier = Modifier
                                .weight(1f)
                        )
                        Text(
                            text = "$ 1593",
                            fontFamily = FontFamily(Font(R.font.montserrat)),
                            fontSize = 14.sp,
                            fontWeight = FontWeight.W500,
                            lineHeight = (17.07).sp,
                            letterSpacing = (-0.3).sp,
                            textAlign = TextAlign.Center
                        )

                    }
                }
                Spacer(modifier = Modifier.height(25.dp))
                Box(
                    modifier = Modifier
                        .fillMaxWidth(),
                    contentAlignment = Alignment.TopStart
                ) {
                    Row(
                        horizontalArrangement = Arrangement.Center,
                        verticalAlignment = Alignment.CenterVertically
                    ) {
                        Box(
                            modifier = Modifier
                                .size(40.dp)
                                .clip(CircleShape)
                                .background(Color(0xFFEEEFF4))
                                .align(Alignment.CenterVertically)
                        ) {
                            Image(
                                painter = painterResource(id = R.drawable.credit_card),
                                contentDescription = "Trade history",
                                modifier = Modifier
                                    .size(24.dp)
                                    .align(Alignment.Center)
                            )
                        }
                        Spacer(modifier = Modifier.width(6.dp))
                        Text(
                            text = "Trade history",
                            modifier = Modifier
                                .weight(1f)
                        )
                        Image(
                            painter = painterResource(id = R.drawable.arrow),
                            contentDescription = "Arrow",
                            modifier = Modifier
                                .height(10.dp)
                                .width(6.dp)
                        )
                    }
                }
                Spacer(modifier = Modifier.height(25.dp))
                Box(
                    modifier = Modifier
                        .fillMaxWidth(),
                    contentAlignment = Alignment.TopStart
                ) {
                    Row(
                        horizontalArrangement = Arrangement.Center,
                        verticalAlignment = Alignment.CenterVertically
                    ) {
                        Box(
                            modifier = Modifier
                                .size(40.dp)
                                .clip(CircleShape)
                                .background(Color(0xFFEEEFF4))
                                .align(Alignment.CenterVertically)
                        ) {
                            Image(
                                painter = painterResource(id = R.drawable.restore),
                                contentDescription = "Restore purchase",
                                modifier = Modifier
                                    .size(24.dp)
                                    .align(Alignment.Center)
                            )
                        }
                        Spacer(modifier = Modifier.width(6.dp))
                        Text(
                            text = "Restore Purchase",
                            modifier = Modifier
                                .weight(1f)
                        )
                        Image(
                            painter = painterResource(id = R.drawable.arrow),
                            contentDescription = "Arrow",
                            modifier = Modifier
                                .height(10.dp)
                                .width(6.dp)
                        )
                    }
                }
                Spacer(modifier = Modifier.height(25.dp))
                Box(
                    modifier = Modifier
                        .fillMaxWidth(),
                    contentAlignment = Alignment.TopStart
                ) {
                    Row(
                        horizontalArrangement = Arrangement.Center,
                        verticalAlignment = Alignment.CenterVertically
                    ) {
                        Box(
                            modifier = Modifier
                                .size(40.dp)
                                .clip(CircleShape)
                                .background(Color(0xFFEEEFF4))
                                .align(Alignment.CenterVertically)
                        ) {
                            Image(
                                painter = painterResource(id = R.drawable.help),
                                contentDescription = "Help",
                                modifier = Modifier
                                    .size(24.dp)
                                    .align(Alignment.Center)
                            )
                        }
                        Spacer(modifier = Modifier.width(6.dp))
                        Text(
                            text = "Help",
                            modifier = Modifier
                                .weight(1f)
                        )
                    }
                }
                Spacer(modifier = Modifier.height(25.dp))
                Box(
                    modifier = Modifier
                        .fillMaxWidth(),
                    contentAlignment = Alignment.TopStart
                ) {
                    Row(
                        horizontalArrangement = Arrangement.Center,
                        verticalAlignment = Alignment.CenterVertically
                    ) {
                        Box(
                            modifier = Modifier
                                .size(40.dp)
                                .clip(CircleShape)
                                .background(Color(0xFFEEEFF4))
                                .align(Alignment.CenterVertically)
                        ) {
                            Image(
                                painter = painterResource(id = R.drawable.log_out),
                                contentDescription = "Log out",
                                modifier = Modifier
                                    .size(24.dp)
                                    .align(Alignment.Center)
                            )
                        }
                        Spacer(modifier = Modifier.width(6.dp))
                        Text(
                            text = "Log out",
                            modifier = Modifier
                                .weight(1f)
                        )
                    }
                }
            }
        }


        BottomNavigation(
            modifier = Modifier
                .align(Alignment.BottomCenter)
                .height(63.dp)
        ) {
            BottomItems(
                navController = navController,
                currentScreen = currentScreen,
            )
        }
    }
}

