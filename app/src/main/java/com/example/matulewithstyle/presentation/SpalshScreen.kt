package com.example.matulewithstyle.presentation

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.input.pointer.PointerIcon.Companion.Text
import androidx.compose.ui.res.fontResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import kotlinx.coroutines.delay

@Composable
fun Splash_Screen(navController: NavController,onTimeout: () -> Unit) {
    LaunchedEffect(Unit) {
        delay(3000)
        onTimeout()
        navController.navigate("onBoarding")
    }
    var colorList = listOf(
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
            modifier = Modifier
                .fillMaxSize(),
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Center
        ){
            Row(
            ){
                Text(
                    text = "MATULE",
                    fontWeight = FontWeight.Black,
                    fontSize = 42.sp,
                    color = Color.White
                )
                Text(
                    text = "ME",
                    fontSize = 25.sp,
                    color = Color.White,
                )
            }
        }
    }
}