package com.example.demo

interface Testable<T> {
    fun createSystemUnderTest(): T
}