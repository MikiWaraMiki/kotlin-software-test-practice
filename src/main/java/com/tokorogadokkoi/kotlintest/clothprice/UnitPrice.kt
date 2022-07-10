package com.tokorogadokkoi.kotlintest.clothprice

enum class UnitPrice(val price: Int) {
    DEFAULT(400),
    DISCOUNT(350);

    companion object {
        private val DISCOUNT_METER = Meter(3.0)

        /**
         * 指定した生地の長さから適用される単価を取得します
         * @param meter 生地の長さ
         * @return 生地の単価
         */
        fun from(meter: Meter): UnitPrice {
            return when {
                meter.asValue() > DISCOUNT_METER.asValue() -> DISCOUNT
                else -> DEFAULT
            }
        }
    }
}