package com.tokorogadokkoi.kotlintest.bmicalc

import kotlin.math.floor

data class Bmi(
    private val value: Double
) {
    init {
        if (value <= 0 || value >= 100) {
            throw IllegalArgumentException()
        }
    }

    fun asValue(): Double {
        return floor(value * 10.0) / 10.0
    }
}
