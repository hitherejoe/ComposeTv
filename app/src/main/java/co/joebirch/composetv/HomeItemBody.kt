package co.joebirch.composetv
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.style.TextAlign

import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

@Composable
fun HomeItemBody(item: TvItem) {
    Box(
        modifier = Modifier.fillMaxSize(),
    ) {
        Column(
            modifier = Modifier
                .padding(16.dp)
                .wrapContentWidth()
                .wrapContentHeight()
                .background(color= Color.DarkGray)
                .align(Alignment.BottomCenter)
        ) {
            Text(
                text = item.title + " (${item.year})", fontSize = 20.sp, color = Color.White,
            )
            Text(
                text = item.artist, fontSize = 16.sp, color = Color.White, fontStyle = FontStyle.Italic,
            )
        }
    }
}