package com.example.onlineshop.presentation.screens

import androidx.compose.foundation.*
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.BottomNavigation
import androidx.compose.material.Text
import androidx.compose.material.TextField
import androidx.compose.material.TextFieldDefaults
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
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
import com.example.onlineshop.R
import com.example.onlineshop.presentation.utils.BottomItems

@Composable
fun Page1() {
    Box(
        modifier = Modifier
//            .verticalScroll(rememberScrollState())
            .fillMaxSize()
    ) {


        Column(
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Center,
            modifier = Modifier
                .verticalScroll(rememberScrollState())
                .fillMaxSize()
                .padding(horizontal = 15.dp, vertical = 24.dp)


        ) {
            val brands = List(3) { index -> "Rectangle ${index + 1}" }
            val flashSales = List(2) { index -> "Rectangle ${index + 1}" }
            val latest = List(3) { index -> "Rectangle ${index + 1}" }
            var searchText by remember { mutableStateOf("") }


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
                items(latest.size) { lates ->
                    Box(
                        modifier = Modifier
                            .width(114.dp)
                            .height(149.dp)
                            .clip(RoundedCornerShape(9.dp))
                            .background(Color.Black)
                    )

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
                items(flashSales.size) { flashSale ->
                    Box(
                        modifier = Modifier
                            .width(174.dp)
                            .height(221.dp)
                            .clip(RoundedCornerShape(11.dp))
                            .background(Color.Black)
                    ) {

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
            BottomItems()
        }
    }
}