package com.tokorogadokkoi.kotlintest.saledate

import java.time.LocalDate

enum class SaleDateType(private val range: IntRange, val discountRate: DiscountRate) {
    FIRST_OF_MONTH(IntRange(1, 5), DiscountRate.DISCOUNT_DEFAULT),
    END_OF_MONTH(IntRange(28, 31), DiscountRate.DISCOUNT_DEFAULT);

    fun contains(date: LocalDate): Boolean {
        return range.contains(date.dayOfMonth)
    }
}