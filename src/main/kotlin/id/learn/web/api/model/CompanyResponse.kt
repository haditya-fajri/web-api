package id.learn.web.api.model

import java.util.*

data class CompanyResponse (

    val id : String,

    val name:String,

    val address:String,

    val country:String,

    val createdAt:Date,

    val updatedAt:Date?,

)