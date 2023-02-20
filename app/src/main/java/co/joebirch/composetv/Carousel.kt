package co.joebirch.composetv

import androidx.compose.animation.ContentTransform
import androidx.compose.animation.ExperimentalAnimationApi
import androidx.compose.animation.core.tween
import androidx.compose.animation.fadeIn
import androidx.compose.animation.fadeOut
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.tv.material3.Carousel
import androidx.tv.material3.CarouselState
import androidx.tv.material3.ExperimentalTvMaterial3Api
import co.joebirch.composetv.DataFactory.makeCarouselItem
import coil.compose.AsyncImage

@ExperimentalAnimationApi
@ExperimentalTvMaterial3Api
@Composable
fun HomeCarousel(
    modifier: Modifier = Modifier
) {
    val items = makeCarouselItem()
    val state = remember {
        CarouselState()
    }
    Carousel(
        modifier = modifier,
        carouselState = state,
        autoScrollDurationMillis = 7500,
        slideCount = items.count(),
        content = { index ->
            val item = items[index]
            val transform = ContentTransform(
                targetContentEnter = fadeIn(tween(durationMillis = 1000)),
                initialContentExit = fadeOut(tween(durationMillis = 1000))
            )
            CarouselItem(
                contentTransformForward = transform,
                contentTransformBackward = transform,
                background = {
                    AsyncImage(
                        item.image, null, contentScale = ContentScale.Crop
                    )
                },
                content = {
                    HomeItemBody(item)
                }
            )
        })
}

@Composable
fun HomeItemBody(item: TvItem) {
    Box(
        modifier = Modifier
            .fillMaxSize()
            .background(
                brush = Brush.linearGradient(
                    colors = listOf(
                        Color.Black.copy(alpha = 0.7f),
                        Color.Transparent
                    )
                )
            ), contentAlignment = Alignment.TopStart
    ) {
        Column(
            modifier = Modifier
                .padding(16.dp)
                .width(500.dp)
                .wrapContentHeight()
                .padding(16.dp)
        ) {
            Text(
                text = item.title, fontSize = 32.sp, color = Color.White
            )
            Spacer(modifier = Modifier.height(12.dp))
            Text(
                text = item.description,
                fontSize = 16.sp,
                maxLines = 3,
                overflow = TextOverflow.Ellipsis,
                color = Color.White
            )
            Spacer(modifier = Modifier.height(12.dp))
            Row {
                Text(
                    text = "Watch on: ",
                    fontSize = 14.sp,
                    color = Color.White,
                    fontWeight = FontWeight.Bold
                )
                Text(
                    text = item.watchOn, fontSize = 14.sp, color = Color.White
                )
            }
        }
    }
}