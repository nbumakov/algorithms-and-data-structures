package com.leatcode.t518

import com.leatcode.util.print

fun main() {
    Solution().change(5, intArrayOf(1, 2, 5))
        .print()
}

class Solution {

    fun change(amount: Int, coins: IntArray): Int {
        val dp = Array(coins.size + 1) { IntArray(amount + 1) }

        for (i in coins.indices) {
            dp[i][0] = 1
        }

        for (i in 1..amount) {
            dp[0][i] = 0
        }

        for (i in coins.lastIndex downTo 0) { // coins to consider
            for (j in 1..amount) {
                if (coins[i] > j) {
                    dp[i][j] = dp[i + 1][j]
                } else {
                    dp[i][j] = dp[i + 1][j] + dp[i][j - coins[i]];
                }
            }
        }

        return dp[0][amount]
    }


    // recursion + memo = TLE
    fun change_rec(amount: Int, coins: IntArray): Int {

        val cache = Array(coins.size) { IntArray(amount + 1) { -1 } }

        fun numberOfWays(i: Int, j: Int /* amount left */): Int = when {
            j == 0 -> 1
            i == coins.size -> 0
            cache[i][j] > 0 -> cache[i][j]
            coins[i] > j -> numberOfWays(i + 1, j).also { cache[i][j] = it }
            else -> (numberOfWays(i, j - coins[i]) + numberOfWays(i + 1, j))
                .also { cache[i][j] = it }
        }

        return numberOfWays(0, amount)
    }

}
// 1 = 1
// 1+1, 2 = 2
// 1+1+1, 2+1, 1+2