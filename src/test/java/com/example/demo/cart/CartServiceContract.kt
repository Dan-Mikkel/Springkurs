package com.example.demo.cart

import com.example.demo.Testable
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.assertAll
import kotlin.test.assertEquals
import kotlin.test.assertTrue

interface CartServiceContract: Testable<CartService> {
    @Test
    fun `getAllItemsInCart returns an empty map when nothing has been added`() {
        val sut = createSystemUnderTest()
        assertTrue(sut.getAllItemsInCart().isEmpty())
    }

    @Test
    fun `Check that we can add one item to the cart`() {
        val sut = createSystemUnderTest()
        sut.addItemToCart(0, 1)
        assertTrue(sut.getAllItemsInCart().size == 1)
    }

    @Test
    fun `See that what we added is persisted`() {
        val sut = createSystemUnderTest()
        val itemId = 0
        val itemQuantity = 1

        sut.addItemToCart(itemId, itemQuantity)

        val map = sut.getAllItemsInCart()
        assertAll("Map should contain our new key and it's original value",
                { assertTrue(map.containsKey(itemId)) },
                { assertEquals(map[0], itemQuantity) }
        )
    }

    @Test
    fun `See that we can remove an item we added`() {
        val sut = createSystemUnderTest()
        val itemId = 0
        val itemQuantity = 1

        sut.addItemToCart(itemId, itemQuantity)
        sut.addItemToCart(1, 3)
        sut.removeItemFromCart(0)
        assertTrue(sut.getAllItemsInCart().isEmpty())

    }

    @Test
    fun `See that removing a nonexistent item does nothing`() {
        val sut = createSystemUnderTest()
        sut.removeItemFromCart(0)
        assertTrue(sut.getAllItemsInCart().isEmpty())
    }

    fun `See that we sum up the total of all items in cart`() {
        val sut = createSystemUnderTest()
        //TODO: Dette her går jo ikke uten å binde komponenten TETT til et annet system... Nytt interface kanskje?
    }
}