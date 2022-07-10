package com.tokorogadokkoi.kotlintest.kitchenscale1

data class Weight(
    val value: Int
)

class KitchenScale {

    fun calc(weight: Weight): String {
       return  when {
            weight.value < MIN_VALUE -> ERROR_DISPLAY_CHAR
            weight.value > MAX_VALUE -> ERROR_DISPLAY_CHAR
            else -> "${weight.value.toString()}g"
        }
    }

    companion object {
        private val ERROR_DISPLAY_CHAR = "EEEE"
        private val MIN_VALUE = 0
        private val MAX_VALUE = 2_000
    }
}