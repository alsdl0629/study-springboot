package com.example.cache.global_cache_redis.order

import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.DeleteMapping
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.PutMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RequestMapping("/orders")
@RestController
class OrderController(
    private val orderService: OrderService,
) {

    @PostMapping
    fun createOrder(@RequestBody order: Order): Order {
        return orderService.createOrder(order)
    }

    @GetMapping
    fun getOrder(): ResponseEntity<List<Order>> {
        return ResponseEntity.ok(orderService.getAllOrders())
    }

    @GetMapping("/{id}")
    fun getOrder(@PathVariable id: Int): Order {
        return orderService.getOrder(id)
    }

    @PutMapping("/{id}")
    fun updateOrder(@PathVariable id: Int, @RequestBody order: Order): Order {
        return orderService.updateOrder(order, id)
    }

    @DeleteMapping("/{id}")
    fun deleteOrder(@PathVariable id: Int): String {
        orderService.deleteOrder(id)
        return "Order with id: $id deleted."
    }
}