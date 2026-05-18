package com.leetcode.t1732

import com.leetcode.util.print

fun main() {
    Solution().largestAltitude(intArrayOf(-5, 1, 5, 0, -7)).print()
}

class Solution {

    fun largestAltitude(gain: IntArray): Int = gain
        .fold(0 to 0) { (max, current), change ->
            (current + change).let { maxOf(it, max) to it }
        }.first

    fun largestAltitude2(gain: IntArray): Int = gain
        .fold(Altitude()) { alt, change ->
            alt.apply {
                current += change
                max = maxOf(current, max)
            }
        }
        .max

    private class Altitude(
        var current: Int = 0,
        var max: Int = 0
    )
}