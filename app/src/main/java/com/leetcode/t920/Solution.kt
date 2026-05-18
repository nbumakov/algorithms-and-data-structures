package com.leetcode.t920

class Solution {


    // TODO: not mine
    fun numMusicPlaylists(n: Int, goal: Int, k: Int): Int {
        // Initialize the DP table
        val dp = Array(goal + 1) { LongArray(n + 1) }
        dp[0][0] = 1
        for (i in 1..goal) {
            for (j in 1..i.coerceAtMost(n)) {
                // The i-th song is a new song
                dp[i][j] = dp[i - 1][j - 1] * (n - j + 1) % MOD
                // The i-th song is a song we have played before
                if (j > k) {
                    dp[i][j] = (dp[i][j] + dp[i - 1][j] * (j - k)) % MOD
                }
            }
        }
        return dp[goal][n].toInt()
    }

    companion object {
        private const val MOD = 1000000007
    }
}