package com.example.event

import org.springframework.context.ApplicationEvent

class EntityCreated(
    private val source: Any,
    val entityId: Long
) : ApplicationEvent(source)
