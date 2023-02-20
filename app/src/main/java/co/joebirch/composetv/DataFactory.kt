package co.joebirch.composetv

object DataFactory {

    fun makeCarouselItem(): List<TvItem> {
        return listOf(
            TvItem("Iron Man", "After being held captive in an Afghan cave, billionaire engineer Tony Stark creates a unique weaponized suit of armor to fight evil.", "Netflix", "https://image.tmdb.org/t/p/original/cyecB7godJ6kNHGONFjUyVN9OX5.jpg"),
            TvItem("Thor", "Against his father Odin's will, The Mighty Thor - a powerful but arrogant warrior god - recklessly reignites an ancient war. Thor is cast down to Earth and forced to live among humans as punishment. Once here, Thor learns what it takes to be a true hero when the most dangerous villain of his world sends the darkest forces of Asgard to invade Earth.", "Netflix, Amazon Prime", "https://www.themoviedb.org/t/p/original/1wOu8rdvPxU1ObHi20VcRhfNpbo.jpg"),
            TvItem("Spider-Man: No Way Home", "Peter Parker is unmasked and no longer able to separate his normal life from the high-stakes of being a super-hero. When he asks for help from Doctor Strange the stakes become even more dangerous, forcing him to discover what it truly means to be Spider-Man.", "Disney+","https://www.themoviedb.org/t/p/original/14QbnygCuTO0vl7CAFmPf1fgZfV.jpg"),
            TvItem("Black Panther", "King T'Challa returns home to the reclusive, technologically advanced African nation of Wakanda to serve as his country's new leader. However, T'Challa soon finds that he is challenged for the throne by factions within his own country as well as without. Using powers reserved to Wakandan kings, T'Challa assumes the Black Panther mantle to join with ex-girlfriend Nakia, the queen-mother, his princess-kid sister, members of the Dora Milaje (the Wakandan 'special forces') and an American secret agent, to prevent Wakanda from being dragged into a world war.", "Disney+","https://www.themoviedb.org/t/p/original/b6ZJZHUdMEFECvGiDpJjlfUWela.jpg"),
            TvItem("Captain America: Civil War", "Following the events of Age of Ultron, the collective governments of the world pass an act designed to regulate all superhuman activity. This polarizes opinion amongst the Avengers, causing two factions to side with Iron Man or Captain America, which causes an epic battle between former allies.", "Netflix","https://www.themoviedb.org/t/p/original/uXzQDq63nkrRbj2sl0OFJWmOPZg.jpg")
        )
    }
}