package com.giraffelim.study.kotlinstudyboard

import com.fasterxml.jackson.databind.ObjectMapper
import com.giraffelim.study.kotlinstudyboard.domain.Posts
import com.giraffelim.study.kotlinstudyboard.repository.PostsRepository
import com.giraffelim.study.kotlinstudyboard.web.dto.PostsUpdateRequestDto
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.AfterEach
import org.junit.jupiter.api.Test
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc
import org.springframework.boot.test.context.SpringBootTest
import org.springframework.boot.web.server.LocalServerPort
import org.springframework.http.MediaType
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders.put
import org.springframework.test.web.servlet.result.MockMvcResultHandlers.print
import org.springframework.test.annotation.Rollback
import org.springframework.test.web.servlet.MockMvc
import org.springframework.test.web.servlet.result.MockMvcResultMatchers.status

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
@AutoConfigureMockMvc
class ApiControllerTest(@LocalServerPort val port: Int, @Autowired val postsRepository: PostsRepository, @Autowired val mockMvc: MockMvc) {

    @AfterEach
    fun tearDown() {
        postsRepository.deleteAll()
    }

    @Test
    @Rollback(false)
    fun 게시글_수정() {
        val post = postsRepository.save(Posts(title = "title", content = "content", author = "author"))

        val updateId = post.id
        val updateExpectedTitle = "update title"
        val updateExpectedContent = "update content"

        val postUpdateDto = PostsUpdateRequestDto(title = updateExpectedTitle, content = updateExpectedContent)

        val url = "http://localhost:$port/api/v1/posts/$updateId"

        mockMvc.perform(put(url)
                .contentType(MediaType.APPLICATION_JSON)
                .content(ObjectMapper().writeValueAsString(postUpdateDto)))
                .andDo(print())
                .andExpect(status().isOk)

        val postList = postsRepository.findAll()
        assertThat(updateExpectedTitle).isEqualTo(postList[0].title)
        assertThat(updateExpectedContent).isEqualTo(postList[0].content)
    }
}