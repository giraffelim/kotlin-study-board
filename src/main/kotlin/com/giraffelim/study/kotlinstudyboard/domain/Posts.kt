package com.giraffelim.study.kotlinstudyboard.domain

import javax.persistence.Entity
import javax.persistence.GeneratedValue
import javax.persistence.GenerationType
import javax.persistence.Id

@Entity
data class Posts(
        @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
        val id: Long? = null,
        var title: String = "",
        var content: String = "",
        val author: String = ""
) : BaseTimeEntity() {
    fun update(title: String, content: String) {
        this.title = title
        this.content = content
    }
}