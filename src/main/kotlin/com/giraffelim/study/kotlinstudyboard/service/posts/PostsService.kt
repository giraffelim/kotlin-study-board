package com.giraffelim.study.kotlinstudyboard.service.posts

import com.giraffelim.study.kotlinstudyboard.repository.PostsRepository
import com.giraffelim.study.kotlinstudyboard.web.dto.PostsListResponseDto
import com.giraffelim.study.kotlinstudyboard.web.dto.PostsSaveRequestDto
import com.giraffelim.study.kotlinstudyboard.web.dto.PostsUpdateRequestDto
import org.springframework.stereotype.Service
import java.lang.IllegalArgumentException
import java.time.format.DateTimeFormatter
import java.util.function.Function
import java.util.stream.Collectors
import java.util.stream.Collectors.*
import javax.transaction.Transactional

@Service
class PostsService(val postsRepository: PostsRepository) {

    @Transactional
    fun save(postsSaveRequestDto: PostsSaveRequestDto): Long? = postsRepository.save(postsSaveRequestDto.toEntity()).id

    @Transactional
    fun findAllDesc(): List<PostsListResponseDto> {
        return postsRepository.findAllDesc().stream().map { PostsListResponseDto(it) }.collect(toList())
    }

    @Transactional
    fun findById(id: Long): PostsListResponseDto {
        return PostsListResponseDto(postsRepository.findById(id).orElseThrow { IllegalArgumentException("해당 게시글이 없습니다!. id = $id")})
    }

    @Transactional
    fun update(id: Long, postsUpdateRequestDto: PostsUpdateRequestDto): Long {
        val post = postsRepository.findById(id).orElseThrow { IllegalArgumentException("해당 게시글이 없습니다!. id = $id") }
        post.update(title = postsUpdateRequestDto.title, content = postsUpdateRequestDto.content)
        return id
    }

    @Transactional
    fun delete(id: Long) {
        // 존재하는 게시글인지 확인
        val post = postsRepository.findById(id).orElseThrow { IllegalArgumentException("해당 게시글이 없습니다!. id = $id") }
        // 게시글이 존재하면 삭제
        postsRepository.delete(post)
    }

}