package com.example.practicekotlin.domain.feed.domain

import javax.persistence.Entity
import javax.persistence.GeneratedValue
import javax.persistence.GenerationType
import javax.persistence.Id

@Entity
class Feed (

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    val id: Long = 0,

    var title: String,

    var content: String
) {

    fun updateFeed(title: String, content: String) {
        this.title = title
        this.content = content
    }

}