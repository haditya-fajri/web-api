package id.learn.web.api.service

import id.learn.web.api.model.*

interface CompanyService {

    fun create(createCompanyRequest: CreateCompanyRequest):CompanyResponse

    fun get(id:String):CompanyResponse

    fun update(id:String,updateCompanyRequest: UpdateCompanyRequest):CompanyResponse

    fun delete(id:String)

    fun list(listCompanyRequest: ListCompanyRequest): PagedList<CompanyResponse>
}