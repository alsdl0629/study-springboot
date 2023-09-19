package com.example.cache.member

import org.slf4j.LoggerFactory
import org.springframework.cache.annotation.CacheConfig
import org.springframework.cache.annotation.CacheEvict
import org.springframework.cache.annotation.CachePut
import org.springframework.cache.annotation.Cacheable
import org.springframework.cache.annotation.Caching
import org.springframework.stereotype.Repository

@Repository
@CacheConfig(cacheNames = ["members"])
class MemberRepository(
    private val store: MutableMap<Long, Member> = mutableMapOf()
) {
    private val log = LoggerFactory.getLogger(javaClass)
    @Cacheable(key = "'all'")
    fun findAll(): Members {
        val members = store.values.toList()
        log.info("Repository findAll {}", members)
        return Members(members)
    }

    @Cacheable(key = "#memberId", unless = "#result == null")
    fun findById(memberId: Long) : Member {
        val member = store[memberId]!!
        log.info("Repository find {}", member)
        return member
    }

    @CachePut(key = "#member.id")
    @CacheEvict(key = "'all'")
    fun save(member: Member): Member {
        val newId = calculateId()
        member.id = newId
        log.info("Repository save {}", member)
        store[member.id] = member
        return member
    }

    private fun calculateId(): Long {
        if (store.isEmpty()) {
            return 1L
        }
        val lastIndex = store.size - 1
        return store.keys.toTypedArray()[lastIndex] + 1
    }

    @CachePut(key = "#member.id")
    @CacheEvict(key = "'all'")
    fun update(member: Member): Member {
        log.info("Repository update {}", member)
        store[member.id] = member
        return member
    }

    @Caching(evict = [CacheEvict(key = "'all'"), CacheEvict(key = "#member.id")])
    fun delete(member: Member) {
        log.info("Repository delete {}", member)
        store.remove(member.id)
    }
}