package com.leetcode.t343

import com.leetcode.util.print
import kotlin.math.pow

fun main() {
    Solution().integerBreak(6).print()
}

class Solution {

    // Approach 4: Equation
    fun integerBreak(n: Int): Int {
        if (n <= 3) return n - 1
        return when (n % 3) {
            0 -> 3.0.pow((n / 3).toDouble()).toInt()
            1 -> 3.0.pow((n / 3 - 1).toDouble()).toInt() * 4
            else -> 3.0.pow((n / 3).toDouble()).toInt() * 2
        }
    }

    // Approach 3: Mathematics
    fun integerBreak3(n: Int): Int {
        if (n <= 3) return n - 1

        var x = n
        var product = 1
        while (x > 4) {
            product *= 3
            x -= 3
        }

        return x * product
    }

    // Approach 2: Bottom-Up Dynamic Programming
    fun integerBreak2(n: Int): Int {
        if (n <= 3) return n - 1

        val dp = IntArray(n + 1) { it } // dp[2] = 2, dp[3] = 3
        for (i in 4..n) {
            dp[i] = (2..i - 2).maxOf { it * dp[i - it] }
        }

        return dp[n]
    }


    // 1: Top-Down Dynamic Programming
    fun integerBreak1(n: Int): Int {
        if (n == 2) return 1
        if (n == 3) return 2

        val cache = hashMapOf(
            1 to 1,
            2 to 2,
            3 to 3,
        )

        fun dfs(n: Int): Int = cache.getOrPut(n) {
            (2..n - 2).maxOf { it * dfs(n - it) }
        }

        return dfs(n)
    }
}