package co.joebirch.composetv

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.material.Button
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.rememberNestedScrollInteropConnection
import androidx.compose.ui.platform.testTag
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController

@Composable
fun StartButton(
    navController: NavController
) {

    Box(
        modifier = Modifier.fillMaxSize(),
        contentAlignment = Alignment.Center,
    ){
        Column(

        ){
            Button(
                onClick = {navController.navigate(route = "carousel_screen/" + "https://open.smk.dk/shared-list?list=KMS1302,KMS4380,KMSsp522,KMS3418,KKS2012-71,KMS3608,KMS894,KMS868,KMS4568,KMS3402&list_title=null")},
            ){
                Text(
                    text = "Heste",
                    fontSize = MaterialTheme.typography.h3.fontSize,
                    fontWeight = FontWeight.Bold,
                )
            }

            Button(
                onClick = {navController.navigate(route = Screen.CarouselScreen.route)},
            ){
                Text(
                    text = "Skov",
                    fontSize = MaterialTheme.typography.h3.fontSize,
                    fontWeight = FontWeight.Bold,
                )
            }

            Button(
                onClick = {navController.navigate(route = Screen.CarouselScreen.route)},

            ){
                Text(
                    text = "Sommer",
                    fontSize = MaterialTheme.typography.h3.fontSize,
                    fontWeight = FontWeight.Bold,
                )
            }
        }
    }
}
@Composable
@Preview(showBackground = true)
fun StartPreview() {
    StartButton(
        navController = rememberNavController()
    )
}



