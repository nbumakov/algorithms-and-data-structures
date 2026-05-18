package com.leetcode.t67

import kotlin.math.max

fun main() {
    println(Solution().addBinary("1010", "1011"))
    println(Solution().addBinary("11", "11"))
}

class Solution {
    fun addBinary(a: String, b: String): String {
        var overflow = 0
        val maxLength = max(a.length, b.length)
        val reversedResultStringBuilder = StringBuilder()

        for (i in 1..maxLength) {
            val aDigit = if (i <= a.length) toInt(a[a.length - i]) else 0
            val bDigit = if (i <= b.length) toInt(b[b.length - i]) else 0
            val sum = aDigit + bDigit + overflow

            reversedResultStringBuilder.append(sum % 2)
            overflow = if (sum < 2) 0 else 1
        }

        if (overflow > 0) {
            reversedResultStringBuilder.append(overflow)
        }

        return reversedResultStringBuilder.reversed().toString()
    }

    private fun toInt(c: Char): Int = when (c) {
        '1' -> 1
        else -> 0
    }

    fun addBinary2(a: String, b: String): String {
        val result = StringBuilder()
        var overflow = 0
        var ap = a.lastIndex
        var bp = b.lastIndex

        fun String.getAt(position: Int): Int =
            if (position < 0) 0 else get(position).digitToInt()

        while (overflow > 0 || ap >= 0 || bp >= 0) {
            val aDigit = a.getAt(ap--)
            val bDigit = b.getAt(bp--)
            val sum = overflow + aDigit + bDigit
            result.append(sum % 2)
            overflow = if (sum >= 2) 1 else 0
        }

        return result.reversed().toString()
    }

}