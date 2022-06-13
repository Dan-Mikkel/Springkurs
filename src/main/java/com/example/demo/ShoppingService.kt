package com.example.demo

interface ShoppingService {
    fun getAvailableItems(): List<Item>
    fun addItemToCart(item: Item)
}