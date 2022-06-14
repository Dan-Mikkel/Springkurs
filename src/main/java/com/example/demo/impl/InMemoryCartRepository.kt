package com.example.demo.impl

import com.example.demo.CartRepository
import com.example.demo.Item
import com.example.demo.ItemId
import org.springframework.stereotype.Repository

@Repository
class InMemoryCartRepository : CartRepository {

    private val cart = HashMap<ItemId, Int>()

    override fun add(id: ItemId, quantity: Int) {
        val itemQuantity = cart[id] ?: quantity

        cart[id] = itemQuantity
    }

    override fun remove(id: ItemId) {
        cart.remove(id)
    }

    override fun getAll() = cart

}