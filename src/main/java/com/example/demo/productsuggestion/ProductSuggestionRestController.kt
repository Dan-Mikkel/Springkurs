package com.example.demo.productsuggestion

import org.springframework.http.ResponseEntity
import org.springframework.stereotype.Controller
import org.springframework.web.bind.annotation.*
import java.net.URI


@Controller
@RequestMapping("/productSuggestions")
@CrossOrigin
class ProductSuggestionRestController(private val productSuggestionRepository: ProductSuggestionRepository) {

    @GetMapping(produces = ["application/json", "application/xml"])
    fun getAllProductSuggestions(): ResponseEntity<Collection<ProductSuggestion>> {
        val result: Collection<ProductSuggestion> = productSuggestionRepository.getProductSuggestions()
        return ResponseEntity.ok().body(result)
    }

    @GetMapping(value = ["/{id}"], produces = ["application/json", "application/xml"])
    fun getProductSuggestion(@PathVariable id: Long): ResponseEntity<ProductSuggestion> {
        val result: ProductSuggestion = productSuggestionRepository.getProductSuggestion(id) ?: return ResponseEntity.notFound().build()
        return ResponseEntity.ok().body(result)
    }

    @PostMapping(consumes = ["application/json", "application/xml"], produces = ["application/json", "application/xml"])
    fun insertProductSuggestion(@RequestBody productSuggestion: ProductSuggestion): ResponseEntity<ProductSuggestion> {
        val id: Long = productSuggestionRepository.insertProductSuggestion(productSuggestion)
        productSuggestion.id = id
        val uri = URI.create("/productSuggestions/$id")
        return ResponseEntity.created(uri).body(productSuggestion)
    }

    @PutMapping(value = ["/modifyPrice/{id}"])
    fun modifyPrice(@PathVariable id: Long, @RequestParam newPrice: Double): ResponseEntity<*> {
        return if (!productSuggestionRepository.modifyPrice(id, newPrice)) {
            ResponseEntity.notFound().build<Any>()
        } else {
            ResponseEntity.ok().build<Any>()
        }
    }

    @PutMapping(value = ["/modifySales/{id}"])
    fun modifySales(@PathVariable id: Long, @RequestParam newSales: Long): ResponseEntity<*> {
        return if (!productSuggestionRepository.modifySales(id, newSales)) {
            ResponseEntity.notFound().build<Any>()
        } else {
            ResponseEntity.ok().build<Any>()
        }
    }

    @DeleteMapping
    fun deleteAllProductSuggestions(): ResponseEntity<*> {
        productSuggestionRepository.deleteProductSuggestions()
        return ResponseEntity.ok().build<Any>()
    }
}