package com.example.demo.cart

class InCartRepositoryContractTest : CartRepositoryContract {
    override fun createSystemUnderTest(): CartRepository {
        return InMemoryCartRepository()
    }
}