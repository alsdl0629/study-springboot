package com.example.cache.member

class Member(
    var id: Long,
    val name: String,
    val age: Int
) {
}

data class Members(
    val members: List<Member>
)