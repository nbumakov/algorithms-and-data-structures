package com.leetcode.t1871

import com.leetcode.util.print

fun main() {
    Solution().canReach("011010", 2, 3).print()
    Solution().canReach("01101110", 2, 3).print()
    Solution().canReach("00111010", 3, 5).print()
    Solution().canReach("0000000000", 8, 8).print()
}

class Solution {
    fun canReach(s: String, minJump: Int, maxJump: Int): Boolean {
        val dp = IntArray(s.length) // 1 - true, 0 - false
        val pre = IntArray(s.length + 1) // pre[i] = sum(dp[0..i-1])

        dp[0] = 1
        for (i in 1 until s.length) {
            pre[i] = pre[i - 1] + dp[i - 1]
            if (s[i] == '0') {
                val left = (i - maxJump).coerceAtLeast(0)
                val right = i - minJump
                if (right >= 0 && pre[right + 1] - pre[left] > 0) {
                    dp[i] = 1
                }
            }
        }

        return dp[s.lastIndex] == 1
    }
}