package id.learn.web.api.controller

import id.learn.web.api.model.*
import id.learn.web.api.service.CompanyService
import kotlinx.serialization.encodeToString
import kotlinx.serialization.json.Json
import org.springframework.web.bind.annotation.*
import javax.servlet.http.HttpServletResponse

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
        value= ["/api/companies/{idCompany}"],
        produces = ["application/json"]
    )
    fun getCompany(@PathVariable("idCompany") id:String):WebResponse<CompanyResponse>{
        val companyResponse = companyService.get(id)

        return responseOk(companyResponse)
    }

    @PutMapping(
        value = ["/api/companies/{idCompany}"],
        produces = ["application/json"],
        consumes = ["application/json"]
    )
    fun updateCompany(@PathVariable("idCompany") id:String,
                      @RequestBody updateCompanyRequest: UpdateCompanyRequest):WebResponse<CompanyResponse>{
        val companyResponse = companyService.update(id,updateCompanyRequest)

        return responseOk(companyResponse)
    }

    @DeleteMapping(
        value = ["/api/companies/{idCompany}"],
        produces = ["application/json"]
    )
    fun deleteCompany(@PathVariable("idCompany") id: String):WebResponse<String>{
        companyService.delete(id)

        return  responseOk("DELETED")
    }

    @GetMapping(
        value =["/api/companies"],
        produces = ["application/json"]
    )
    fun listCompany(@RequestParam(value="page",defaultValue = "1") page:Int,
                    @RequestParam(value="size", defaultValue = "10") size:Int,
                    response:HttpServletResponse):WebResponse<List<CompanyResponse>>{

        val request = ListCompanyRequest(page,size)
        val pagedCompanyResponse = companyService.list(request)

        response.addHeader("X-Pagination", Json.encodeToString(pagedCompanyResponse.metaData))

        return  responseOk(pagedCompanyResponse.data)
    }

    private fun <T> responseOk(data:T):WebResponse<T>{
        return WebResponse(
            code = 200,
            status = "OK",
            data = data
        )
    }
}