package co.joebirch.composetv

import androidx.compose.animation.ExperimentalAnimationApi
import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.navArgument
import androidx.tv.material3.Carousel
import androidx.tv.material3.ExperimentalTvMaterial3Api

@OptIn(ExperimentalAnimationApi::class, ExperimentalTvMaterial3Api::class)
@Composable
fun SetupNavGraph(
    navController: NavHostController
){
    NavHost(
        navController = navController,
        startDestination = Screen.StartScreen.route,
    ){
        composable(
            route = Screen.StartScreen.route,
        ){
            StartButton(navController)
        }
        composable(
            route = Screen.CarouselScreen.route,
        ){
            HomeCarousel()
        }
    }
}