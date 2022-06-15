package com.example.demo

import org.junit.jupiter.api.Test
import kotlin.test.assertTrue

interface CartRepositoryContract: Testable<CartRepository> {

    override fun createSystemUnderTest(): CartRepository

    @Test
    fun `Get returns an empty map when nothing has been added`() {
        val sut = createSystemUnderTest()
        assertTrue(sut.getAll().isEmpty())
    }

    @Test
    fun `We can add one item`() {
        val sut = createSystemUnderTest()
        sut.add(0, 1)
        assertTrue(sut.getAll().size == 1)
    }

    @Test
    fun `See that adding does not modify data`() {
        val sut = createSystemUnderTest()
        sut.add(0, 1)
        assertTrue(sut.getAll().containsKey(0))
        assertTrue(sut.getAll().containsValue(1))
    }

    @Test
    fun `See that we can remove an item we added`() {
        val sut = createSystemUnderTest()
        sut.add(0,1)
        sut.remove(0)
        assertTrue(sut.getAll().isEmpty())
    }

    @Test
    fun `Removing something that does not exist does nothing`() {
        val sut = createSystemUnderTest()
        sut.remove(0)
        assertTrue(sut.getAll().isEmpty())
    }

}