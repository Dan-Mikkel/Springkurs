package com.example.demo.impl

import com.example.demo.CartRepository
import com.example.demo.CartService
import com.example.demo.ItemRepository
import org.springframework.stereotype.Service

@Service
class CartServiceImpl(private val cartRepository: CartRepository, private val itemRepository: ItemRepository) : CartService {
    override fun addItemToCart(id: Int, quantity: Int) {
        cartRepository.add(id, quantity)
    }

    override fun removeItemFromCart(id: Int) {
        cartRepository.remove(id)
    }

    override fun getAllItemsInCart(): Map<Int, Int> {
        return cartRepository.getAll()
    }

    override fun calculateCartCost(): Double =
        getAllItemsInCart().entries
                .map { (itemRepository.getById(it.key)?.price ?: 0.0) * it.value}
                .reduce { acc, number ->  return acc+number}
}