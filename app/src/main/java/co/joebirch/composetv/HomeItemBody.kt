package co.joebirch.composetv
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

@Composable
fun HomeItemBody(item: TvItem) {
    Box(
        modifier = Modifier.fillMaxSize(),
        contentAlignment = Alignment.BottomStart
    ) {
        Column(
            modifier = Modifier
                .padding(16.dp)
                .wrapContentWidth()
                .wrapContentHeight()
                .background(color= Color.DarkGray)
        ) {
            Text(
                text = item.title, fontSize = 20.sp, color = Color.White,
            )
        }
    }
}