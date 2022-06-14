package com.example.demo

import org.springframework.boot.SpringApplication
import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Scope

@SpringBootApplication
class DemoApplication {
    @Bean
    @Scope("application")
    fun catalog(): Map<ItemId, Item> {
        val items: MutableMap<Int, Item> = HashMap()
        items[0] = Item(0, "Apple Mac Book Pro", 2499.99)
        items[1] = Item(1, "32GB San Disk", 15.99)
        items[2] = Item(2, "OLED 64in TV", 1800.99)
        items[3] = Item(3, "Wireless Mouse", 10.59)
        items[4] = Item(4, "Virtual Reality HeadSet", 200.59)
        items[5] = Item(5, "Sat Nav", 159.99)
        return items
    }

}

fun main(args: Array<String>) {
    SpringApplication.run(DemoApplication::class.java, *args)
}