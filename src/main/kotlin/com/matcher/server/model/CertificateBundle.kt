package com.matcher.server.model

import org.hibernate.annotations.GenericGenerator
import org.springframework.data.relational.core.mapping.Table
import java.time.LocalDateTime
import java.util.*
import javax.persistence.*

@Table
@Entity
data class CertificateBundle(
    @Id
    @GeneratedValue(generator = "UUID")
    @GenericGenerator(name = "UUID", strategy = "org.hibernate.id.UUIDGenerator")
    var id: UUID?,
    @Column(name = "certificate_id")
    @ManyToOne
    var certificate: Certificate,
    var quantity: Int,
    var issuedAt: LocalDateTime,
    var issuedBy: String
    )
