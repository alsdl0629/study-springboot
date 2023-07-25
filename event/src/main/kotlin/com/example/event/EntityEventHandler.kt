package com.example.event

import org.springframework.context.event.EventListener
import org.springframework.scheduling.annotation.Async
import org.springframework.stereotype.Component

@Component
class EntityEventHandler {

    @Async
    @EventListener
    fun on(entityCreated: EntityCreated) {
        entityCreated.apply {
            println("$entityId 번 피드가 저장됨")
        }
    }
}