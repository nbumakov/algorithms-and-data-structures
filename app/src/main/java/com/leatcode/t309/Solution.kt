package com.leatcode.t309

class Solution {

    // TODO: DP?

    // dfs + memo
    fun maxProfit(prices: IntArray): Int {
        val cache = hashMapOf<Triple<Int, Int, Boolean>, Int>()

        fun dfs(i: Int, coolDown: Int, hasStock: Boolean): Int {
            if (i > prices.lastIndex) return 0

            return cache.getOrPut(Triple(i, coolDown, hasStock)) {
                when {
                    coolDown > 0 -> dfs(i + 1, coolDown - 1, false)
                    hasStock -> maxOf(prices[i] + dfs(i + 1, 1, false), dfs(i + 1, 0, true))
                    else -> maxOf(-prices[i] + dfs(i + 1, 0, true), dfs(i + 1, 0, false))
                }
            }
        }

        return dfs(0, 0, false)
    }
}