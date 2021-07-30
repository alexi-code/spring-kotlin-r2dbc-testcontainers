package com.matcher.server.service

import com.matcher.server.model.dto.CertificateBundleDto
import com.matcher.server.model.dto.CertificateDto
import com.matcher.server.model.dto.CertificateSourceTypeDto
import reactor.core.publisher.Flux
import reactor.core.publisher.Mono

interface CertificateService {

    fun createCertificate(certificateDto: CertificateDto): Mono<CertificateDto>

    fun getAllCertificates(): Flux<CertificateDto>

    fun createCertificateBundle(certificateBundleDto: CertificateBundleDto): Mono<CertificateBundleDto>

    fun getAllCertificateBundles(): Flux<CertificateBundleDto>

    fun createSourceType(certificateSourceTypeDto: CertificateSourceTypeDto): Mono<CertificateSourceTypeDto>

    fun getAllTypes(): Flux<CertificateSourceTypeDto>

}
