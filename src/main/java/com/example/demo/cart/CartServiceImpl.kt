package com.example.demo.cart

import com.example.demo.Catalog
import com.example.demo.delivery.DeliveryService
import com.example.demo.tax.TaxService
import org.springframework.beans.factory.annotation.Value
import org.springframework.stereotype.Service

@Service
class CartServiceImpl(
        private val cartRepository: CartRepository,
        @Value("#{catalog}")
        private val catalog: Catalog) : CartService, TaxService, DeliveryService {

    @Value("\${contactEmail}")
    private var contactEmail = ""

    @Value("\${onlineRetailer.salesTaxRate}")
    private var salesTaxRate = 0.0

    @Value("\${onlineRetailer.deliveryCharge.normal}")
    private var standardDeliveryCharge = 0.0

    @Value("\${onlineRetailer.deliveryCharge.threshold}")
    private var deliveryChargeThreshold = 0.0

    override fun addItemToCart(id: Int, quantity: Int) {
        val oldQuantity = cartRepository.getAll()[id] ?: 0

        cartRepository.add(id, oldQuantity + quantity)
    }

    override fun removeItemFromCart(id: Int) {
        cartRepository.remove(id)
    }

    override fun getAllItemsInCart(): Map<Int, Int> {
        return cartRepository.getAll()
    }

    override fun calculateCartCost(): Double {
        val items = getAllItemsInCart()
        return when {
            items.isNotEmpty() -> items.entries
                    .map { (catalog[it.key]?.price ?: 0.0) * it.value }
                    .reduce { acc, number -> return acc + number }
            else -> 0.0
        }

    }

    override fun calculateSalesTax(cost: Double) = cost * salesTaxRate

    override fun calculateDeliveryCharge(cost: Double) = when {
        (cost == 0.0 || cost >= deliveryChargeThreshold) -> 0.0
        else -> standardDeliveryCharge
    }
}

