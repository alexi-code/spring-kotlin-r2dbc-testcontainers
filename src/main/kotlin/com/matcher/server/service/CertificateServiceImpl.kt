package com.matcher.server.service

import com.matcher.server.mapper.CommonMapper
import com.matcher.server.model.Certificate
import com.matcher.server.model.CertificateSourceType
import com.matcher.server.model.dto.CertificateBundleDto
import com.matcher.server.model.dto.CertificateDto
import com.matcher.server.model.dto.CertificateSourceTypeDto
import com.matcher.server.repository.CertificateBundleRepository
import com.matcher.server.repository.CertificateRepository
import com.matcher.server.repository.CertificateSourceTypeRepository
import org.mapstruct.factory.Mappers
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.http.HttpStatus
import org.springframework.stereotype.Service
import org.springframework.web.client.HttpClientErrorException
import org.springframework.web.server.ResponseStatusException
import reactor.core.publisher.Flux
import reactor.core.publisher.Mono

@Service
class CertificateServiceImpl(
    @Autowired val certificateRepository: CertificateRepository,
    @Autowired val certificateBundleRepository: CertificateBundleRepository,
    @Autowired val certificateSourceTypeRepository: CertificateSourceTypeRepository,
): CertificateService {

    val mapper: CommonMapper = Mappers.getMapper(CommonMapper::class.java)

    override fun createCertificate(certificateDto: CertificateDto): Mono<CertificateDto> {
        return certificateRepository.save(mapper.toCertificate(certificateDto)).map(mapper::toDto)
    }

    override fun getAllCertificates(): Flux<CertificateDto> {
        return certificateRepository.findAll().map(mapper::toDto)
    }

    override fun createCertificateBundle(certificateBundleDto: CertificateBundleDto): Mono<CertificateBundleDto> {
        TODO("Not yet implemented")
    }

    override fun getAllCertificateBundles(): Flux<CertificateBundleDto> {
        return certificateBundleRepository.findAll().map(mapper::toDto)
    }

    override fun createSourceType(certificateSourceTypeDto: CertificateSourceTypeDto): Mono<CertificateSourceTypeDto> {
        return certificateSourceTypeRepository.findFirstByName(certificateSourceTypeDto.name)
            .hasElement()
            .flatMap(fun (isPresent: Boolean) :
                Mono<CertificateSourceTypeDto> = if (isPresent)
                    Mono.error(ResponseStatusException(HttpStatus.CONFLICT, certificateSourceTypeDto.name + " already exists"))
                    else certificateSourceTypeRepository.save(mapper.toCertificateSourceType(certificateSourceTypeDto)).map(mapper::toDto))
    }

    override fun getAllTypes(): Flux<CertificateSourceTypeDto> {
        return certificateSourceTypeRepository.findAll().map(mapper::toDto)
    }

}
