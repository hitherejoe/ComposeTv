package co.joebirch.composetv

class DataParser {
    // input a shareable 'favorite list' from SMK Open
    // example: https://open.smk.dk/shared-list?list=KMS5807,KMSsp731,KMS7980&list_title=hestehoved%20123
     fun getObjectIDs(listUrl: String): ArrayList<String> {
        val objectIDs = ArrayList<String>()
        val objects = listUrl.split("[,=&]".toRegex())
        for (obj in objects) {
            if (obj.startsWith("KMS") || obj.startsWith("KKS") || obj.startsWith("KAS")) { // Det er ikke alle objekter der starter med 'KMS'. Så vi skal gøre det på en anden måde. :-)
                objectIDs.add("https://api.smk.dk/api/v1/art/?object_number=$obj")
            }
        }
        return objectIDs
    }

    fun getPublicArtOnly(listUrl: String): ArrayList<String> {
        val objectIDs = getObjectIDs(listUrl)
        for (`object` in objectIDs) {
            if (isCopyrighted(`object`)) objectIDs.remove(`object`)
        }
        return objectIDs
    }

    private fun isCopyrighted(objectID: String): Boolean {
        //TODO: Implement a check for copyright in the JSON object
        return true
    }
}