package com.example.demo.cart

import com.example.demo.ItemId
import org.springframework.stereotype.Repository

@Repository
class InMemoryCartRepository : CartRepository {

    private val cart = HashMap<ItemId, Int>()

    override fun add(id: ItemId, quantity: Int) {
        cart[id] = quantity
    }

    override fun remove(id: ItemId) {
        cart.remove(id)
    }

    override fun getAll() = cart

}