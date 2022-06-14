package com.example.demo.impl

import com.example.demo.CatalogRepository
import com.example.demo.Item
import com.example.demo.ItemId
import org.springframework.stereotype.Repository

@Repository
class CatalogRepositoryImpl : CatalogRepository {

    val catalog: MutableMap<ItemId, Item> = createCatalog()

    private fun createCatalog(): MutableMap<ItemId, Item> {
        val items: MutableMap<Int, Item> = HashMap()
        items[0] = Item(0, "Apple Mac Book Pro", 2499.99)
        items[1] = Item(1, "32GB San Disk", 15.99)
        items[2] = Item(2, "OLED 64in TV", 1800.99)
        items[3] = Item(3, "Wireless Mouse", 10.59)
        items[4] = Item(4, "Virtual Reality HeadSet", 200.59)
        items[5] = Item(5, "Sat Nav", 159.99)
        return items
    }

    override fun getAll() = catalog.toMap()

    override fun getItemFromCatalog(id: ItemId) = catalog[id]

    override fun add(item: Item) = catalog.put(item.id, item)

    override fun delete(id: ItemId) = catalog.remove(id)
}