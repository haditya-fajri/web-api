package id.learn.web.api.repository

import id.learn.web.api.entity.Company
import org.springframework.data.jpa.repository.JpaRepository
import java.util.*

interface CompanyRepository : JpaRepository<Company,String> {
}