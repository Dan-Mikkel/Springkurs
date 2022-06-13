package com.example.demo

interface CartRepository {
    fun add(itemId: Number, quantity: Number)
    fun remove(itemId: Number)
    fun getAll(): Map<Number, Number>
}