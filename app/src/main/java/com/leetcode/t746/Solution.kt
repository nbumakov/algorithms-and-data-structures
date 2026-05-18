package com.leetcode.t746

import com.leetcode.util.print

fun main() {
    Solution().minCostClimbingStairs(intArrayOf(10, 15, 20)).print()
}

class Solution {

    // dp
    fun minCostClimbingStairs2(cost: IntArray): Int {
        val dp = IntArray(cost.size + 1)
        for (i in 2..dp.lastIndex) {
            dp[i] += minOf(dp[i - 1] + cost[i - 1], dp[i - 2] + cost[i - 2])
        }
        return dp.last()
    }


    fun minCostClimbingStairs(cost: IntArray): Int {
        for (i in 2..cost.lastIndex) {
            cost[i] += minOf(cost[i - 1], cost[i - 2])
        }
        return cost.takeLast(2).min()!!
    }

    // rec + memo
    fun minCostClimbingStairsRec(cost: IntArray): Int {
        val cache = IntArray(cost.size + 1) { 0 }

        fun dp(i: Int): Int {
            if (i <= 1) return 0
            if (cache[i] > 0) return cache[i]

            return minOf(dp(i - 1) + cost[i - 1], dp(i - 2) + cost[i - 2])
                .also { cache[i] = it }
        }

        return dp(cost.size)
    }


}