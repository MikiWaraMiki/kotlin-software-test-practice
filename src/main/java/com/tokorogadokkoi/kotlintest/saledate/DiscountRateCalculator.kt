package com.tokorogadokkoi.kotlintest.saledate

import java.time.LocalDate

class DiscountRateCalculator {
    fun calc(buyDate: LocalDate): DiscountRate {
        val saleDateType = SaleDateType.values().find { it.contains(buyDate) }
            ?: return DiscountRate.NONE

        return saleDateType.discountRate
    }
}