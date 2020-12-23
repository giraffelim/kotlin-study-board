package com.giraffelim.study.kotlinstudyboard.web

import com.giraffelim.study.kotlinstudyboard.service.posts.PostsService
import org.springframework.stereotype.Controller
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.ui.Model
import org.springframework.web.bind.annotation.PathVariable

@Controller
class ViewController(val postsService: PostsService) {

    @GetMapping("/")
    fun index(model: Model): String {
        model.addAttribute("posts", postsService.findAllDesc())
        return "index"
    }

    @GetMapping("/posts/save")
    fun postsSave() = "posts-save"

    @GetMapping("/posts/update/{id}")
    fun postsUpdate(@PathVariable id: Long, model: Model): String {
        model.addAttribute("post", postsService.findById(id))
        return "posts-update"
    }

}