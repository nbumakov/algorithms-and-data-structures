package com.leetcode.t1143

import com.leetcode.util.print

fun main() {
    Solution().apply {
        longestCommonSubsequence("abcde", "ace").print()
        longestCommonSubsequence("abc", "abc").print()
        longestCommonSubsequence("abc", "def").print()
        longestCommonSubsequence("bsbininm", "jmjkbkjkv").print()
    }
}

class Solution {

    // Top-Down + memo
    fun longestCommonSubsequence(text1: String, text2: String): Int {

        val cache = Array(text1.length) { IntArray(text2.length) { -1 } }

        fun dfs(i: Int, j: Int): Int {
            if (i < 0 || j < 0) return 0
            if (cache[i][j] >= 0) return cache[i][j]

            return (if (text1[i] == text2[j]) dfs(i - 1, j - 1) + 1
            else maxOf(dfs(i - 1, j), dfs(i, j - 1))).also { cache[i][j] = it }
        }

        return dfs(text1.lastIndex, text2.lastIndex)
    }

    // DP
    fun longestCommonSubsequence2(text1: String, text2: String): Int {
        val dp = Array(text1.length + 1) { IntArray(text2.length + 1) }

        for (i in text1.lastIndex downTo 0) {
            for (j in text2.lastIndex downTo 0) {
                dp[i][j] =
                    if (text1[i] == text2[j]) dp[i + 1][j + 1] + 1
                    else maxOf(dp[i + 1][j], dp[i][j + 1])
            }
        }

        return dp[0][0]
    }
}