package com.leatcode.t198

import com.leatcode.util.print

fun main() {
    Solution().rob(intArrayOf(2, 1, 1, 2)).print()
}

class Solution {

    // 2 1xDP
    fun rob(nums: IntArray): Int {
        if (nums.size <= 2) return maxOf(nums.first(), nums.last())

        val dp = IntArray(nums.size + 1)
        dp[dp.lastIndex] = 0
        dp[nums.lastIndex] = nums.last()
        for (i in nums.lastIndex - 1 downTo 0) {
            dp[i] = maxOf(nums[i] + dp[i + 2], dp[i + 1])
        }

        return dp.first()
    }

    // 1 rec + memo
    fun rob_2(nums: IntArray): Int {
        val cache = IntArray(nums.size) { -1 }
        fun rob(i: Int): Int {
            if (i > nums.lastIndex) return 0
            if (cache[i] > -1) return cache[i]

            // rob next house or current and i+2
            return maxOf(rob(i + 1), nums[i] + rob(i + 2))
                .also { cache[i] = it }
        }

        return rob(0)
    }
}