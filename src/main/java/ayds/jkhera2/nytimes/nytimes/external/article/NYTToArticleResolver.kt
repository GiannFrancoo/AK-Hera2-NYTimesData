package ayds.jkhera2.nytimes.nytimes.external.article

import ayds.hera.songinfo.moredetails.model.entities.NYTArticle
import com.google.gson.Gson
import com.google.gson.JsonObject

interface NYTToArticleResolver {
    fun getArticleFromExternalData(serviceData: String?): NYTArticle?
}

private const val RESPONSE = "response"
private const val DOCS = "docs"
private const val ABSTRACT = "abstract"
private const val WEB_URL = "web_url"
private const val NO_RESULTS = "No Results"

internal class JsonToArticleResolver : NYTToArticleResolver {

    override fun getArticleFromExternalData(serviceData: String?): NYTArticle? =
        try {
            serviceData?.getFirstItem()?.let { item ->
                NYTArticle(
                    item.getAbstractFormatted(),
                    item.getWebURL()
                )
            }
        } catch (e: Exception) {
            null
        }

    private fun String?.getFirstItem(): JsonObject {
        val jsonObject = Gson().fromJson(this, JsonObject::class.java)
        return jsonObject[RESPONSE].asJsonObject
    }

    private fun JsonObject.getAbstractFormatted(): String {
        val abstractJsonElement = this[ayds.jkhera2.nytimes.nytimes.article.DOCS].asJsonArray[0].asJsonObject[ayds.jkhera2.nytimes.nytimes.article.ABSTRACT]
        abstractJsonElement?.let {
            return cleanEnterOfAbstract(it.toString())
        }?:run {return ayds.jkhera2.nytimes.nytimes.article.NO_RESULTS }
    }

    private fun cleanEnterOfAbstract(abstract: String): String{
        return abstract.replace("\\n", "\n")
    }

    private fun JsonObject.getWebURL(): String {
        val webUrl = this[ayds.jkhera2.nytimes.nytimes.article.DOCS].asJsonArray[0].asJsonObject[ayds.jkhera2.nytimes.nytimes.article.WEB_URL]
        return webUrl.asString
    }

}