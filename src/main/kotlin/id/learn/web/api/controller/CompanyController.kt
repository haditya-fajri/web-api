package id.learn.web.api.controller

import id.learn.web.api.model.CompanyResponse
import id.learn.web.api.model.CreateCompanyRequest
import id.learn.web.api.model.UpdateCompanyRequest
import id.learn.web.api.model.WebResponse
import id.learn.web.api.service.CompanyService
import org.springframework.web.bind.annotation.*

@RestController
class CompanyController(val companyService: CompanyService) {

    @PostMapping(
        value = ["/api/companies"],
        produces = ["application/json"],
        consumes = ["application/json"]
    )
    fun createCompany(@RequestBody createCompanyRequest: CreateCompanyRequest):WebResponse<CompanyResponse>{
        val companyResponse = companyService.create(createCompanyRequest)

        return responseOk(companyResponse)
    }

    @GetMapping(
        value= ["/api/companies/{idCompanies}"],
        produces = ["application/json"]
    )
    fun getCompany(@PathVariable("idCompanies") id:String):WebResponse<CompanyResponse>{
        val companyResponse = companyService.get(id)

        return responseOk(companyResponse)
    }

    @PutMapping(
        value = ["/api/companies/{idCompanies}"],
        produces = ["application/json"],
        consumes = ["application/json"]
    )
    fun updateCompany(@PathVariable("idCompanies") id:String,
                      @RequestBody updateCompanyRequest: UpdateCompanyRequest):WebResponse<CompanyResponse>{
        val companyResponse = companyService.update(id,updateCompanyRequest)

        return responseOk(companyResponse)
    }

    private fun <T> responseOk(data:T):WebResponse<T>{
        return WebResponse(
            code = 200,
            status = "OK",
            data = data
        )
    }
}