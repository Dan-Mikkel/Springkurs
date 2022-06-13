package com.example.demo

interface CartRepository {
    fun add(itemId: Int, quantity: Int)
    fun remove(itemId: Int)
    fun getAll(): Map<Int, Int>
}