package com.example.demo

import org.springframework.stereotype.Repository

@Repository
class ShoppingCatalog: ItemRepository {

    private val catalog: List<Item> = listOf("Kake", "Saft", "Cola", "Laptop").map { Item(it) }

    override fun getAllItems(): List<Item> {
        return catalog
    }

}
