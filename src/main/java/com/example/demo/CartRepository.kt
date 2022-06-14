package com.example.demo

interface CartRepository {
    fun add(id: ItemId, quantity: Int)
    fun remove(id: ItemId)
    fun getAll(): Map<ItemId, Int>
}