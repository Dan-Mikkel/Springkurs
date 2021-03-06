package com.example.demo.cart

import com.example.demo.Catalog
import com.example.demo.delivery.DeliveryService
import com.example.demo.tax.TaxService
import org.springframework.stereotype.Controller
import org.springframework.ui.Model
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RequestParam

@Controller
class CartController(
        private val catalog: Catalog,
        private val cartService: CartService,
        private val taxService: TaxService,
        private val deliveryService: DeliveryService) {

    @get:GetMapping("/")
    val showCatalog: String = "catalog"

    private val showCart = "cart"

    @RequestMapping("/addItemToCart")
    fun addItemToCart(model: Model, @RequestParam("id") id: Int, @RequestParam("quantity") quantity: Int): String {

        cartService.addItemToCart(id, quantity)
        model.addAttribute("message",
                java.lang.String.format("Added to cart: %s [x%d]", catalog[id]?.description ?: "", quantity))

        return showCatalog
    }

    @RequestMapping("/showCart")
    fun showCart(model: Model): String {
        model.addAttribute("cart", cartService.getAllItemsInCart())
        val cartCost = cartService.calculateCartCost()
        model.addAttribute("cartCost", java.lang.String.format("£%.2f", cartCost))
        model.addAttribute("salesTax", java.lang.String.format("£%.2f", taxService.calculateSalesTax(cartCost)))
        model.addAttribute("deliveryCharge", java.lang.String.format("£%.2f", deliveryService.calculateDeliveryCharge(cartCost)))
        return showCart
    }

    @RequestMapping("/removeItemFromCart")
    fun removeItemFromCart(model: Model, @RequestParam("id") id: Int): String {
        cartService.removeItemFromCart(id)
        return showCart(model)
    }
}