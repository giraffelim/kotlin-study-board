package com.giraffelim.study.kotlinstudyboard.web.dto

import com.giraffelim.study.kotlinstudyboard.domain.Posts
import java.time.format.DateTimeFormatter

data class PostsListResponseDto(
        val id: Long,
        val title: String,
        val content: String,
        val author: String,
        val modifiedDate: String
) {
    constructor(posts: Posts) : this(posts.id?:0L , posts.title, posts.content, posts.author, posts.modifiedDate?.format(DateTimeFormatter.ofPattern("yyyy/MM/dd")) ?: "")
}