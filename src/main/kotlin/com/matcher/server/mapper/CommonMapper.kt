package com.matcher.server.mapper

import com.matcher.server.model.Certificate
import com.matcher.server.model.CertificateBundle
import com.matcher.server.model.CertificateSourceType
import com.matcher.server.model.dto.CertificateBundleDto
import com.matcher.server.model.dto.CertificateDto
import com.matcher.server.model.dto.CertificateSourceTypeDto
import org.mapstruct.Mapper
import reactor.core.publisher.Flux
import reactor.core.publisher.Mono

@Mapper
interface CommonMapper {

    fun toDto(certificate: Certificate): CertificateDto
    fun toCertificate(certificateDto: CertificateDto): Certificate

    fun toDto(certificateBundle: CertificateBundle): CertificateBundleDto
    fun toCertificateBundle(certificateBundleDto: CertificateBundleDto): CertificateBundle

    fun toDto(certificateSourceType: CertificateSourceType): CertificateSourceTypeDto
    fun toCertificateSourceType(certificateSourceTypeDto: CertificateSourceTypeDto): CertificateSourceType

}
