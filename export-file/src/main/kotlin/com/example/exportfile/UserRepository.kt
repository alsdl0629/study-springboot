package com.example.exportfile

import org.springframework.data.jpa.repository.JpaRepository

interface UserRepository : JpaRepository<User, Long>