package id.learn.web.api.service

import id.learn.web.api.model.CompanyResponse
import id.learn.web.api.model.CreateCompanyRequest
import id.learn.web.api.model.UpdateCompanyRequest

interface CompanyService {

    fun create(createCompanyRequest: CreateCompanyRequest):CompanyResponse

    fun get(id:String):CompanyResponse

    fun update(id:String,updateCompanyRequest: UpdateCompanyRequest):CompanyResponse

    fun delete(id:String)
}