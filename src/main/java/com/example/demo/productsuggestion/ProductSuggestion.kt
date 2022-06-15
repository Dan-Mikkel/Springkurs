package com.example.demo.productsuggestion

import javax.persistence.Entity
import javax.persistence.GeneratedValue
import javax.persistence.GenerationType
import javax.persistence.Id

@Entity
class ProductSuggestion {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    var id: Long? = null
    var description: String = ""
    var recommendedPrice = 0.0
    var estimatedAnnualSales: Long = 0

    constructor()
    constructor(description: String, recommendedPrice: Double, estimatedAnnualSales: Long) {
        this.description = description
        this.recommendedPrice = recommendedPrice
        this.estimatedAnnualSales = estimatedAnnualSales
    }

    override fun toString(): String {
        return String.format("[%d] %s, recommended price £%.2f, estimated annual sales %d",
                id, description, recommendedPrice, estimatedAnnualSales)
    }
}