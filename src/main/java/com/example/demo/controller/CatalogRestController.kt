package com.example.demo.controller

import com.example.demo.Catalog
import com.example.demo.Item
import com.example.demo.ItemId
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.*
import java.net.URI

@RestController
@RequestMapping("/catalog")
class CatalogRestController(private val catalog: Catalog) {

    @GetMapping(produces = ["application/json", "application/xml")
    fun getAllCatalogItems() = catalog.toMap()

    @PostMapping(consumes = ["application/json", "application/xml"], produces = ["application/json", "application/xml"])
    fun addItemToCatalog(@RequestBody item: Item): ResponseEntity<Item> {
        println("Adding $item")
        catalog[item.id] = item
        val uri = URI.create("/catalog/" + item.id)
        return ResponseEntity.created(uri).body(item)
    }

    @PutMapping(value = ["/{id}"], consumes = ["application/json", "application/xml"])
    fun modifyItemInCatalog(@PathVariable id: ItemId, @RequestBody item: Item): ResponseEntity<*>? {
        return if (!catalog.containsKey(id)) 
            ResponseEntity.notFound().build<Any>() 
        else {
            println("Updating item id $id")
            catalog[id] = item
            ResponseEntity.ok().build<Any>()
        }
    }

    @DeleteMapping("/{id}")
    fun deleteItemInCatalog(@PathVariable id: ItemId): ResponseEntity<*>? {
        return if (!catalog.containsKey(id)) 
            ResponseEntity.notFound().build<Any>() 
        else {
            println("Deleting item id $id")
            catalog.remove(id)
            ResponseEntity.ok().build<Any>()
        }
    }
    
    @GetMapping("/{id}")
    fun getCatalogItem(@PathVariable id: ItemId) = catalog[id]

}