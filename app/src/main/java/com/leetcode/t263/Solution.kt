package com.leetcode.t263

class Solution {
    fun isUgly(n: Int): Boolean {
        if (n <= 0) return false

        return isUgly(n, 2, 3, 5)
    }

    private fun isUgly(n: Int, vararg factors: Int): Boolean {
        var x = n
        for (factor in factors) {
            while (x % factor == 0 && x != 1) x /= factor
        }
        return x == 1
    }
}