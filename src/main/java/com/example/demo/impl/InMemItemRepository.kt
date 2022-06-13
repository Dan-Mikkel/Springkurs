package com.example.demo.impl

import com.example.demo.Item
import com.example.demo.ItemRepository
import org.springframework.stereotype.Repository

@Repository
class InMemItemRepository : ItemRepository {

    private val items: MutableMap<Int, Item> = mutableMapOf()

    override fun add(item: Item) {
        items[item.id] = item
    }

    override fun remove(id: Int) {
        items.remove(id)
    }

    override fun getById(id: Int) = items[id]
}