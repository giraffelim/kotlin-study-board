package com.giraffelim.study.kotlinstudyboard.repository

import com.giraffelim.study.kotlinstudyboard.domain.Posts
import org.springframework.data.jpa.repository.JpaRepository

interface PostsRepository: JpaRepository<Posts, Long> {
}