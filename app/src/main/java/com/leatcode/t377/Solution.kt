package com.leatcode.t377

import com.leatcode.util.print

fun main() {
    Solution().combinationSum4(intArrayOf(1, 2, 3), 4).print()
//    Solution().combinationSum4(intArrayOf(2, 1, 3), 35).print()
}

class Solution {

    // 1, 2, 3  t = 4
    fun combinationSum4(nums: IntArray, target: Int): Int {
        val dp = IntArray(target + 1).apply { this[0] = 1 }

        for (value in 1..target) {
            for (num in nums) {
                if (value - num < 0) continue
                dp[value] += dp[value - num]
            }
        }

        return dp[target]
    }
}