package com.leetcode.t121

import com.leetcode.util.print

fun main() {
    Solution().maxProfit(intArrayOf(7, 1, 5, 3, 6, 4)).print()
}

class Solution {

    fun maxProfit(prices: IntArray): Int {
        var min = prices[0]
        var profit = 0

        prices.forEach {
            if (it < min) min = 0
            profit = maxOf(profit, it - min)
        }

        return profit
    }

    fun maxProfitSimple(prices: IntArray): Int {
        var max = Int.MIN_VALUE
        val maxs = IntArray(prices.size)

        for (i in prices.size - 1 downTo 0) {
            if (prices[i] > max) max = prices[i]
            maxs[i] = max
        }

        return prices
            .withIndex()
            .maxBy { maxs[it.index] - it.value }
            .let { maxs[it.index] - it.value }
    }

}