package co.joebirch.composetv

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.animation.ExperimentalAnimationApi
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.sp
import androidx.tv.material3.ExperimentalTvMaterial3Api
import androidx.tv.material3.Text

@ExperimentalTvMaterial3Api
@ExperimentalAnimationApi
class MainActivity : ComponentActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            HomeCarousel(
                modifier = Modifier.fillMaxSize()
            )
        }
    }
}

/*
Todoliste:
        - skrive årstal + kunstner på slideshow
        - refactoring: give bedre navne, fikse indrykning, etc.
        - en start-menu med en start-knap
        - i stedet for start-knap: tre playlister med hver sin knap (heste, skoven, sommer)
        - billeder skal fade sammen med tekst
        - bruge de store billeder, ikke thumbnails
        - main activity giver fejl: find ud af hvorfor + fiks det.
*/
