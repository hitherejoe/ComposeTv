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
import java.net.URLEncoder

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
            val hesteURL = "https://open.smk.dk/shared-list?list=KMS1302,KMS4380,KMSsp522,KMS3418,KKS2012-71,KMS3608,KMS894,KMS868,KMS4568,KMS3402&list_title=null"
            val encodedUrl = URLEncoder.encode(hesteURL, "UTF-8")
            val hesteLink = "carousel_screen/$encodedUrl"
            Button(

                onClick = { navController.navigate(route = hesteLink) },
            ) {
                Text(
                    text = "Heste",
                    fontSize = MaterialTheme.typography.h3.fontSize,
                    fontWeight = FontWeight.Bold,
                )
            }
            val skovenURL = "https://open.smk.dk/shared-list?list=KMS4381,KMS1478,KMS8551,KMS6842,KMS7031,KMS719,KMS3209,KMS824,KKS9283a,KMS3657,KMS714,KMS6268,KMS4094,KMS611,KMS529,KMS413,KKSgb136,KMS6533&list_title=null"
            val encodedUrl1 = URLEncoder.encode(skovenURL, "UTF-8")
            val skovenLink = "carousel_screen/$encodedUrl1"

            Button(
                onClick = {navController.navigate(route = skovenLink)},
            ){
                Text(
                    text = "Skov",
                    fontSize = MaterialTheme.typography.h3.fontSize,
                    fontWeight = FontWeight.Bold,
                )
            }

            val sommerURL = "https://open.smk.dk/shared-list?list=KMS4138,KMS6856,KMS6655,KMS4126,KKS15460,KKS7936,KMS2075,KMS4209,KMS1658,KMS1568,KMS4928,KMS3120,KMS6340&list_title=null"
            val encodedUrl2 = URLEncoder.encode(sommerURL, "UTF-8")
            val sommerLink = "carousel_screen/$encodedUrl2"

            Button(
                onClick = {navController.navigate(route = sommerLink)},

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



