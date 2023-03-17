package co.joebirch.composetv
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext
import org.json.JSONException
import org.json.JSONObject
import java.io.IOException
import java.net.URL

object DataFactory{
    private fun getObjectsArray(favList: String): ArrayList<String> {
        val dataParser = DataParser()
        // Indsæt delbart link til SMK Open spilleliste:
        val listURL = "https://open.smk.dk/shared-list?list=KMS1302,KMS4380,KMSsp522,KMS3418,KKS2012-71,KMS3608,KMS894,KMS868,KMS4568,KMS3402&list_title=null"
        return dataParser.getObjectIDs(favList)

    }

    private suspend fun getTitle(objectId: String): String? {
        return withContext(Dispatchers.IO) {
            try {
                val url = URL(objectId)
                val connection = url.openConnection()
                connection.connect()
                val response = connection.getInputStream().bufferedReader().use { it.readText() }
                val jsonObject = JSONObject(response)
                jsonObject.getJSONArray("items")
                    .getJSONObject(0)
                    .getJSONArray("titles")
                    .getJSONObject(0)
                    .getString("title")
            } catch (e: IOException) {
                e.printStackTrace()
                null
            } catch (e: JSONException) {
                e.printStackTrace()
                null
            }
        }
    }
    private suspend fun getImage(objectId: String): String? {
        return withContext(Dispatchers.IO) {
            try {
                val url = URL(objectId)
                val connection = url.openConnection()
                connection.connect()
                val response = connection.getInputStream().bufferedReader().use { it.readText() }
                val jsonObject = JSONObject(response)
                jsonObject.getJSONArray("items")
                    .getJSONObject(0)
                    .getString("image_thumbnail")
            } catch (e: IOException) {
                e.printStackTrace()
                null
            } catch (e: JSONException) {
                e.printStackTrace()
                null
            }
        }
    }

    private suspend fun getArtist(objectId: String): String? {
        return withContext(Dispatchers.IO) {
            try {
                val url = URL(objectId)
                val connection = url.openConnection()
                connection.connect()
                val response = connection.getInputStream().bufferedReader().use { it.readText() }
                val jsonObject = JSONObject(response)
                jsonObject.getJSONArray("items")
                    .getJSONObject(0)
                    .getJSONArray("artist")
                    .getString(0)
            } catch (e: IOException) {
                e.printStackTrace()
                null
            } catch (e: JSONException) {
                e.printStackTrace()
                null
            }
        }
    }

    private suspend fun getYear(objectId: String): String? {
        return withContext(Dispatchers.IO) {
            try {
                val url = URL(objectId)
                val connection = url.openConnection()
                connection.connect()
                val response = connection.getInputStream().bufferedReader().use { it.readText() }
                val jsonObject = JSONObject(response)
                jsonObject.getJSONArray("items")
                    .getJSONObject(0)
                    .getJSONArray("production_date")
                    .getJSONObject(0)
                    .getString("period")
            } catch (e: IOException) {
                e.printStackTrace()
                null
            } catch (e: JSONException) {
                e.printStackTrace()
                null
            }
        }
    }


    suspend fun makeCarouselItem(favList: String): List<TvItem> = withContext(Dispatchers.IO) {
        val objectIDs = getObjectsArray(favList)
        val tvItems = mutableListOf<TvItem>()

        for (objectId in objectIDs) {
            val title = getTitle(objectId)
            val image = getImage(objectId)
            val artist = getArtist(objectId)
            val year = getYear(objectId)

            if (title != null && image != null && year != null && artist!=null) {
                tvItems.add(TvItem(title, image, artist, year))
            }
        }

        return@withContext tvItems
    }
}