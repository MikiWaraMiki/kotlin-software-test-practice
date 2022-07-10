package com.tokorogadokkoi.kotlintest.admissionfee

enum class FeeTable(private val minAge: Int, private val maxAge: Int, val fee: Int) {
    FREE(0, 5, 0),
    CHILD(6, 12, 500),
    JUNIOR(13, 17, 1_000),
    ADULT(18, 120, 1_500);

    fun contains(age: Int): Boolean {
        return age in minAge..maxAge
    }

    companion object {
        fun getPrice(age: Int): Int {
            val matched = values().find { it.contains(age) } ?: throw NoSuchElementException()
            return matched.fee
        }
    }
}