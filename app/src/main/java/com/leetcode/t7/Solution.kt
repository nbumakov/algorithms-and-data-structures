package com.leetcode.t7

import com.leetcode.util.print
import kotlin.math.abs

fun main() {
    Solution().reverse(-123).print()
}

class Solution {
    fun reverse(x: Int): Int {
        if (x == Int.MIN_VALUE) return 0
        var n = abs(x)
        var res = 0
        while (n != 0) {
            val t = n % 10
            n /= 10
            if (res > Int.MAX_VALUE / 10 || res == Int.MAX_VALUE / 10 && t > 7)
                return 0
            res = 10 * res + t
        }

        if (x < 0) res *= -1

        return res
    }
}