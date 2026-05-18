package com.leatcode.t1140

import com.leatcode.util.print

fun main() {
    Solution().stoneGameII(intArrayOf(2, 7, 9, 4, 4)).print()
}

class Solution {

    fun stoneGameII(piles: IntArray): Int {
        val dp = Array(2) {
            Array(piles.size + 1) {
                IntArray(piles.size + 1) { -1 }
            }
        }

        fun dfs(i: Int, m: Int, p: Int): Int { // Возвращает максимум камней которые может взять Алиса
            if (i > piles.lastIndex) return 0
            if (dp[p][i][m] != -1) {
                return dp[p][i][m];
            }
            var sum = 0
            var res = if (p == 0) 0 else Int.MAX_VALUE
            for (x in 1..minOf(2 * m, piles.size - i)) {
                sum += piles[i + x - 1]
                res = if (p == 0) {
                    maxOf(res, dfs(i + x, maxOf(m, x), 1) + sum)
                } else {
                    minOf(res, dfs(i + x, maxOf(m, x), 0))
                }
            }
            dp[p][i][m] = res
            return res
        }

        return dfs(0, 1, 0)
    }

    // TOP-DOWN
    fun stoneGameII_1(piles: IntArray): Int {
        val cache = hashMapOf<Triple<Int, Int, Boolean>, Int>()

        fun dfs(i: Int, m: Int, isAlice: Boolean): Int { // Возвращает максимум камней которые может взять Алиса
            if (i > piles.lastIndex) return 0
            return cache.getOrPut(Triple(i, m, isAlice)) {
                var sum = 0
                var res = if (isAlice) 0 else Int.MAX_VALUE
                for (x in 1..minOf(2 * m, piles.size - i)) {
                    sum += piles[i + x - 1]
                    res = if (isAlice) {
                        maxOf(res, dfs(i + x, maxOf(m, x), false) + sum)
                    } else {
                        minOf(res, dfs(i + x, maxOf(m, x), true))
                    }
                }
                res
            }
        }

        return dfs(0, 1, true)
    }
}