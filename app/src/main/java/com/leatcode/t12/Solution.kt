package com.leatcode.t12

import com.leatcode.util.print

fun main() {
    Solution().intToRoman(25).print()
}

class Solution {

    fun intToRoman(num: Int): String {
        val sb = StringBuilder()

        var current = num
        var pow = 1000
        for (i in 3 downTo 0) {
            val n = current / pow

            if (n > 0) {
                sb.appendRomanDigit(n, pow)
            }
            current %= pow
            pow /= 10
        }

        return sb.toString()
    }

    private fun StringBuilder.appendRomanDigit(n: Int, pow: Int) {
        when {
            n < 4 -> repeat(n) { append(Nums[1 * pow]) }
            n == 4 -> {
                append(Nums[1 * pow])
                append(Nums[5 * pow])
            }
            n in 5..8 -> {
                append(Nums[5 * pow])
                repeat(n - 5) {
                    append(Nums[1 * pow])
                }
            }
            n == 9 -> {
                append(Nums[1 * pow])
                append(Nums[10 * pow])
            }
        }
    }

    companion object {
        private val Nums = mutableMapOf(
            1 to "I",
            5 to "V",
            10 to "X",
            50 to "L",
            100 to "C",
            500 to "D",
            1000 to "M"
        )
    }
}