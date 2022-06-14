package com.example.demo.controller

import com.example.demo.Item
import com.example.demo.ItemId
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

typealias Catalog = Map<ItemId, Item>

@RestController
@RequestMapping("/catalog")
class CatalogRestController(private val catalog: Catalog) {

    @GetMapping("")
    fun getAllCatalogItems() = catalog

}