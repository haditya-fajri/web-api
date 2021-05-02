package id.learn.web.api.service

import id.learn.web.api.model.CompanyResponse
import id.learn.web.api.model.CreateCompanyRequest

interface CompanyService {

    fun create(createCompanyRequest: CreateCompanyRequest):CompanyResponse

    fun get(id:String):CompanyResponse
}