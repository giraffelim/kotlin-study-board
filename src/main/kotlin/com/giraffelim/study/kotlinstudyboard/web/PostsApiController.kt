package com.giraffelim.study.kotlinstudyboard.web

import com.giraffelim.study.kotlinstudyboard.service.posts.PostsService
import com.giraffelim.study.kotlinstudyboard.web.dto.PostsSaveRequestDto
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RequestMapping("/api/v1")
@RestController
class PostsApiController(val postsService: PostsService) {

    @PostMapping("/posts")
    fun save(@RequestBody postsSaveRequestDto: PostsSaveRequestDto): Long {
        return postsService.save(postsSaveRequestDto) ?: 0L
    }
}