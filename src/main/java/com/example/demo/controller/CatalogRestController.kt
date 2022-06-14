package com.example.demo.controller

import com.example.demo.Catalog
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("/catalog")
class CatalogRestController(private val catalog: Catalog) {

    @GetMapping("")
    fun getAllCatalogItems() = catalog

}