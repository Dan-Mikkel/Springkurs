package com.example.demo.cart

class InCartRepositoryContractImpl : CartRepositoryContract {
    override fun createSystemUnderTest(): CartRepository {
        return InMemoryCartRepository()
    }
}