package com.leatcode.t1025

import com.leatcode.util.print

fun main() {
    Solution().divisorGame(5).print()
}

class Solution {
    fun divisorGame(n: Int): Boolean {
        val dp = BooleanArray(n + 1)
        dp[0] = false

        for (i in 1..n) {
            dp[i] = false
            for (d in 1..i / 2) {
                if (i % d == 0 && !dp[i-d]) {
                    dp[i] = true
                    break
                }
            }
        }

        return dp[n]
    }
}