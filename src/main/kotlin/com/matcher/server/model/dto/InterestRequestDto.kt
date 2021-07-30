package com.matcher.server.model.dto

import javax.validation.constraints.NotNull

data class InterestRequestDto(
    @field:NotNull
    var sourceType: String,
    @field:NotNull
    var quantity: Long
)
