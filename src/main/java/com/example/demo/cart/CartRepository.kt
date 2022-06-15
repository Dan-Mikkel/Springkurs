package com.example.demo.cart

import com.example.demo.ItemId

interface CartRepository {
    fun add(id: ItemId, quantity: Int)
    fun remove(id: ItemId)
    fun getAll(): Map<ItemId, Int>
}