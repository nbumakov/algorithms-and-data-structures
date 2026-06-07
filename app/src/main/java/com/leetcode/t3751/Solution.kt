package com.leetcode.t3751

class Solution {
    fun totalWaviness(num1: Int, num2: Int): Int =
        (num1..num2).sumOf { window ->
            window.toString()
                .windowed(3)
                .count {
                    it[1] < it[2] && it[1] < it[0] || it[1] > it[2] && it[1] > it[0]
                }
        }
}

class Solution2 {
    fun totalWaviness(num1: Int, num2: Int): Int =
        (num1.coerceAtLeast(100)..num2).sumOf(::waviness)

    private fun waviness(num: Int): Int {
        var x = num
        fun next() = (x % 10).also { x /= 10 }

        var d0 = next()
        var d1 = next()
        var count = 0
        while (x > 0) {
            val d2 = next()
            if (d1 < d0 && d1 < d2 || d1 > d0 && d1 > d2) count++
            d0 = d1
            d1 = d2
        }
        return count
    }
}