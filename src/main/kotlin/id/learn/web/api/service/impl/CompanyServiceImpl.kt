package id.learn.web.api.service.impl

import id.learn.web.api.entity.Company
import id.learn.web.api.exception.NotFoundException
import id.learn.web.api.model.*
import id.learn.web.api.repository.CompanyRepository
import id.learn.web.api.service.CompanyService
import id.learn.web.api.validation.ValidationUtil
import org.springframework.data.domain.PageRequest
import org.springframework.data.repository.findByIdOrNull
import org.springframework.stereotype.Service
import java.util.*
import java.util.stream.Collectors.toList

@Service
class CompanyServiceImpl(val companyRepository: CompanyRepository,
                         val validationUtil: ValidationUtil): CompanyService {
    override fun create(createCompanyRequest: CreateCompanyRequest): CompanyResponse {
        validationUtil.validate(createCompanyRequest)

        val company = Company(
            name = createCompanyRequest.name!!,
            address = createCompanyRequest.address!!,
            country = createCompanyRequest.country!!,
            createdAt = Date(),
            updatedAt = null
        )

        companyRepository.save(company)

        return convertCompanyToCompanyResponse(company)
    }

    override fun get(id: String): CompanyResponse {
        val company = companyRepository.findByIdOrNull(id) ?: throw NotFoundException()

        return convertCompanyToCompanyResponse(company)
    }

    override fun update(id: String, updateCompanyRequest: UpdateCompanyRequest): CompanyResponse {
        validationUtil.validate(updateCompanyRequest)

        val company = companyRepository.findByIdOrNull(id) ?: throw NotFoundException()

        company.apply {
            name = updateCompanyRequest.name!!
            address =updateCompanyRequest.address!!
            country = updateCompanyRequest.country!!
            updatedAt = Date()
        }

        companyRepository.save(company)

        return  convertCompanyToCompanyResponse(company)
    }

    override fun delete(id: String) {
        val company = companyRepository.findByIdOrNull(id) ?: throw NotFoundException()

        companyRepository.delete(company)
    }

    override fun list(listCompanyRequest: ListCompanyRequest): PagedList<CompanyResponse> {
        val page = companyRepository.findAll(PageRequest.of(listCompanyRequest.page-1, listCompanyRequest.size))
        val metaData = MetaData(
            totalData = page.totalElements,
            totalPage = page.totalPages,
            page = listCompanyRequest.page,
            size = listCompanyRequest.size,
            hasPrevious = listCompanyRequest.page>1,
            hasNext = listCompanyRequest.page < page.totalPages
        )
        val products = page.get().collect(toList())

        return PagedList(
            data = products.map { convertCompanyToCompanyResponse(it) },
            metaData = metaData
        )
    }

    private fun convertCompanyToCompanyResponse(company: Company):CompanyResponse{
        return CompanyResponse(
            id = company.id,
            name = company.name,
            address = company.address,
            country = company.country,
            createdAt = company.createdAt,
            updatedAt = company.updatedAt
        )
    }
}