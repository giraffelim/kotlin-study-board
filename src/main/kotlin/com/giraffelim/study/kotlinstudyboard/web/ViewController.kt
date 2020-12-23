package com.giraffelim.study.kotlinstudyboard.web

import com.giraffelim.study.kotlinstudyboard.repository.PostsRepository
import org.springframework.stereotype.Controller
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.ui.Model

@Controller
class ViewController(val postsRepository: PostsRepository) {

    @GetMapping("/")
    fun index(model: Model): String {
        model.addAttribute("posts", postsRepository.findAll())
        return "index"
    }

    @GetMapping("/posts/save")
    fun postsSave() = "posts-save"

}