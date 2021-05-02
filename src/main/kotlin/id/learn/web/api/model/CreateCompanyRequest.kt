package id.learn.web.api.model

import javax.validation.constraints.NotBlank
import javax.validation.constraints.Size

data class CreateCompanyRequest (

    @field:NotBlank
    @field:Size(min=5,max=60)
    val name:String?,

    @field:NotBlank
    @field:Size(min=5,max=60)
    val address:String?,

    @field:NotBlank
    @field:Size(min=5)
    val country:String?
)