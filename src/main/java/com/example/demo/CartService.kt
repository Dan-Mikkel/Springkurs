package com.example.demo

interface CartService {
    fun addItemToCart(id: Number, quantity: Number)
    fun removeItemFromCart(id: Number)
    fun getAllItemsInCart(): Map<Number, Number>
    fun calculateCartCost(): Double
}