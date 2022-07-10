package com.tokorogadokkoi.kotlintest.saledate

enum class DiscountRate(private val rate: Double) {
    DISCOUNT_DEFAULT(20.0),
    NONE(0.0);
}