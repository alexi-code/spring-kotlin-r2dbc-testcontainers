package com.matcher.server.repository

import com.matcher.server.model.Certificate
import org.springframework.data.repository.reactive.ReactiveCrudRepository
import org.springframework.stereotype.Repository
import java.util.*

@Repository
interface CertificateRepository: ReactiveCrudRepository<Certificate, UUID> {

//    fun findAllByNameAnAndSourceType(name: String, sourceType: CertificateSourceType);

}
