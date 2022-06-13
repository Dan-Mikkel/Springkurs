package com.example.demo

import org.springframework.stereotype.Repository

@Repository
class InMemoryCartRepository : CartRepository {

    private val cart = HashMap<Number, Number>()

    override fun add(itemId: Number, quantity: Number) {
        val itemQuantity = cart[itemId] ?: quantity

        cart[itemId] = itemQuantity
    }

    override fun remove(itemId: Number) {
        cart.remove(itemId)
    }

    override fun getAll() = cart

}