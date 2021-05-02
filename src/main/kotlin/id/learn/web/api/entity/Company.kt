package id.learn.web.api.entity

import java.util.*
import javax.persistence.Column
import javax.persistence.Entity
import javax.persistence.Id
import javax.persistence.Table

@Entity
@Table(name="companies")
data class Company (

    @Id
    @Column(name="id",unique = true,length = 36)
    val id : String = UUID.randomUUID().toString(),

    @Column(name="name",length = 60)
    var name: String,

    @Column(name="address",length = 60)
    var address : String,

    @Column(name="country")
    var country: String,

    @Column(name="created_at")
    var createdAt : Date,

    @Column(name="updated_at")
    var updatedAt : Date?
)