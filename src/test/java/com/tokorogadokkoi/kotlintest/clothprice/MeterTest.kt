package com.tokorogadokkoi.kotlintest.clothprice

import io.kotest.assertions.throwables.shouldNotThrow
import io.kotest.assertions.throwables.shouldThrow
import io.kotest.core.spec.style.FunSpec
import io.kotest.datatest.withData
import io.kotest.matchers.shouldBe

class MeterTest : FunSpec({
    context("不変条件") {
        test("0.1未満") {
            shouldThrow<IllegalArgumentException> {
                Meter(0.0)
            }
        }
        test("100.0を超える値") {
            shouldThrow<IllegalArgumentException> {
                Meter(100.1)
            }
        }
        test("0.1 ~ 100.0 の範囲") {
            shouldNotThrow<IllegalArgumentException> {
                Meter(0.1)
                Meter(50.0)
                Meter(100.0)
            }
        }
    }
    context("小数2桁目の切り捨て出力") {
        data class Param(val input: Double, val expected: Double)
        withData(
            mapOf(
                "1.60の場合" to Param(1.60, 1.60),
                "1.65の場合" to Param(1.65, 1.60)
            )
        ) { (input, expected) ->
            val meter = Meter(input)
            meter.asValue() shouldBe expected
        }
    }
})
