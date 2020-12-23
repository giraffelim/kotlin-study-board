package com.giraffelim.study.kotlinstudyboard.web

import com.giraffelim.study.kotlinstudyboard.service.posts.PostsService
import com.giraffelim.study.kotlinstudyboard.web.dto.PostsSaveRequestDto
import com.giraffelim.study.kotlinstudyboard.web.dto.PostsUpdateRequestDto
import org.springframework.web.bind.annotation.*

@RequestMapping("/api/v1")
@RestController
class PostsApiController(val postsService: PostsService) {

    @PostMapping("/posts")
    fun save(@RequestBody postsSaveRequestDto: PostsSaveRequestDto): Long {
        return postsService.save(postsSaveRequestDto) ?: 0L
    }

    @PutMapping("/posts/{id}")
    fun update(@PathVariable id: Long, @RequestBody postsUpdateRequestDto: PostsUpdateRequestDto): Long {
        return postsService.update(id, postsUpdateRequestDto)
    }
}