package com.matcher.server.model.dto

import org.springframework.format.annotation.DateTimeFormat
import java.time.LocalDateTime
import javax.validation.constraints.NotNull

class CertificateBundleDto(
    @field:NotNull
    var certificate: CertificateDto,
    @field:NotNull
    var quantity: Int,
    @field:NotNull
    @DateTimeFormat(iso = DateTimeFormat.ISO.DATE)
    var issuedAt: LocalDateTime,
    @field:NotNull
    var issuedBy: String) {
}
