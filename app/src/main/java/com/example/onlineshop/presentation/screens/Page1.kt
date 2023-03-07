package com.example.onlineshop.presentation.screens

import android.util.Log
import androidx.compose.foundation.*
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.SpanStyle
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.buildAnnotatedString
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.withStyle
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController
import coil.compose.AsyncImage
import coil.request.ImageRequest
import com.example.onlineshop.R
import com.example.onlineshop.presentation.navigation.AppDestination
import com.example.onlineshop.presentation.screens.components.BottomItems
import com.example.onlineshop.presentation.viewmodel.MainViewModel

@Composable
fun Page1(
    navController: NavHostController,
    currentScreen: AppDestination,
    vm: MainViewModel
) {
    vm.getData()
    val state by vm.viewState.collectAsState()


    Box(
        modifier = Modifier
//            .verticalScroll(rememberScrollState())
            .fillMaxSize()
    ) {
        var searchText by remember { mutableStateOf("") }

        val brands = List(3) { index -> "Rectangle ${index + 1}" }
        val flashSales = state.flashSales
        val latest = state.latest



        Column(
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Center,
            modifier = Modifier
                .verticalScroll(rememberScrollState())
                .fillMaxSize()
                .padding(horizontal = 15.dp, vertical = 24.dp)


        ) {


/////////////Top-bar
            Row(
                verticalAlignment = Alignment.CenterVertically,
                horizontalArrangement = Arrangement.SpaceBetween,
                modifier = Modifier
                    .fillMaxWidth()
            ) {
                Image(
                    painter = painterResource(id = R.drawable.menu),
                    contentDescription = "Menu",
                    modifier = Modifier.size(22.dp)
                )
                Text(
                    text = buildAnnotatedString {
                        append("Trade by ")
                        withStyle(style = SpanStyle(color = Color(0xFF4E55D7))) {
                            append("bata")
                        }
                    },
                    fontFamily = FontFamily(Font(R.font.montserrat)),
                    fontWeight = FontWeight.W700,
                    fontSize = 20.sp,
                    lineHeight = (24).sp,
                    letterSpacing = (-0.3).sp,
                    color = Color(0xFF000000)
                )
                Column(
                    verticalArrangement = Arrangement.Center,
                    horizontalAlignment = Alignment.CenterHorizontally,
                    modifier = Modifier.padding(top = 12.dp)
                ) {
                    Box(
                        modifier = Modifier
                            .size(32.dp)
                    ) {
                        Image(
                            painter = painterResource(id = R.drawable.black_cat),
                            contentDescription = "avatar",
                            contentScale = ContentScale.Crop,
                            modifier = Modifier
                                .fillMaxSize()
                                .clip(CircleShape)
                                .border(
                                    width = 1.dp,
                                    color = Color(0xFF4E4D4D),
                                    shape = CircleShape
                                )
                        )
                    }
                    Row(
                        verticalAlignment = Alignment.CenterVertically,
                        horizontalArrangement = Arrangement.Center,
                        modifier = Modifier
                    ) {
                        Text(
                            text = "Location",
                            fontFamily = FontFamily(Font(R.font.poppins)),
                            fontWeight = FontWeight.W400,
                            fontSize = 10.sp,
                            lineHeight = (15).sp,
                            letterSpacing = (-0.3).sp,
                            color = Color(0xFF5B5B5B)
                        )
                        Spacer(modifier = Modifier.height(7.dp))
                        Image(
                            painter = painterResource(id = R.drawable.arrow_down),
                            contentDescription = "search image",
                            modifier = Modifier.size(8.dp)
                        )
                    }

                }
            }

/////////////Search-bar
            Spacer(modifier = Modifier.height(10.dp))
            Box(
                contentAlignment = Alignment.Center,
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(horizontal = 56.dp)
                    .height(43.dp),
            ) {
                TextField(
                    modifier = Modifier
                        .fillMaxSize(),
                    value = searchText,
                    onValueChange = { searchText = it },
                    singleLine = true,
                    shape = RoundedCornerShape(15.dp),
                    textStyle = TextStyle(fontSize = 9.sp, lineHeight = 13.sp),
                    placeholder = {
                        Row(
                            modifier = Modifier
                                .fillMaxSize(),
                            verticalAlignment = Alignment.CenterVertically,
                            horizontalArrangement = Arrangement.SpaceBetween
                        ) {
                            Text(
                                modifier = Modifier
                                    .weight(1f),
                                text = "What are you looking for?",
                                fontFamily = FontFamily(Font(R.font.poppins)),
                                fontWeight = FontWeight.W400,
                                fontSize = 9.sp,
                                lineHeight = (13.5).sp,
                                textAlign = TextAlign.Center,
                                letterSpacing = (-0.3).sp,
                                color = Color(0xFF5B5B5B)
                            )
                            Image(
                                painter = painterResource(id = R.drawable.search),
                                contentDescription = "search image",
                                modifier = Modifier.size(12.dp)
                            )
                        }
                    },
                    colors = TextFieldDefaults.textFieldColors(
                        backgroundColor = Color(0xFFF5F6F7),
                        unfocusedIndicatorColor = Color.Transparent,
                    )
                )
            }
/////////////Menu
            Row(
                verticalAlignment = Alignment.Bottom,
                horizontalArrangement = Arrangement.SpaceBetween,
                modifier = Modifier
                    .fillMaxWidth()
            ) {
                Column(
                    horizontalAlignment = Alignment.CenterHorizontally,
                    verticalArrangement = Arrangement.Center
                ) {
                    Box(
                        modifier = Modifier
                            .size(42.dp)
                            .clip(CircleShape)
                            .background(Color(0xFFEEEFF4))
                            .align(Alignment.CenterHorizontally)
                    ) {
                        Image(
                            painter = painterResource(id = R.drawable.phone),
                            contentDescription = "Phones",
                            contentScale = ContentScale.Fit,
                            modifier = Modifier
                                .size(20.dp)
                                .align(Alignment.Center)
                        )
                    }
                    Spacer(modifier = Modifier.height(11.dp))
                    Text(
                        text = "Phones",
                        fontFamily = FontFamily(Font(R.font.poppins)),
                        fontWeight = FontWeight.W500,
                        lineHeight = (12).sp,
                        fontSize = 8.sp,
                        letterSpacing = (-0.3).sp,
                        color = Color(0xff808080),
                        textAlign = TextAlign.Center
                    )
                }
                Column(
                    horizontalAlignment = Alignment.CenterHorizontally,
                    verticalArrangement = Arrangement.Center
                ) {
                    Box(
                        modifier = Modifier
                            .size(42.dp)
                            .clip(CircleShape)
                            .background(Color(0xFFEEEFF4))
                            .align(Alignment.CenterHorizontally)
                    ) {
                        Image(
                            painter = painterResource(id = R.drawable.headphone),
                            contentDescription = "Headphones",
                            contentScale = ContentScale.Fit,
                            modifier = Modifier
                                .size(20.dp)
                                .align(Alignment.Center)
                        )
                    }
                    Spacer(modifier = Modifier.height(11.dp))
                    Text(
                        text = "Headphones",
                        fontFamily = FontFamily(Font(R.font.poppins)),
                        fontWeight = FontWeight.W500,
                        lineHeight = (12).sp,
                        fontSize = 8.sp,
                        letterSpacing = (-0.3).sp,
                        color = Color(0xff808080),
                        textAlign = TextAlign.Center
                    )
                }
                Column(
                    horizontalAlignment = Alignment.CenterHorizontally,
                    verticalArrangement = Arrangement.Center
                ) {
                    Box(
                        modifier = Modifier
                            .size(42.dp)
                            .clip(CircleShape)
                            .background(Color(0xFFEEEFF4))
                            .align(Alignment.CenterHorizontally)
                    ) {
                        Image(
                            painter = painterResource(id = R.drawable.games),
                            contentDescription = "Games",
                            contentScale = ContentScale.Fit,
                            modifier = Modifier
                                .size(20.dp)
                                .align(Alignment.Center)
                        )
                    }
                    Spacer(modifier = Modifier.height(11.dp))
                    Text(
                        text = "Games",
                        fontFamily = FontFamily(Font(R.font.poppins)),
                        fontWeight = FontWeight.W500,
                        lineHeight = (12).sp,
                        fontSize = 8.sp,
                        letterSpacing = (-0.3).sp,
                        color = Color(0xff808080),
                        textAlign = TextAlign.Center
                    )
                }
                Column(
                    horizontalAlignment = Alignment.CenterHorizontally,
                    verticalArrangement = Arrangement.Center
                ) {
                    Box(
                        modifier = Modifier
                            .size(42.dp)
                            .clip(CircleShape)
                            .background(Color(0xFFEEEFF4))
                            .align(Alignment.CenterHorizontally)
                    ) {
                        Image(
                            painter = painterResource(id = R.drawable.car),
                            contentDescription = "Cars",
                            contentScale = ContentScale.Fit,
                            modifier = Modifier
                                .size(20.dp)
                                .align(Alignment.Center)
                        )
                    }
                    Spacer(modifier = Modifier.height(11.dp))
                    Text(
                        text = "Cars",
                        fontFamily = FontFamily(Font(R.font.poppins)),
                        fontWeight = FontWeight.W500,
                        lineHeight = (12).sp,
                        fontSize = 8.sp,
                        letterSpacing = (-0.3).sp,
                        color = Color(0xff808080),
                        textAlign = TextAlign.Center
                    )
                }
                Column(
                    horizontalAlignment = Alignment.CenterHorizontally,
                    verticalArrangement = Arrangement.Center
                ) {
                    Box(
                        modifier = Modifier
                            .size(42.dp)
                            .clip(CircleShape)
                            .background(Color(0xFFEEEFF4))
                            .align(Alignment.CenterHorizontally)
                    ) {
                        Image(
                            painter = painterResource(id = R.drawable.furniture),
                            contentDescription = "Furniture",
                            contentScale = ContentScale.Fit,
                            modifier = Modifier
                                .size(20.dp)
                                .align(Alignment.Center)
                        )
                    }
                    Spacer(modifier = Modifier.height(11.dp))
                    Text(
                        text = "Furniture",
                        fontFamily = FontFamily(Font(R.font.poppins)),
                        fontWeight = FontWeight.W500,
                        lineHeight = (12).sp,
                        fontSize = 8.sp,
                        letterSpacing = (-0.3).sp,
                        color = Color(0xff808080),
                        textAlign = TextAlign.Center
                    )
                }
                Column(
                    horizontalAlignment = Alignment.CenterHorizontally,
                    verticalArrangement = Arrangement.Center
                ) {
                    Box(
                        modifier = Modifier
                            .size(42.dp)
                            .clip(CircleShape)
                            .background(Color(0xFFEEEFF4))
                            .align(Alignment.CenterHorizontally)
                    ) {
                        Image(
                            painter = painterResource(id = R.drawable.kids),
                            contentDescription = "Kids",
                            contentScale = ContentScale.Fit,
                            modifier = Modifier
                                .size(20.dp)
                                .align(Alignment.Center)
                        )
                    }
                    Spacer(modifier = Modifier.height(11.dp))
                    Text(
                        text = "Kids",
                        fontFamily = FontFamily(Font(R.font.poppins)),
                        fontWeight = FontWeight.W500,
                        lineHeight = (12).sp,
                        fontSize = 8.sp,
                        letterSpacing = (-0.3).sp,
                        color = Color(0xff808080),
                        textAlign = TextAlign.Center
                    )
                }
            }
////////////Latest
            Spacer(modifier = Modifier.height(29.dp))
            Row(
                verticalAlignment = Alignment.Bottom,
                horizontalArrangement = Arrangement.SpaceBetween,
                modifier = Modifier
                    .fillMaxWidth()
            ) {
                Text(
                    text = "Latest",
                    fontFamily = FontFamily(Font(R.font.poppins)),
                    fontWeight = FontWeight.W500,
                    fontSize = 15.sp,
                    letterSpacing = (-0.3).sp,
                    lineHeight = (22.5).sp,
                    color = Color(0xff040402)
                )
                Text(
                    text = "View all",
                    fontFamily = FontFamily(Font(R.font.poppins)),
                    fontWeight = FontWeight.W500,
                    lineHeight = (13.5).sp,
                    fontSize = 9.sp,
                    letterSpacing = (-0.3).sp,
                    color = Color(0xff808080)
                )
            }
            LazyRow(
                contentPadding = PaddingValues(vertical = 8.dp),
                horizontalArrangement = Arrangement.spacedBy(12.dp),
                verticalAlignment = Alignment.CenterVertically
            ) {
                items(latest.size) {
                    Card(
                        modifier = Modifier
                            .width(114.dp)
                            .height(149.dp)
                            .clip(RoundedCornerShape(9.dp))
                            .background(Color.Black)
                    ) {
                        Box(
                            modifier = Modifier
                                .fillMaxSize()
                        ) {
                            AsyncImage(
                                model = ImageRequest.Builder(LocalContext.current)
                                    .data(latest[it].image_url)
                                    .build(),
                                contentDescription = latest[it].name,
                                contentScale = ContentScale.Crop,
                                modifier = Modifier
                                    .clickable(onClick = {
                                        Log.d("TAG-page1", "${latest[it].name} CLICKED")
                                    })
                                    .align(Alignment.CenterStart)
                                    .fillMaxSize(),
                            )
                            Column(
                                verticalArrangement = Arrangement.Bottom,
                                horizontalAlignment = Alignment.Start,
                                modifier = Modifier
                                    .fillMaxHeight()
                                    .width(75.dp)
                                    .padding(start = 7.dp)
                            ) {
                                Text(
                                    text = latest[it].category,
                                    fontFamily = FontFamily(Font(R.font.poppins)),
                                    fontWeight = FontWeight.W600,
                                    fontSize = 6.sp,
                                    letterSpacing = (-0.3).sp,
                                    lineHeight = (9).sp,
                                    color = Color(0xFF070604),
                                    textAlign = TextAlign.Center,
                                    modifier = Modifier
                                        .clip(RoundedCornerShape(9.dp))
                                        .width(35.dp)
                                        .height(12.dp)
                                        .background(Color(0xFFc4c4c4))
                                )
                                Text(
                                    text = latest[it].name,
                                    fontFamily = FontFamily(Font(R.font.poppins)),
                                    fontWeight = FontWeight.W600,
                                    fontSize = 9.sp,
                                    letterSpacing = (-0.3).sp,
                                    lineHeight = (13.5).sp,
                                    color = Color(0xFFFFFFFF),
                                    modifier = Modifier.padding(top = 4.dp)
                                )
                                Text(
                                    text = "$ ${latest[it].price}",
                                    fontFamily = FontFamily(Font(R.font.poppins)),
                                    fontWeight = FontWeight.W600,
                                    fontSize = 10.sp,
                                    letterSpacing = (-0.3).sp,
                                    lineHeight = (19.5).sp,
                                    color = Color(0xFFFFFFFF),
                                    modifier = Modifier.padding(top = 2.dp)
                                )
                            }
                            Row(
                                verticalAlignment = Alignment.Bottom,
                                horizontalArrangement = Arrangement.End,
                                modifier = Modifier
                                    .padding(bottom = 7.dp, end = 4.dp)
                                    .fillMaxSize()
                            ) {
                                Box(
                                    modifier = Modifier
                                        .size(20.dp)
                                        .clip(CircleShape)
                                        .background(Color(0xFFEEEFF4))
                                        .clickable(onClick = {
                                            Log.d(
                                                "TAG-page1",
                                                "${latest[it].name} ADD CLICKED"
                                            )
                                        })
                                ) {
                                    Image(
                                        painter = painterResource(id = R.drawable.add),
                                        contentDescription = "add",
                                        contentScale = ContentScale.Fit,
                                        modifier = Modifier
                                            .size(10.dp)
                                            .align(Alignment.Center)

                                    )
                                }
                            }
                        }
                    }
                }

            }
////////////Flash Sale
            Spacer(modifier = Modifier.height(17.dp))
            Row(
                verticalAlignment = Alignment.Bottom,
                horizontalArrangement = Arrangement.SpaceBetween,
                modifier = Modifier
                    .fillMaxWidth()
            ) {
                Text(
                    text = "Flash Sale",
                    fontFamily = FontFamily(Font(R.font.poppins)),
                    fontWeight = FontWeight.W500,
                    fontSize = 15.sp,
                    letterSpacing = (-0.3).sp,
                    lineHeight = (22.5).sp,
                    color = Color(0xff040402)
                )
                Text(
                    text = "View all",
                    fontFamily = FontFamily(Font(R.font.poppins)),
                    fontWeight = FontWeight.W500,
                    lineHeight = (13.5).sp,
                    fontSize = 9.sp,
                    letterSpacing = (-0.3).sp,
                    color = Color(0xff808080)
                )
            }
            LazyRow(
                contentPadding = PaddingValues(vertical = 8.dp),
                horizontalArrangement = Arrangement.spacedBy(9.dp),
                verticalAlignment = Alignment.CenterVertically
            ) {
                items(flashSales.size) {
                    Card(
                        shape = RoundedCornerShape(11.dp),
                        modifier = Modifier
                            .width(174.dp)
                            .height(221.dp)

                    ) {
                        Box(
                            modifier = Modifier
                                .fillMaxSize()
                        ) {
                            AsyncImage(
                                model = ImageRequest.Builder(LocalContext.current)
                                    .data(flashSales[it].image_url)
                                    .build(),
                                contentDescription = flashSales[it].name,
                                contentScale = ContentScale.Crop,
                                modifier = Modifier
                                    .clickable(onClick = {
                                        Log.d("TAG-page1", "${flashSales[it].name} CLICKED")
                                    })
                                    .align(Alignment.CenterStart)
                                    .fillMaxSize(),
                            )
                            Row(
                                verticalAlignment = Alignment.Top,
                                horizontalArrangement = Arrangement.SpaceBetween,
                                modifier = Modifier
                                    .fillMaxSize()
                                    .padding(7.dp)
                            ) {
                                Image(
                                    painter = painterResource(id = R.drawable.black_cat),
                                    contentDescription = "Seller",
                                    modifier = Modifier
                                        .size(25.dp)
                                        .clip(CircleShape)
                                )

                                Text(
                                    text = "${flashSales[it].discount}% off",
                                    fontFamily = FontFamily(Font(R.font.poppins)),
                                    fontWeight = FontWeight.W600,
                                    fontSize = 10.sp,
                                    letterSpacing = (-0.3).sp,
                                    lineHeight = (15).sp,
                                    color = Color(0xFFFFFFFF),
                                    textAlign = TextAlign.Center,
                                    modifier = Modifier
                                        .clip(RoundedCornerShape(9.dp))
                                        .width(49.dp)
                                        .height(18.dp)
                                        .background(Color(0xFFF93A3A))
                                )
                            }
                            Column(
                                verticalArrangement = Arrangement.Bottom,
                                horizontalAlignment = Alignment.Start,
                                modifier = Modifier
                                    .fillMaxHeight()
                                    .width(87.dp)
                                    .padding(start = 10.dp)
                            ) {
                                Text(
                                    text = flashSales[it].category,
                                    fontFamily = FontFamily(Font(R.font.poppins)),
                                    fontWeight = FontWeight.W600,
                                    fontSize = 9.sp,
                                    letterSpacing = (-0.3).sp,
                                    lineHeight = (13.5).sp,
                                    color = Color(0xFF070604),
                                    textAlign = TextAlign.Center,
                                    modifier = Modifier
                                        .clip(RoundedCornerShape(9.dp))
                                        .width(49.dp)
                                        .height(17.dp)
                                        .background(Color(0xFFc4c4c4))
                                )
                                Text(
                                    text = flashSales[it].name,
                                    fontFamily = FontFamily(Font(R.font.poppins)),
                                    fontWeight = FontWeight.W600,
                                    fontSize = 13.sp,
                                    letterSpacing = (-0.3).sp,
                                    lineHeight = (19.5).sp,
                                    color = Color(0xFFFFFFFF),
                                    modifier = Modifier.padding(top = 6.dp)
                                )
                                Text(
                                    text = "$ ${flashSales[it].price}",
                                    fontFamily = FontFamily(Font(R.font.poppins)),
                                    fontWeight = FontWeight.W600,
                                    fontSize = 10.sp,
                                    letterSpacing = (-0.3).sp,
                                    lineHeight = (19.5).sp,
                                    color = Color(0xFFFFFFFF),
                                    modifier = Modifier.padding(top = 12.dp)
                                )
                            }
                            Row(
                                verticalAlignment = Alignment.Bottom,
                                horizontalArrangement = Arrangement.End,
                                modifier = Modifier
                                    .padding(bottom = 7.dp, end = 4.dp)
                                    .fillMaxSize()
                            ) {
                                Box(
                                    modifier = Modifier
                                        .size(28.dp)
                                        .clip(CircleShape)
                                        .background(Color(0xFFEEEFF4))
                                        .clickable(onClick = {
                                            Log.d(
                                                "TAG-page1",
                                                "${flashSales[it].name} LIKE CLICKED"
                                            )
                                        })
                                ) {
                                    Image(
                                        painter = painterResource(id = R.drawable.favorites),
                                        contentDescription = "like",
                                        contentScale = ContentScale.Fit,
                                        modifier = Modifier
                                            .size(10.dp)
                                            .align(Alignment.Center)
                                    )
                                }
                                Box(
                                    modifier = Modifier
                                        .size(35.dp)
                                        .clip(CircleShape)
                                        .background(Color(0xFFEEEFF4))
                                        .padding(4.dp)
                                        .clickable(onClick = {
                                            Log.d(
                                                "TAG-page1",
                                                "${flashSales[it].name} ADD CLICKED"
                                            )
                                        })
                                ) {
                                    Image(
                                        painter = painterResource(id = R.drawable.add),
                                        contentDescription = "Profile Image",
                                        contentScale = ContentScale.Fit,
                                        modifier = Modifier
                                            .size(13.dp)
                                            .align(Alignment.Center)
                                    )
                                }
                            }
                        }
                    }
                }


            }
////////////Brands
            Spacer(modifier = Modifier.height(17.dp))
            Row(
                verticalAlignment = Alignment.Bottom,
                horizontalArrangement = Arrangement.SpaceBetween,
                modifier = Modifier
                    .fillMaxWidth()
            ) {
                Text(
                    text = "Brands",
                    fontFamily = FontFamily(Font(R.font.poppins)),
                    fontWeight = FontWeight.W500,
                    fontSize = 15.sp,
                    letterSpacing = (-0.3).sp,
                    lineHeight = (22.5).sp,
                    color = Color(0xff040402)
                )
                Text(
                    text = "View all",
                    fontFamily = FontFamily(Font(R.font.poppins)),
                    fontWeight = FontWeight.W500,
                    lineHeight = (13.5).sp,
                    fontSize = 9.sp,
                    letterSpacing = (-0.3).sp,
                    color = Color(0xff808080)
                )
            }
            LazyRow(
                contentPadding = PaddingValues(horizontal = 11.dp, vertical = 8.dp),
                horizontalArrangement = Arrangement.spacedBy(12.dp),
                verticalAlignment = Alignment.Bottom
            ) {

                items(brands.size) { brand ->
                    Box(
                        modifier = Modifier
                            .width(114.dp)
                            .height(149.dp)
                            .clip(RoundedCornerShape(9.dp))
                            .background(Color.Black)
                    )
                }
            }
            Spacer(modifier = Modifier.height(42.dp))
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