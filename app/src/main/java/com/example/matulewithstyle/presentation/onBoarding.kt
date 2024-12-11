package com.example.matulewithstyle.presentation

import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Arrangement
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
import androidx.compose.foundation.pager.HorizontalPager
import androidx.compose.foundation.pager.PagerState
import androidx.compose.foundation.pager.rememberPagerState
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.ImageBitmap
import androidx.compose.ui.graphics.RectangleShape
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.imageResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.example.matulewithstyle.R

@OptIn(ExperimentalFoundationApi::class)
@Composable
fun OnBoarding(navController: NavController) {
    val pagerState = rememberPagerState(initialPage = 0, pageCount = { 3 })
    val colorList = listOf(
        Color(72, 178, 231),
        Color(0, 118, 177)
    )
    Box(
        modifier = Modifier
            .fillMaxSize()
            .background(
                brush = Brush.linearGradient(
                    colorList,
                    start = Offset.Zero,
                    end = Offset.Infinite
                )
            )
    ){
        Column(
            modifier = Modifier.fillMaxSize()
        ) {
            HorizontalPager(
                state = pagerState,
                modifier = Modifier.weight(1f)
            ) { page ->
                when (page) {
                    0 -> Screen1(navController)
                    1 -> Screen2(navController)
                    2 -> Screen3(navController)
                }
            }
            Spacer(modifier = Modifier.height(16.dp))
            IndicatorDots(pagerState)
        }
    }
}
@OptIn(ExperimentalFoundationApi::class)
@Composable
fun IndicatorDots(pagerState: PagerState) {
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .padding(16.dp),
        horizontalArrangement = Arrangement.Center,
        verticalAlignment = Alignment.CenterVertically
    ) {
        val totalPages = 3
        for (i in 0 until totalPages) {
            val color = if (i == pagerState.currentPage) colorResource(R.color.purple_700) else Color.White
            DotIndicator(color = color)
            Spacer(modifier = Modifier.width(8.dp))
        }
    }
}

@Composable
fun DotIndicator(color: Color) {
    Box(
        modifier = Modifier
            .height(8.dp)
            .width(25.dp)
            .padding(2.dp)
            .background(color = color, shape = RectangleShape)
    )
}

@Composable
fun Screen1(navController: NavController) {
    Column(
        modifier = Modifier
            .fillMaxSize(),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.SpaceBetween // Space between content and button
    ) {
        Column(
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Top
        ) {
            Row(
                modifier = Modifier
                    .padding(40.dp)
            ) {
                Text(
                    text = "ДОБРО\nПОЖАЛОВАТЬ",
                    color = Color.White,
                    fontWeight = FontWeight.Black,
                    fontSize = 40.sp,
                    textAlign = TextAlign.Center,
                    lineHeight = 30.sp
                )
            }
            Spacer(modifier = Modifier.height(100.dp)) // Space between text and image
            Image(
                bitmap = ImageBitmap.imageResource(R.drawable.image_1),
                contentDescription = "",
                modifier = Modifier
                    .size(500.dp)
            )
        }

        // Button at the bottom
        Button(
            onClick = {
                navController.navigate("login")
            },
            modifier = Modifier
                .fillMaxWidth()
                .padding(30.dp),
            colors = ButtonDefaults.buttonColors(
                containerColor = Color.White,
                contentColor = Color.Black,
            )
        ) {
            Text(
                text = "Начать"
            )
        }
    }
}

@Composable
fun Screen2(navController: NavController) {
    Column(
        modifier = Modifier
            .fillMaxSize(),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.SpaceBetween // Space between content and button
    ) {
        Column(
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Top
        ) {
            Image(
                bitmap = ImageBitmap.imageResource(R.drawable.image_2),
                contentDescription = "",
                modifier = Modifier
                    .size(500.dp)
            )
            Text(
                text = "Начнем\nпутешествие",
                fontSize = 40.sp,
                color = Color.White,
                fontWeight = FontWeight.Black,
                textAlign = TextAlign.Center,
                lineHeight = 30.sp
            )
            Spacer(modifier = Modifier.height(10.dp))
            Text(
                text = "Умная, великолепная и модная\nколлекция Изучите сейчас",
                fontSize = 20.sp,
                color = Color.LightGray,
                textAlign = TextAlign.Center,
            )
        }

        // Button at the bottom
        Button(
            onClick = {
                navController.navigate("login")
            },
            modifier = Modifier
                .fillMaxWidth()
                .padding(30.dp),
            colors = ButtonDefaults.buttonColors(
                containerColor = Color.White,
                contentColor = Color.Black,
            )
        ) {
            Text(
                text = "Далее"
            )
        }
    }
}

@Composable
fun Screen3(navController: NavController) {
    Column(
        modifier = Modifier
            .fillMaxSize(),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.SpaceBetween // Space between content and button
    ) {
        Column(
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Top
        ) {
            Image(
                bitmap = ImageBitmap.imageResource(R.drawable.image_3),
                contentDescription = "",
                modifier = Modifier
                    .size(500.dp)
            )
            Text(
                text = "У Вас Есть Сила,\nЧтобы",
                fontSize = 40.sp,
                color = Color.White,
                fontWeight = FontWeight.Black,
                textAlign = TextAlign.Center,
                lineHeight = 30.sp
            )
            Spacer(modifier = Modifier.height(10.dp))
            Text(
                text = "В вашей комнате много красивых\nи привлекательных растений",
                fontSize = 20.sp,
                color = Color.LightGray,
                textAlign = TextAlign.Center,
            )
        }

        // Button at the bottom
        Button(
            onClick = {
                navController.navigate("login")
            },
            modifier = Modifier
                .fillMaxWidth()
                .padding(30.dp),
            colors = ButtonDefaults.buttonColors(
                containerColor = Color.White,
                contentColor = Color.Black,
            )
        ) {
            Text(
                text = "Далее"
            )
        }
    }
}
