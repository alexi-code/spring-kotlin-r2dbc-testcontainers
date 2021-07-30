package com.matcher.server.service

import com.matcher.server.model.dto.InterestRequestDto
import com.matcher.server.model.dto.MatchingResponseDto
import reactor.core.publisher.Mono

interface MatchingService {

    fun getMatchingProposal(interests: List<InterestRequestDto>): Mono<MatchingResponseDto>

}
