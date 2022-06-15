package com.example.demo.impl

import com.example.demo.ProductSuggestionRepository
import com.example.demo.model.ProductSuggestion
import org.springframework.stereotype.Repository
import org.springframework.transaction.annotation.Transactional
import javax.persistence.EntityManager
import javax.persistence.PersistenceContext

@Repository
class ProductSuggestionRepositoryImpl : ProductSuggestionRepository {
    
    @PersistenceContext
    private lateinit var entityManager: EntityManager


    override fun getProductSuggestions(): Collection<ProductSuggestion> {
        val jpql = "select p from ProductSuggestion p"
        val query = entityManager.createQuery(jpql, ProductSuggestion::class.java)
        return query.resultList
    }

    override fun getProductSuggestion(id: Long): ProductSuggestion {
        return entityManager.find(ProductSuggestion::class.java, id)
    }

    @Transactional
    override fun insertProductSuggestion(ps: ProductSuggestion): Long {
        entityManager.persist(ps)
        entityManager.flush()
        return ps.id!!
    }

    @Transactional
    override fun modifyPrice(id: Long, newPrice: Double): Boolean {
        val ps = entityManager.find(ProductSuggestion::class.java, id)
        return if (ps == null) {
            false
        } else {
            ps.recommendedPrice = newPrice
            true
        }
    }

    @Transactional
    override fun modifySales(id: Long, newSales: Long): Boolean {
        val ps = entityManager.find(ProductSuggestion::class.java, id)
        return if (ps == null) {
            false
        } else {
            ps.estimatedAnnualSales = newSales
            true
        }
    }

    @Transactional
    override fun deleteProductSuggestions() {
        val query = entityManager.createQuery("delete from ProductSuggestion")
        query.executeUpdate()
    }
}