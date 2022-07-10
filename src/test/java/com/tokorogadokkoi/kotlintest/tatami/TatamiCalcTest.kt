package com.tokorogadokkoi.kotlintest.tatami

import io.kotest.assertions.throwables.shouldNotThrow
import io.kotest.assertions.throwables.shouldThrow
import io.kotest.core.spec.style.FunSpec
import io.kotest.datatest.withData
import io.kotest.matchers.shouldBe

class TatamiCalcTest : FunSpec({
    context("入力値の検証") {
        test("-128 はエラーになる") {
            shouldThrow<IllegalArgumentException> {
                Nums(-128)
            }
        }
        test("0 はエラーになる") {
            shouldThrow<IllegalArgumentException> {
                Nums(0)
            }
        }
        test("1 はエラーにならない") {
            shouldNotThrow<IllegalArgumentException> {
                Nums(1)
            }
        }
        test("127 はエラーにならない") {
            shouldNotThrow<IllegalArgumentException> {
                Nums(127)
            }
        }
    }

    context("面積の計算") {
        data class Param(val nums: Nums, val expected: Double)
        val calc = TatamiCalc()
        withData(
            mapOf(
                "1畳の場合" to Param(Nums(1), 1.65),
                "10畳の場合" to Param(Nums(10), 16.5),
                "127畳の場合" to Param(Nums(127), 209.55)
            )
        ) { (nums, expected) ->
            calc.apply(nums) shouldBe expected
        }
    }
})
