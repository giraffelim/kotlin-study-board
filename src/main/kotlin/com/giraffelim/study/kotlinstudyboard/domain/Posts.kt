package com.giraffelim.study.kotlinstudyboard.domain

import javax.persistence.Entity
import javax.persistence.GeneratedValue
import javax.persistence.GenerationType
import javax.persistence.Id

@Entity
data class Posts(
        @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
        val id: Long? = null,
        val title: String = "",
        val content: String = "",
        val author: String = ""
) : BaseTimeEntity()