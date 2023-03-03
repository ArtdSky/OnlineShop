package com.example.onlineshop.presentation.screens

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.BottomNavigation
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
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
//            .verticalScroll(rememberScrollState())
                .fillMaxSize()

        ) {
            val brands = List(3) { index -> "Rectangle ${index + 1}" }
            val flashSales = List(2) { index -> "Rectangle ${index + 1}" }
            val latest = List(3) { index -> "Rectangle ${index + 1}" }



            Row(
                verticalAlignment = Alignment.Bottom,
                horizontalArrangement = Arrangement.SpaceBetween,
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(horizontal = 11.dp)
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
                contentPadding = PaddingValues(horizontal = 11.dp, vertical = 8.dp),
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
                    ) {

                    }

                }

            }
            Row(
                verticalAlignment = Alignment.Bottom,
                horizontalArrangement = Arrangement.SpaceBetween,
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(horizontal = 11.dp)
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
                contentPadding = PaddingValues(horizontal = 11.dp, vertical = 8.dp),
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

            Row(
                verticalAlignment = Alignment.Bottom,
                horizontalArrangement = Arrangement.SpaceBetween,
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(horizontal = 11.dp)
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