package com.example.demo.impl

import com.example.demo.CartRepository
import org.springframework.stereotype.Repository

@Repository
class InMemoryCartRepository : CartRepository {

    private val cart = HashMap<Int, Int>()

    override fun add(itemId: Int, quantity: Int) {
        val itemQuantity = cart[itemId] ?: quantity

        cart[itemId] = itemQuantity
    }

    override fun remove(itemId: Int) {
        cart.remove(itemId)
    }

    override fun getAll() = cart

}