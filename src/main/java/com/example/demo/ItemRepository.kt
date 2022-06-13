package com.example.demo

interface ItemRepository {
    fun add(item: Item)
    fun remove(id: Int)
    fun getById(id: Int): Item?
}
