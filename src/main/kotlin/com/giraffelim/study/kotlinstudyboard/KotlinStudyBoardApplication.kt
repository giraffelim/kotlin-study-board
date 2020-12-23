package com.giraffelim.study.kotlinstudyboard

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication
import org.springframework.data.jpa.repository.config.EnableJpaAuditing

@EnableJpaAuditing
@SpringBootApplication
class KotlinStudyBoardApplication

fun main(args: Array<String>) {
    runApplication<KotlinStudyBoardApplication>(*args)
}
