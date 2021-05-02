package id.learn.web.api.model

import javax.validation.constraints.NotBlank
import javax.validation.constraints.Size

data class UpdateCompanyRequest (

    @field:NotBlank
    @field:Size(min=5,max = 60)
    val name:String?,

    @field:NotBlank
    @field:Size(min = 5, max = 50)
    val address:String?,

    @field:NotBlank
    val country:String?
)