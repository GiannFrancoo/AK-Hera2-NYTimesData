package ayds.jkhera2.nytimes

import ayds.jkhera2.nytimes.entities.NYTArticle

interface NYTArticleService {
    fun getArticleInfo(nameOfArtist: String): NYTArticle?
}