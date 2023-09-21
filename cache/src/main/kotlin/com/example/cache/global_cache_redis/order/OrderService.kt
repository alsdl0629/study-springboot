package com.example.cache.global_cache_redis.order

import jakarta.persistence.EntityNotFoundException
import org.springframework.cache.annotation.CacheEvict
import org.springframework.cache.annotation.CachePut
import org.springframework.cache.annotation.Cacheable
import org.springframework.data.repository.findByIdOrNull
import org.springframework.stereotype.Service

@Service
class OrderService(
    private val orderRepository: OrderRepository
) {

    fun createOrder(order: Order) = orderRepository.save(order)

    @Cacheable(value = ["Order"], key = "#orderId", cacheManager = "cacheManager")
    fun getOrder(orderId: Int): Order {
        return orderRepository.findByIdOrNull(orderId) ?: throw EntityNotFoundException()
    }

    @CachePut(value = ["Order"], key = "#orderId", cacheManager = "cacheManager")
    fun updateOrder(order: Order, orderId: Int): Order {
        val orderObject = orderRepository.findByIdOrNull(orderId) ?: throw EntityNotFoundException()
        return orderRepository.save(orderObject);
    }

    @CacheEvict(value = ["Order"], key = "#orderId", cacheManager = "cacheManager")
    fun deleteOrder(orderId: Int) {
        val order = orderRepository.findByIdOrNull(orderId) ?: throw EntityNotFoundException()
        orderRepository.delete(order)
    }

    @Cacheable(value = ["Order"], cacheManager = "cacheManager")
    fun getAllOrders() = orderRepository.findAll()
}