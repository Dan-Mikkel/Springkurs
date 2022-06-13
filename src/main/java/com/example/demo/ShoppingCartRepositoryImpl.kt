package com.example.demo

import org.springframework.stereotype.Repository

@Repository
class ShoppingCartRepositoryImpl : ShoppingCartRepository {

    private val shoppingCart: MutableList<Item> = mutableListOf()

    override fun addItem(item: Item) = shoppingCart.add(item)
    override fun getAll(): List<Item> = shoppingCart.toList()

}