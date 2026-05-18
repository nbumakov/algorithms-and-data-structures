package com.leetcode.t7020

import com.leetcode.util.print

fun main() {
    Solution().countSymmetricIntegers(1200, 1230).print()
}

class Solution {
    fun countSymmetricIntegers(low: Int, high: Int): Int =
        (low..high).count { it.isSymmetric() }

    private fun Int.isSymmetric(): Boolean {
        val s = this.toString()
        if (s.length % 2 != 0) return false
        return s.toCharArray()
            .let { digits ->
                digits.take(s.length / 2).map { it - '0' }.sum() ==
                        digits.takeLast(s.length / 2).map { it - '0' }.sum()
            }
    }
}