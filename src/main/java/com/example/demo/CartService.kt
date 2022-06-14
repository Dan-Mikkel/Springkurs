package com.example.demo

interface CartService {
    fun addItemToCart(id: ItemId, quantity: Int)
    fun removeItemFromCart(id: ItemId)
    fun getAllItemsInCart(): Map<ItemId, Int>
    fun calculateCartCost(): Double
}