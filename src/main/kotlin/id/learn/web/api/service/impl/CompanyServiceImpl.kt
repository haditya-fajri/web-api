package id.learn.web.api.service.impl

import id.learn.web.api.entity.Company
import id.learn.web.api.exception.NotFoundException
import id.learn.web.api.model.CompanyResponse
import id.learn.web.api.model.CreateCompanyRequest
import id.learn.web.api.model.UpdateCompanyRequest
import id.learn.web.api.repository.CompanyRepository
import id.learn.web.api.service.CompanyService
import id.learn.web.api.validation.ValidationUtil
import org.springframework.data.repository.findByIdOrNull
import org.springframework.stereotype.Service
import java.util.*

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