package com.example.demo.controller

import com.example.demo.Item
import com.example.demo.ItemId
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("/items")
class ItemRestController(private val catalog: Map<ItemId, Item>) {

    @GetMapping()
    fun getAllItems(): Map<ItemId, Item> {
        return catalog
    }

}