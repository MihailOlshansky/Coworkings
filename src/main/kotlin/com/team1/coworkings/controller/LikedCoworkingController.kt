package com.team1.coworkings.controller

import com.team1.coworkings.base.BaseController
import com.team1.coworkings.base.BaseMapper
import com.team1.coworkings.base.BaseService
import com.team1.coworkings.dto.LikedCoworkingDto
import com.team1.coworkings.entity.LikedCoworking
import com.team1.coworkings.mappers.LikedCoworkingMapper
import com.team1.coworkings.service.LikedCoworkingService
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("likedCoworking/")
class LikedCoworkingController @Autowired constructor(
    private val service: LikedCoworkingService,
    private val mapper: LikedCoworkingMapper
) : BaseController<LikedCoworking, LikedCoworkingDto> {
    override fun getService(): BaseService<LikedCoworking> {
        return this.service
    }

    override fun getMapper(): BaseMapper<LikedCoworking, LikedCoworkingDto> {
        return this.mapper
    }
}