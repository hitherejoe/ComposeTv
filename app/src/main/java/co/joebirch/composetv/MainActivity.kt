package co.joebirch.composetv

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.animation.ExperimentalAnimationApi
import androidx.navigation.NavController
import androidx.navigation.NavHostController
import androidx.navigation.compose.rememberNavController
import androidx.tv.material3.ExperimentalTvMaterial3Api

@ExperimentalTvMaterial3Api
@ExperimentalAnimationApi
class MainActivity : ComponentActivity() {

    lateinit var navController: NavHostController

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            navController = rememberNavController()
            SetupNavGraph(navController = navController)
        }
    }
}


/*
Todoliste:
        - skrive årstal + kunstner på slideshow (FÆRDIGGJORT)
        - refactoring: give bedre navne, fikse indrykning, etc.
        - en start-menu med en start-knap
        - i stedet for start-knap: tre playlister med hver sin knap (heste, skoven, sommer)
        - billeder skal fade sammen med tekst
        - bruge de store billeder, ikke thumbnails
        - main activity giver fejl: find ud af hvorfor + fiks det.
*/
