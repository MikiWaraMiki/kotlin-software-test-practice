package com.tokorogadokkoi.kotlintest.clothprice

import kotlin.math.floor

data class Meter(
    private val value: Double
) {
    init {
        if (value !in MIN_VALUE..MAX_VALUE) {
            throw IllegalArgumentException()
        }
    }

    fun asValue(): Double {
        return floor(value * 10.0) / 10.0
    }

    companion object {
        private const val MIN_VALUE = 0.1
        private const val MAX_VALUE = 100.0
    }
}