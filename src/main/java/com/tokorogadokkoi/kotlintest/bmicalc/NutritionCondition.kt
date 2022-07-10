package com.tokorogadokkoi.kotlintest.bmicalc

enum class NutritionCondition(private val range: BmiRange) {

    /**
     * 痩せ
     */
    UNDER_WEIGHT(BmiRange(Bmi(0.1), Bmi(18.4)) ),

    /**
     * 標準
     */
    NORMAL_WEIGHT(BmiRange(Bmi(18.5), Bmi(24.9))),

    /**
     * 前肥満
     */
    PRE_OBESITY(BmiRange(Bmi(25.0), Bmi(29.9))),

    /**
     * 肥満度1
     */
    OBESITY_CLASS1(BmiRange(Bmi(30.0), Bmi(34.9))),

    /**
     * 肥満度2
     */
    OBESITY_CLASS2(BmiRange(Bmi(35.0), Bmi(39.9))),

    /**
     * 肥満度3
     */
    OBESITY_CLASS3(BmiRange(Bmi(40.0), Bmi(99.9)));

    fun isMatch(bmi: Bmi): Boolean {
        return range.contains(bmi)
    }

    companion object {
        fun from(bmi: Bmi): NutritionCondition {
            return values().find { it.isMatch(bmi) } ?: throw NoSuchElementException()
        }
    }
}

private data class BmiRange(
    private val min: Bmi,
    private val max: Bmi
) {
    fun contains(other: Bmi): Boolean {
        return other.asValue() in min.asValue()..max.asValue()
    }
}