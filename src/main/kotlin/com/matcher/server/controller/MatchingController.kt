package com.matcher.server.controller

import com.matcher.server.model.dto.InterestRequestDto
import com.matcher.server.model.dto.MatchingResponseDto
import com.matcher.server.service.MatchingService
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.web.bind.annotation.*
import reactor.core.publisher.Mono

@RestController
@RequestMapping("/api/matcher")
class MatchingController(@Autowired var matchingService: MatchingService) {

    @PostMapping("/match")
    fun getOfferByInterest(
        @RequestBody interests: List<InterestRequestDto>
    ): Mono<MatchingResponseDto> = matchingService.getMatchingProposal(interests)

}
