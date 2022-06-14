package com.example.demo.impl

import com.example.demo.*
import org.springframework.beans.factory.annotation.Value
import org.springframework.stereotype.Service

@Service
class CartServiceImpl(
        private val cartRepository: CartRepository,
        @Value("#{catalog}")
        private val catalog: Map<ItemId, Item>) : CartService, TaxService, DeliveryService {

    @Value("\${contactEmail}")
    private var contactEmail = ""

    @Value("\${onlineRetailer.salesTaxRate}")
    private var salesTaxRate = 0.0

    @Value("\${onlineRetailer.deliveryCharge.normal}")
    private var standardDeliveryCharge = 0.0

    @Value("\${onlineRetailer.deliveryCharge.treshold}")
    private var deliveryChargeTreshold = 0.0

    override fun addItemToCart(id: Int, quantity: Int) {
        cartRepository.add(id, quantity)
    }

    override fun removeItemFromCart(id: Int) {
        cartRepository.remove(id)
    }

    override fun getAllItemsInCart(): Map<Int, Int> {
        return cartRepository.getAll()
    }

    override fun calculateCartCost(): Double =
        getAllItemsInCart().entries
                .map { (catalog[it.key]?.price ?: 0.0) * it.value}
                .reduce { acc, number ->  return acc+number}

    override fun calculateSalesTax(cost: Double) = cost * salesTaxRate

    override fun calculateDeliveryCharge(cost: Double): Double {
        if (cost == 0.0 || cost >= deliveryChargeTreshold) {
            return 0.0;
        }
        else {
            return standardDeliveryCharge;
        }
    }
}

