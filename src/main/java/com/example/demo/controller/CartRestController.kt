package com.example.demo.controller

import com.example.demo.CartService
import com.example.demo.Catalog
import com.example.demo.ItemId
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.RestController

@RestController
class CartRestController(private val catalog: Catalog, private val cartService: CartService) {

    @GetMapping("/items")
    fun getAllItemsInCart() = cartService.getAllItemsInCart().keys.map { catalog[it] }

    @GetMapping("/cartCost")
    fun getCartCost() = cartService.calculateCartCost()

    @GetMapping("/quantityForItem/{itemId}")
    fun getQuantityForItem(@PathVariable itemId: ItemId) = cartService.getAllItemsInCart()[itemId] ?: 0

}