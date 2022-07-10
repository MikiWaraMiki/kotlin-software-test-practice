package com.tokorogadokkoi.kotlintest.temperature1

data class Temperature(
    private val value: Double
) {
    fun asValue(): Double {
        return Math.round(value * 10) / 10.0
    }
}

enum class TemperatureDisplayType(private val min: Double, private val max: Double) {
    COLD(-1 * Double.MAX_VALUE, 23.9),
    SUITABLE(24.0, 25.9),
    HOT(26.0, Double.MAX_VALUE);

    fun contains(value: Double): Boolean {
        return value in min..max
    }

    companion object {
        fun from(temperature: Temperature): TemperatureDisplayType {
            return values().find { it -> it.contains(temperature.asValue()) } ?: throw IllegalArgumentException()
        }
    }
}