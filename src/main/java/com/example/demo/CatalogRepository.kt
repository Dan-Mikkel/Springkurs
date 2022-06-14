package com.example.demo

interface CatalogRepository {
    fun getAll(): Map<ItemId, Item>
    fun getItemFromCatalog(id: ItemId): Item?
    fun add(item: Item): Item?
    fun delete(id: ItemId): Item?
}