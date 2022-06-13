package com.example.demo

interface CartService {
    fun addItemToCart(id: Int, quantity: Int)
    fun removeItemFromCart(id: Int)
    fun getAllItemsInCart(): Map<Int, Int>
    fun calculateCartCost(): Double
}