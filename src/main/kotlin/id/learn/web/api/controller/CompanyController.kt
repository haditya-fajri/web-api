package id.learn.web.api.controller

import id.learn.web.api.model.CompanyResponse
import id.learn.web.api.model.CreateCompanyRequest
import id.learn.web.api.model.WebResponse
import id.learn.web.api.service.CompanyService
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RestController

@RestController
class CompanyController(val companyService: CompanyService) {

    @PostMapping(
        value = ["/api/companies"],
        produces = ["application/json"],
        consumes = ["application/json"]
    )
    fun createCompany(@RequestBody createCompanyRequest: CreateCompanyRequest):WebResponse<CompanyResponse>{
        val companyResponse = companyService.create(createCompanyRequest)

        return WebResponse(
            code = 200,
            status = "OK",
            data = companyResponse
        )
    }
}