package id.learn.web.api.model

data class PagedList<T> (

    val data:List<T>,

    val metaData: MetaData

)
