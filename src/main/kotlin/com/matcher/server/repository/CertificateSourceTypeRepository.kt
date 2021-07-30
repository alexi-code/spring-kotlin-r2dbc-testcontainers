package com.matcher.server.repository

import com.matcher.server.model.CertificateSourceType
import org.springframework.data.r2dbc.repository.R2dbcRepository
import org.springframework.data.repository.reactive.ReactiveCrudRepository
import org.springframework.stereotype.Repository
import reactor.core.publisher.Mono
import java.util.*

@Repository
interface CertificateSourceTypeRepository: ReactiveCrudRepository<CertificateSourceType, UUID> {

    fun findFirstByName(name: String): Mono<CertificateSourceType>

}
