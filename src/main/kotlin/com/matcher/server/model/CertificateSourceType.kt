package com.matcher.server.model

import org.springframework.data.relational.core.mapping.Table
import java.util.*
import javax.persistence.Entity
import javax.persistence.Id

@Entity
@Table
data class CertificateSourceType(
    @Id
    @org.springframework.data.annotation.Id
    val id: UUID?,
    var name: String
    ) {
}
