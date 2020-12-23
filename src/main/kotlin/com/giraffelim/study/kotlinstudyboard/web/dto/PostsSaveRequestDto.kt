package com.giraffelim.study.kotlinstudyboard.web.dto

import com.giraffelim.study.kotlinstudyboard.domain.Posts

data class PostsSaveRequestDto(
        val title: String,
        val content: String,
        val author: String
)
{
    fun toEntity(): Posts = Posts(title = title, content = content, author = author)
}