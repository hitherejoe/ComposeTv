package co.joebirch.composetv

sealed class Screen(val route: String){
    object StartScreen : Screen(route = "start_screen")
    object CarouselScreen : Screen(route = "carousel_screen/{url}")


}
