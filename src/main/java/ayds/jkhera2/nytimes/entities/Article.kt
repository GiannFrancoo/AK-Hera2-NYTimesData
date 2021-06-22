package ayds.jkhera2.nytimes.entities

interface Article {
    val description: String
    val infoUrl: String
    val sourceLogoUrl: String
}

data class NYTArticle(
    override val description: String,
    override val infoUrl: String,
    override val sourceLogoUrl: String
) : Article

object EmptyArticle : Article {
    override val description: String = ""
    override val infoUrl: String = ""
    override val sourceLogoUrl: String = ""
}