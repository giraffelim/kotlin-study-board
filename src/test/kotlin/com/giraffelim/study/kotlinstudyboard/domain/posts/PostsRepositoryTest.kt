package com.giraffelim.study.kotlinstudyboard.domain.posts

import com.giraffelim.study.kotlinstudyboard.domain.Posts
import com.giraffelim.study.kotlinstudyboard.repository.PostsRepository
import com.giraffelim.study.kotlinstudyboard.service.posts.PostsService
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.AfterEach
import org.junit.jupiter.api.Test
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest
import org.springframework.boot.test.context.SpringBootTest
import org.springframework.test.annotation.Rollback


@SpringBootTest
class PostsRepositoryTest(@Autowired val postsRepository: PostsRepository, @Autowired val postsService: PostsService) {

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

    @Test
    @Rollback(false)
    fun 게시글조회() {
        // given
        val title = "테스트 게시글"
        val content = "테스트 본문"
        postsRepository.save(Posts(title = title, content = content, author = "taeyang7704@naver.com"))

        // when
        val responsePostList = postsService.findAllDesc()

        // then
        val posts = responsePostList[0]
        assertThat(posts.id == 1L)
        assertThat(posts.title == title)
    }

}