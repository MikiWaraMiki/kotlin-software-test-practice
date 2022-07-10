package com.tokorogadokkoi.kotlintest.clothprice

import io.kotest.core.spec.style.FunSpec
import io.kotest.datatest.withData
import io.kotest.matchers.shouldBe

class UnitPriceTest : FunSpec({
    context("生地の単価取得") {
        data class Param(val meter: Meter, val expected: UnitPrice)

        withData(
            mapOf(
                "生地の長さが 0.1" to Param(Meter(0.1), UnitPrice.DEFAULT),
                "生地の長さが 1.0" to Param(Meter(1.0), UnitPrice.DEFAULT),
                "生地の長さが 3.0" to Param(Meter(3.0), UnitPrice.DEFAULT),
                "生地の長さが 3.1" to Param(Meter(3.1), UnitPrice.DISCOUNT),
                "生地の長さが 5.0" to Param(Meter(5.0), UnitPrice.DISCOUNT),
                "生地の長さが 100.0" to Param(Meter(100.0), UnitPrice.DISCOUNT)
            )
        ) { (meter, expected) ->
            UnitPrice.from(meter) shouldBe expected
        }
    }
})
