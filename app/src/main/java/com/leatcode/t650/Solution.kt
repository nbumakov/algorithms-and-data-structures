package com.leatcode.t650

import kotlin.math.min

fun main() {
    Solution3().minSteps(1).let(::println)
    Solution3().minSteps(3).let(::println)
}

// Approach 2: Top-Down Dynamic Programming
class Solution2 {
    fun minSteps(n: Int): Int {
        if (n == 1) return 0

        val memo = mutableMapOf<Pair<Int, Int>, Int>()

        fun dfs(curr: Int, paste: Int): Int {
            if (curr == n) return 0
            if (curr > n) return n

            return memo.getOrPut(curr to paste) {
                val opt1 = dfs(curr + paste, paste) + 1
                val opt2 = dfs(2 * curr, curr) + 2
                min(opt1, opt2)
            }
        }

        return dfs(1, 1) + 1
    }
}

// Approach 3: Bottom-Up Dynamic Programming
class Solution3 {
    fun minSteps(n: Int): Int {
        val dp = IntArray(n + 1) { n }
        dp[1] = 0

        for (i in 2..n) {
            for (j in 1..i / 2) {
                // If j is a divisor of i, it means that we can reach i 'A's
                // by first obtaining j 'A's and then performing a series of pastes.
                if (i % j == 0) dp[i] = min(dp[i], dp[j] + i / j)
            }
        }

        return dp[n]
    }
}