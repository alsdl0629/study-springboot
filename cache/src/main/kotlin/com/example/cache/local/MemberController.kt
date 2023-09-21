package com.example.cache.local

import org.slf4j.LoggerFactory
import org.springframework.web.bind.annotation.DeleteMapping
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.PutMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RestController

@RestController
class MemberController(
    private val memberRepository: MemberRepository
) {
    private val log = LoggerFactory.getLogger(javaClass)
    @GetMapping("/members")
    fun findAll(): Members {
        val members = memberRepository!!.findAll()
        log.info("Controller findAll {}", members)
        return members
    }

    @GetMapping("/members/{memberId}")
    fun findById(@PathVariable memberId: Long?): Member {
        val member = memberRepository!!.findById(memberId!!)
        log.info("Controller find {}", member)
        return member
    }

    @PostMapping("/members")
    fun save(@RequestBody memberDto: MemberDto): Member {
        val member = Member(0L, memberDto.name, memberDto.age)
        val savedMember = memberRepository!!.save(member)
        log.info("Controller save {}", savedMember)
        return savedMember
    }

    @PutMapping("/members/{memberId}")
    fun update(@PathVariable memberId: Long?, @RequestBody memberDto: MemberDto): Member {
        val member = Member(memberId!!, memberDto.name, memberDto.age)
        member.id = memberId!!
        return memberRepository!!.update(member)
    }

    @DeleteMapping("/members/{memberId}")
    fun delete(@PathVariable memberId: Long?) {
        val member = memberRepository!!.findById(memberId!!)
        log.info("Controller delete {}", member)
        memberRepository.delete(member)
    }
}

data class MemberDto(
    val name: String,
    val age: Int
)