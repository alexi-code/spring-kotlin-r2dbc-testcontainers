package com.matcher.server.repository

import com.matcher.server.model.CertificateBundle
import org.springframework.data.repository.reactive.ReactiveCrudRepository
import org.springframework.stereotype.Repository
import java.util.*

@Repository
interface CertificateBundleRepository: ReactiveCrudRepository<CertificateBundle, UUID> {


}
