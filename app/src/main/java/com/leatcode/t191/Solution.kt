package com.leatcode.t191

import com.leatcode.util.print

fun main() {
//    Solution().hammingWeight(0b11111111111111111111111111111101).print()
//    Solution().hammingWeight1(0b11111111111111111111111111111101).print()
}

class Solution {

    // you need treat n as an unsigned value
    fun hammingWeight(n: Int): Int {
        var x = n
        var ones = 0
        while (x != 0) {
            if (x and 1 == 1) ones++
            x = x ushr 1
        }

        return ones
    }

    // you need treat n as an unsigned value
    fun hammingWeight1(n: Int): Int = n.countOneBits()

    fun hammingWeightSD(n: Int): Int {
        val dp = IntArray(256).apply {
            for (i in 1 until size)
                this[i] = this[i / 2] + (i and 1)
        }

        return dp[n and 255] + dp[(n ushr 8) and 255] + dp[(n ushr 16) and 255] + dp[(n ushr 24) and 255]
    }
}