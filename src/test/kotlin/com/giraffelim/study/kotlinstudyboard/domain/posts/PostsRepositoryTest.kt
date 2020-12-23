package com.giraffelim.study.kotlinstudyboard.domain.posts

import com.giraffelim.study.kotlinstudyboard.domain.Posts
import com.giraffelim.study.kotlinstudyboard.repository.PostsRepository
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.AfterEach
import org.junit.jupiter.api.Test
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest
import org.springframework.test.annotation.Rollback


@DataJpaTest
class PostsRepositoryTest(@Autowired val postsRepository: PostsRepository) {

    @AfterEach
    fun cleanUp() {
        postsRepository.deleteAll()
    }

    @Test
    @Rollback(false)
    fun 게시글저장_불러오기() {
        // given
        val title = "테스트 게시글"
        val content = "테스트 본문"

        postsRepository.save(Posts(title = title, content = content, author = "taeyang7704@naver.com"))

        // when
        val postsList = postsRepository.findAll()

        // then
        val posts = postsList[0]
        assertThat(posts.title == title)
        assertThat(posts.content == content)
    }

}