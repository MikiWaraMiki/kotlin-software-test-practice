package com.tokorogadokkoi.kotlintest.kitchenscale1

import io.kotest.core.spec.style.FunSpec
import io.kotest.datatest.withData
import io.kotest.matchers.shouldBe

class KitchenScaleTest : FunSpec({
    data class Param(val weight: Weight, val expected: String)
    val kitchenScale = KitchenScale()

    context("重さが 0g 未満の場合") {
        withData(
            mapOf(
                "-1（境界値）" to Param(Weight(-1), "EEEE"),
                "-10（代表値）" to Param(Weight(-10), "EEEE")
            )
        ) { (weight, expected) ->
            kitchenScale.calc(weight) shouldBe expected
        }
    }

    context("重さが 2000g を超えている場合") {
        withData(
            mapOf(
                "2001 (境界値）" to Param(Weight(2_001), "EEEE"),
                "2500（代表値）" to Param(Weight(2_500), "EEEE")
            )
        ) { (weight, expected) ->
            kitchenScale.calc(weight) shouldBe expected
        }
    }

    context("重さが 0g ~ 2000g の間の場合") {
        withData(
            mapOf(
                "0（境界値_下限）" to Param(Weight(0), "0g"),
                "1000（代表値）" to Param(Weight(1_000), "1000g"),
                "2000（境界値_上限）" to Param(Weight(2_000), "2000g")
            )
        ) { (weight, expected) ->
            kitchenScale.calc(weight) shouldBe expected
        }
    }
})
