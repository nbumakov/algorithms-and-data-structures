package com.leetcode.t935

import com.leetcode.util.print


fun main() {
    SolutionDP().knightDialer(3131).print()
}

class Solution {

    fun knightDialer(n: Int): Int {

        val cache = hashMapOf<Triple<Int, Int, Int>, Long>()

        fun dfs(i: Int, j: Int, level: Int): Long {
            if (!isInsideNumpad(i, j)) return 0
            if (level == 1) return 1

            return cache.getOrPut(Triple(i, j, level)) {
                Movements.sumOf { (dy, dx) -> dfs(i + dy, j + dx, level - 1) } % Modulo
            }
        }

        var ans = 0L

        for (i in 0..3) {
            for (j in 0..2) {
                if (!isInsideNumpad(i, j)) continue
                ans += dfs(i, j, n)
            }
        }

        return (ans % Modulo).toInt()
    }

    private fun isInsideNumpad(i: Int, j: Int): Boolean =
        (i in 0..2 && j in 0..2) || (i == 3 && j == 1)

    companion object {
        val Movements = listOf(
            1 to 2,
            1 to -2,
            2 to 1,
            2 to -1,
            -1 to 2,
            -1 to -2,
            -2 to 1,
            -2 to -1,
        )

        const val Modulo = 1_000_000_007
    }
}

class SolutionDP {


    fun knightDialer(n: Int): Int {
        val dp = Array(n) { IntArray(10) }
        for (i in 0..9) {
            dp[0][i] = 1
        }

        for (i in 1 until n) {
            for (j in 0..9) {
                dp[i][j] = Movements[j].fold(dp[i][j]) { acc, j2 ->
                    (acc + dp[i - 1][j2]) % Modulo // TODO: wtf
                }
            }
        }

        return dp[n-1].fold(0) { acc, i -> (acc + i) % Modulo }
    }

    companion object {
        const val Modulo = 1_000_000_007

        val Movements = listOf(
            listOf(4, 6),
            listOf(6, 8),
            listOf(7, 9),
            listOf(4, 8),
            listOf(3, 9, 0),
            listOf(),
            listOf(1, 7, 0),
            listOf(2, 6),
            listOf(1, 3),
            listOf(2, 4)
        )
    }

}