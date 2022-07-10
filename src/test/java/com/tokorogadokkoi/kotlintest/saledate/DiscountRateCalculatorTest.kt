package com.tokorogadokkoi.kotlintest.saledate

import io.kotest.core.spec.style.FunSpec
import io.kotest.datatest.withData
import io.kotest.matchers.shouldBe
import java.time.LocalDate

class DiscountRateCalculatorTest : FunSpec({

    context("割引率の算出") {
        data class Param(val buyDate: LocalDate, val expected: DiscountRate)
        val calculator = DiscountRateCalculator()
        withData(
            mapOf(
                "1日" to Param(LocalDate.of(2022, 7, 1), DiscountRate.DISCOUNT_DEFAULT),
                "3日" to Param(LocalDate.of(2022, 7, 3), DiscountRate.DISCOUNT_DEFAULT),
                "5日" to Param(LocalDate.of(2022, 7, 5), DiscountRate.DISCOUNT_DEFAULT),

                "6日" to Param(LocalDate.of(2022, 7, 6), DiscountRate.NONE),
                "20日" to Param(LocalDate.of(2022, 7, 20), DiscountRate.NONE),
                "27日" to Param(LocalDate.of(2022, 7, 27), DiscountRate.NONE),

                "28日" to Param(LocalDate.of(2022, 2, 28), DiscountRate.DISCOUNT_DEFAULT),
                "30日" to Param(LocalDate.of(2022, 7, 30), DiscountRate.DISCOUNT_DEFAULT),
                "31日" to Param(LocalDate.of(2022, 7, 31), DiscountRate.DISCOUNT_DEFAULT)
            )
        ) { (buyDate, expected) ->
            val result = calculator.calc(buyDate)
            result shouldBe expected
        }
    }
})
