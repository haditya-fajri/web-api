package id.learn.web.api.service.impl

import id.learn.web.api.entity.Company
import id.learn.web.api.model.CompanyResponse
import id.learn.web.api.model.CreateCompanyRequest
import id.learn.web.api.repository.CompanyRepository
import id.learn.web.api.service.CompanyService
import id.learn.web.api.validation.ValidationUtil
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