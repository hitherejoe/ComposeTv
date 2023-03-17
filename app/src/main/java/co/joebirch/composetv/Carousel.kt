package co.joebirch.composetv

import android.annotation.SuppressLint
import androidx.compose.animation.ContentTransform
import androidx.compose.animation.ExperimentalAnimationApi
import androidx.compose.animation.core.tween
import androidx.compose.animation.fadeIn
import androidx.compose.animation.fadeOut
import androidx.compose.foundation.layout.BoxScope
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.tv.material3.Carousel
import androidx.tv.material3.CarouselDefaults
import androidx.tv.material3.CarouselState
import androidx.tv.material3.ExperimentalTvMaterial3Api
import co.joebirch.composetv.DataFactory.makeCarouselItem
import coil.compose.AsyncImage

@SuppressLint("ComposableNaming")
@Preview
@ExperimentalAnimationApi
@ExperimentalTvMaterial3Api
@Composable
fun HomeCarousel(url: String,
    modifier: Modifier = Modifier
) {
    var items by remember { mutableStateOf(emptyList<TvItem>()) }

    LaunchedEffect(Unit) {
        items = makeCarouselItem(url)
    }

    val state = remember {
        CarouselState()
    }

    Carousel(
        modifier = modifier,
        carouselState = state,
        autoScrollDurationMillis = 3500,
        carouselIndicator = {
            CarouselDefaults.IndicatorRow(
                slideCount = 0,
                activeSlideIndex = 0)},
        slideCount = items.count(),
        content = { index ->
            val transform = ContentTransform(
                targetContentEnter = fadeIn(tween(durationMillis = 1000)),
                initialContentExit = fadeOut(tween(durationMillis = 1000))
            )
            items[index].also { item ->
                CarouselItem(
                    contentTransformForward = transform,
                    contentTransformBackward = transform,
                    background = {
                        AsyncImage(
                            item.image,
                            null,
                            modifier = Modifier.fillMaxSize(),
                        )
                    },
                    content = {
                        HomeItemBody(item)
                    }
                )
            }
        }
    )

}
