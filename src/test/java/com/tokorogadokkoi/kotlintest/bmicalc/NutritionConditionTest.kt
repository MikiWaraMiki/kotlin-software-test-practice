package com.tokorogadokkoi.kotlintest.bmicalc

import io.kotest.core.spec.style.FunSpec
import io.kotest.datatest.withData
import io.kotest.matchers.shouldBe

class NutritionConditionTest : FunSpec({
    context("BMI から栄養状態の判定") {
        data class Param(val bmi: Bmi, val expected: NutritionCondition)

        withData(
            mapOf(
                "BMI = 0.1 の場合" to Param(Bmi(0.1), NutritionCondition.UNDER_WEIGHT),
                "BMI = 14.0 の場合" to Param(Bmi(14.0), NutritionCondition.UNDER_WEIGHT),
                "BMI = 18.4 の場合" to Param(Bmi(18.4), NutritionCondition.UNDER_WEIGHT),

                "BMI = 18.5 の場合" to Param(Bmi(18.5), NutritionCondition.NORMAL_WEIGHT),
                "BMI = 20.0 の場合" to Param(Bmi(20.0), NutritionCondition.NORMAL_WEIGHT),
                "BMI = 24.9 の場合" to Param(Bmi(24.9), NutritionCondition.NORMAL_WEIGHT),

                "BMI = 30.0 の場合" to Param(Bmi(30.0), NutritionCondition.OBESITY_CLASS1),
                "BMI = 32.0 の場合" to Param(Bmi(32.0), NutritionCondition.OBESITY_CLASS1),
                "BMI = 34.9 の場合" to Param(Bmi(34.9), NutritionCondition.OBESITY_CLASS1),

                "BMI = 35.0 の場合" to Param(Bmi(35.0), NutritionCondition.OBESITY_CLASS2),
                "BMI = 37.0 の場合" to Param(Bmi(37.0), NutritionCondition.OBESITY_CLASS2),
                "BMI = 39.9 の場合" to Param(Bmi(39.9), NutritionCondition.OBESITY_CLASS2),

                "BMI = 40.0 の場合" to Param(Bmi(40.0), NutritionCondition.OBESITY_CLASS3),
                "BMI = 60.0 の場合" to Param(Bmi(60.0), NutritionCondition.OBESITY_CLASS3),
                "BMI = 99.9 の場合" to Param(Bmi(99.9), NutritionCondition.OBESITY_CLASS3)
            )
        ) { (bmi, expected) ->
            NutritionCondition.from(bmi) shouldBe expected
        }
    }
})
