package com.tokorogadokkoi.kotlintest.temperature1

import io.kotest.core.spec.style.FunSpec
import io.kotest.datatest.withData
import io.kotest.matchers.shouldBe

class PetTemperatureTest : FunSpec({
    data class Param(val temperature: Temperature, val expected: TemperatureDisplayType)
    context("温度から表示種別の生成") {
        withData(
            mapOf(
                "20.0（代表値）" to Param(Temperature(0.0), TemperatureDisplayType.COLD),
                "23.9（境界値）" to Param(Temperature(23.9), TemperatureDisplayType.COLD),
                "24.0（境界値）" to Param(Temperature(24.0), TemperatureDisplayType.SUITABLE),
                "25.0（代表値）" to Param(Temperature(25.0), TemperatureDisplayType.SUITABLE),
                "25.9（境界値）" to Param(Temperature(25.9), TemperatureDisplayType.SUITABLE),
                "26.0（境界値）" to Param(Temperature(26.0), TemperatureDisplayType.HOT),
                "30.0（代表値）" to Param(Temperature(30.0), TemperatureDisplayType.HOT)
            )
        ) { (temperature, expected) ->
            TemperatureDisplayType.from(temperature) shouldBe expected
        }
    }
})
