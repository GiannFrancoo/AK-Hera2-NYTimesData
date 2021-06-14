package ayds.jkhera2.nytimes.nytimes.external

import ayds.hera.songinfo.moredetails.model.entities.NYTArticle

interface NYTArticleService {
    fun getArticleInfo(nameOfArtist: String): NYTArticle?
}