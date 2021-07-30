package com.matcher.server.model.dto

import javax.validation.constraints.NotNull

class CertificateDto(
    @field:NotNull
    var name : String,
    @field:NotNull
    var sourceType: CertificateSourceTypeDto)
