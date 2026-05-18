package com.leetcode.t714

import com.leetcode.util.print


fun main() {
    Solution().maxProfit(intArrayOf(1, 3, 2, 8, 4, 9), 2).print()
}

class Solution {

    // DP
    fun maxProfit(prices: IntArray, fee: Int): Int {
        val dp = Array(2) { IntArray(prices.size + 1) } // 1 - has stock, 0 - no stock

        for (j in prices.lastIndex downTo 0) {
            dp[1][j] = maxOf(dp[0][j + 1] + prices[j] - fee, dp[1][j + 1]) // продать и заплатить или держать
            dp[0][j] = maxOf(dp[1][j + 1] - prices[j], dp[0][j + 1]) // купить или ничего не делать
        }

        return dp[0][0]
    }

    // dfs + memo
    fun maxProfit1(prices: IntArray, fee: Int): Int {

        val noStockCache = hashMapOf<Int, Int>()
        val stockCache = hashMapOf<Int, Int>()

        fun dfs(i: Int, hasStock: Boolean): Int {
            if (i == prices.size) {
                return 0
            }

            return if (hasStock) {
                stockCache.getOrPut(i) {
                    maxOf(
                        dfs(i + 1, false) + prices[i] - fee,
                        dfs(i + 1, true)
                    )
                }
            } else {
                noStockCache.getOrPut(i) {
                    maxOf(
                        dfs(i + 1, true) - prices[i],
                        dfs(i + 1, false)
                    )
                }
            }
        }

        return dfs(0, false)
    }
}