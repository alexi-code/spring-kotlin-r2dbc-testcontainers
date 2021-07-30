package com.matcher.server.model

import org.hibernate.annotations.GenericGenerator
import org.springframework.data.relational.core.mapping.Table
import java.util.*
import javax.persistence.*

@Entity
// Spring's @Table to be visible for R2BDC Repositories
@Table
data class Certificate(
    @Id
    @GeneratedValue(generator = "UUID")
    @GenericGenerator(name = "UUID", strategy = "org.hibernate.id.UUIDGenerator")
    var id: UUID?,
    var name : String,
    @Column(name = "source_type")
    @ManyToOne
    var sourceType: CertificateSourceType
    ) {

}
