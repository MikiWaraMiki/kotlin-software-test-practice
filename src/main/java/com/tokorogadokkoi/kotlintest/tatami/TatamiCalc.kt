package com.tokorogadokkoi.kotlintest.tatami

import java.math.BigDecimal
import java.math.RoundingMode

class TatamiCalc {
    fun apply(nums: Nums): Double {
        val decimal = BigDecimal.valueOf(nums.asDouble())
        return decimal.times(AREA_PER_ONE.toBigDecimal()).toDouble()
    }

    companion object {
        private const val AREA_PER_ONE = 1.65
    }
}

/**
 * 畳数
 */
data class Nums(val value: Byte) {
    init {
        if (value <= MIN_VALUE) {
            throw IllegalArgumentException()
        }
    }

    fun asDouble(): Double {
        return value.toDouble()
    }

    companion object {
        private const val MIN_VALUE: Byte = 0
    }
}