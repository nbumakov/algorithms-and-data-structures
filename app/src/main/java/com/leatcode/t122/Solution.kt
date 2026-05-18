package com.leatcode.t122

class Solution {
    fun maxProfit(prices: IntArray): Int {
        var profit = 0
        for (i in 0 until prices.lastIndex) {
            profit += (prices[i + 1] - prices[i]).coerceAtLeast(0)
        }
        return profit
    }
}