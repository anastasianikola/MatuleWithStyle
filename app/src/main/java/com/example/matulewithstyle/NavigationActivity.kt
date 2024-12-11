package com.example.matulewithstyle

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.NavController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.matulewithstyle.presentation.Login
import com.example.matulewithstyle.presentation.Splash_Screen
import com.example.matulewithstyle.presentation.OnBoarding
import com.example.matulewithstyle.ui.theme.MatuleWithStyleTheme
import kotlinx.coroutines.delay

class NavigationActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            MatuleWithStyleTheme {
                val navController = rememberNavController()
                var isSplashScreenVisible by remember { mutableStateOf(true) }
                if (isSplashScreenVisible) {
                    Splash_Screen(
                        navController = navController,
                        onTimeout = { isSplashScreenVisible = false }
                    )
                }
                NavHost(navController = navController, startDestination = "splash_screen")
                {
                    composable("splash_screen"){
                        Splash_Screen(navController, onTimeout = {})
                    }
                    composable("onBoarding"){
                        OnBoarding(navController)
                    }
                    composable("login"){
                        Login(navController)
                    }
                }

            }
        }
    }
}

