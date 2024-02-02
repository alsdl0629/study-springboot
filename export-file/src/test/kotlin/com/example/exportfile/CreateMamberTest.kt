package com.example.exportfile

import org.junit.jupiter.api.Test
import org.junit.jupiter.api.assertDoesNotThrow
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.context.SpringBootTest

@SpringBootTest
class CreateMamberTest {
    @Autowired
    private lateinit var userRepository: UserRepository

    @Test
    fun `100명의 유저를 저장`() {
        // when & then
        assertDoesNotThrow {
            repeat(100) {
                userRepository.save(
                    User(
                        name = "강민$it",
                        gender = "MAN",
                        age = 19,
                    )
                )
            }
        }
    }
}