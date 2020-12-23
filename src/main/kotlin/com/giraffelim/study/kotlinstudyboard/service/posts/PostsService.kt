package com.giraffelim.study.kotlinstudyboard.service.posts

import com.giraffelim.study.kotlinstudyboard.repository.PostsRepository
import com.giraffelim.study.kotlinstudyboard.web.dto.PostsSaveRequestDto
import org.springframework.stereotype.Service
import javax.transaction.Transactional

@Service
class PostsService(val postsRepository: PostsRepository) {

    @Transactional
    fun save(postsSaveRequestDto: PostsSaveRequestDto): Long? = postsRepository.save(postsSaveRequestDto.toEntity()).id
}