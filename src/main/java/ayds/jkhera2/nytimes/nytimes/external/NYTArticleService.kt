package ayds.jkhera2.nytimes.nytimes.external

import ayds.jkhera2.nytimes.nytimes.external.entities.NYTArticle

interface NYTArticleService {
    fun getArticleInfo(nameOfArtist: String): NYTArticle?
}