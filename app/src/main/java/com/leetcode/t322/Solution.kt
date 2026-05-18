package com.leetcode.t322

import com.leetcode.util.print

fun main() {
    Solution().coinChange(intArrayOf(1, 2, 5), 11).print()
}

class Solution {
    fun coinChange(coins: IntArray, amount: Int): Int {
        val dp = IntArray(amount + 1) { Int.MAX_VALUE }
        dp[0] = 0

        for (i in 1..dp.lastIndex) {
            for (coin in coins) {
                if (coin > i) continue
                if (dp[i - coin] < dp[i]) {
                    dp[i] = dp[i - coin] + 1
                }
            }
        }

        return dp[amount].takeIf { it != Int.MAX_VALUE } ?: -1
    }
}