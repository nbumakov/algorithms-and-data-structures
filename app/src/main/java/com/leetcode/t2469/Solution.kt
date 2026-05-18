package com.leetcode.t2469

class Solution {
    fun convertTemperature(celsius: Double): DoubleArray =
        doubleArrayOf(
            celsius + 273.15,
            celsius * 1.80 + 32.00
        )
}