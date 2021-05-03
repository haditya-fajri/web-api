package id.learn.web.api.model

import kotlinx.serialization.Serializable

@Serializable
data class MetaData (

    val page:Int,

    val totalPage:Int,

    val size:Int,

    val totalData:Long,

    val hasPrevious:Boolean,

    val hasNext:Boolean
)