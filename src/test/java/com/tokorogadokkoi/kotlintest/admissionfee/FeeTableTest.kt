package com.tokorogadokkoi.kotlintest.admissionfee

import io.kotest.assertions.throwables.shouldThrow
import io.kotest.core.spec.style.FunSpec
import io.kotest.datatest.withData
import io.kotest.matchers.shouldBe

class FeeTableTest : FunSpec({
    context("料金の取得") {
        data class Param(val age: Int, val expected: Int)

        context("6歳未満") {
            withData(
                mapOf(
                    "age is 0" to Param(0, 0),
                    "age is 3" to Param(3, 0),
                    "age is 5" to Param(5, 0)
                )
            ) { (age, expected) ->
                FeeTable.getPrice(age) shouldBe expected
            }
        }

        context("6歳以上13歳未満") {
            withData(
                mapOf(
                    "age is 6" to Param(6, 500),
                    "age is 10" to Param(10, 500),
                    "age is 12" to Param(12, 500)
                )
            ) { (age, expected) ->
                FeeTable.getPrice(age) shouldBe expected
            }
        }

        context("13歳以上18歳未満") {
            withData(
                mapOf(
                    "age is 13" to Param(13, 1_000),
                    "age is 15" to Param(15, 1_000),
                    "age is 17" to Param(17, 1_000)
                )
            ) { (age, expected) ->
                FeeTable.getPrice(age) shouldBe expected
            }
        }

        context("18歳以上") {
            withData(
                mapOf(
                    "age is 18" to Param(18, 1_500),
                    "age is 100" to Param(100, 1_500),
                    "age is 120" to Param(120, 1_500)
                )
            ) { (age, expected) ->
                FeeTable.getPrice(age) shouldBe expected
            }
        }

        context("無効値") {
            withData(
                mapOf(
                    "年齢がマイナス" to listOf(-1, -10),
                    "年齢が120を超える" to listOf(121, 130)
                )
            ) { (value) ->
                shouldThrow<NoSuchElementException> {
                    FeeTable.getPrice(value)
                }
            }
        }
    }
})
