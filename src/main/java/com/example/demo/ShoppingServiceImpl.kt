package com.example.demo

import org.springframework.stereotype.Service

@Service
class ShoppingServiceImpl(private val itemRepository: ItemRepository, private val shoppingCartRepository: ShoppingCartRepository) : ShoppingService {

    override fun getAvailableItems(): List<Item> = itemRepository.getAllItems()

    override fun addItemToCart(item: Item) {
        shoppingCartRepository.addItem(item)
    }
}