package com.leatcode.t45

import com.leatcode.util.print

fun main() {
    Solution().jump(intArrayOf(5, 9, 3, 2, 1, 0, 2, 3, 3, 1, 0, 0)).print()
}

class Solution {
    fun jump(nums: IntArray): Int {
        val dp = IntArray(nums.size)
        for (i in nums.lastIndex - 1 downTo 0) {
            val range = i + 1..(i + nums[i]).coerceAtMost(nums.lastIndex)
            val min = dp.slice(range).min() ?: Int.MAX_VALUE
            dp[i] = when (min) {
                Int.MAX_VALUE -> Int.MAX_VALUE
                else -> min + 1
            }
        }
        return dp[0]
    }
}