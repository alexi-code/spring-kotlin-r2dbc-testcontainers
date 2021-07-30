package com.matcher.server.service

import com.matcher.server.model.dto.InterestRequestDto
import com.matcher.server.model.dto.MatchingResponseDto
import org.springframework.stereotype.Service
import reactor.core.publisher.Mono

@Service
class MatchingServiceImpl: MatchingService {

    override fun getMatchingProposal(interests: List<InterestRequestDto>): Mono<MatchingResponseDto> {
        TODO("Not yet implemented")
    }

}
