package com.matcher.server.controller

import com.matcher.server.model.dto.*
import com.matcher.server.service.CertificateService
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Controller
import org.springframework.web.bind.annotation.*
import reactor.core.publisher.Flux
import reactor.core.publisher.Mono

@Controller
@RequestMapping("/api/certificate")
class CertificateController(@Autowired var certificateService: CertificateService) {

    @PostMapping
    @ResponseBody
    fun createCertificate(
        @RequestBody certificate: CertificateDto
    ): Mono<CertificateDto> = certificateService.createCertificate(certificate)

    @ResponseBody
    @GetMapping
    fun getAllCertificates():
        Flux<CertificateDto> = certificateService.getAllCertificates()

    @PostMapping("/bundle")
    @ResponseBody
    fun createBundle(
        @RequestBody certificateBundle: CertificateBundleDto
    ): Mono<CertificateBundleDto> = certificateService.createCertificateBundle(certificateBundle)

    @GetMapping("/bundle")
    @ResponseBody
    fun getAllCertificateBundles():
        Flux<CertificateBundleDto> = certificateService.getAllCertificateBundles()

    @PostMapping("/type")
    @ResponseBody
    fun createSourceType(
        @RequestBody certificateType: CertificateSourceTypeDto
    ): Mono<CertificateSourceTypeDto> = certificateService.createSourceType(certificateType)

    @GetMapping("/type")
    @ResponseBody
    fun getAllCertificateTypes():
        Flux<CertificateSourceTypeDto> = certificateService.getAllTypes()

}
