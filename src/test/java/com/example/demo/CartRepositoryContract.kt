package com.example.demo

import org.junit.jupiter.api.Test
import kotlin.test.assertTrue

interface CartRepositoryContract: Testable<CartRepository> {

    override fun createSystemUnderTest(): CartRepository

    @Test
    fun canAddOneItem() {
        val sut = createSystemUnderTest()
        sut.add(0, 1)
        assertTrue(sut.getAll().size == 1)
    }

    @Test
    fun doesNotModifyData() {
        val sut = createSystemUnderTest()
        sut.add(0, 1)
        assertTrue(sut.getAll().containsKey(0))
        assertTrue(sut.getAll().containsValue(1))
    }
}