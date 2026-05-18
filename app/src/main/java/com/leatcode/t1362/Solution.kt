package com.leatcode.t1362

import com.leatcode.util.print
import kotlin.math.abs
import kotlin.math.sqrt

fun main() {
    Solution()
        .closestDivisors(1000000000)
        .print()
}

class Solution {
    fun closestDivisors(num: Int): IntArray {
        fun getClosestPair(num: Int): IntArray {
            val dividers = hashSetOf<Int>()
            for (k in 1..sqrt(num.toDouble()).toInt()) {
                if (num % k == 0) dividers.add(k)
            }
            return dividers.map { intArrayOf(it, num / it) }.minBy { it.diff() }!!
        }

        return listOf(getClosestPair(num + 1), getClosestPair(num + 2))
            .minBy { it.diff() }!!
    }

    private fun IntArray.diff() = abs(first() - last())
}