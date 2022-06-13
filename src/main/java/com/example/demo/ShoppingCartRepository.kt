package com.example.demo

interface ShoppingCartRepository {
    fun addItem(item: Item): Boolean
    fun getAll(): List<Item>
}