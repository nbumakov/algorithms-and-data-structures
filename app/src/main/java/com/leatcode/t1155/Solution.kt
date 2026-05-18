package com.leatcode.t1155

import com.leatcode.util.print

fun main() {
    Solution12().numRollsToTarget2(1, 6, 3).print()
    Solution12().numRollsToTarget2(2, 6, 7).print()
    Solution12().numRollsToTarget2(30, 30, 500).print()
}

class Solution12 {

    // DP
    fun numRollsToTarget3(n: Int, k: Int, target: Int): Int {
        val dp = Array(target + 1) { IntArray(n + 1) }
        for (i in 1..k) dp[i][1] = 1

        for (i in 2..n) {
            for (j in 1..target + 1) {
                dp[j][i] = (1..k).fold(0) { acc, face ->
                    (acc + (dp.getOrNull(j - face)?.get(i - 1) ?: 0)) % Modulo
                }
            }
        }
        return dp[target][n]
    }

    //DP
    fun numRollsToTarget2(n: Int, k: Int, target: Int): Int {
        val dp = Array(1001) { IntArray(n + 1) }
        for (i in 1..k) dp[i][1] = 1

        for (i in 2..n) {
            for (j in 1..target + 1) {
                dp[j][i] = (1..k).fold(0) { acc, face ->
                    (acc + (dp.getOrNull(j - face)?.get(i - 1) ?: 0)) % Modulo
                }
            }
        }
        return dp[target][n]
    }

    // Top-Down
    fun numRollsToTarget(n: Int, k: Int, target: Int): Int {
        val cache = hashMapOf<Pair<Int, Int>, Int>()
        fun ways(i: Int, s: Int): Int {
            if (i == n) return if (target - s in 1..k) 1 else 0

            return cache.getOrPut(i to s) {
                (1..k).fold(0) { acc, face ->
                    (acc + ways(i + 1, s + face)) % Modulo
                }
            }
        }

        return ways(1, 0)
    }

    companion object {
        const val Modulo = 1_000_000_000 + 7
    }
}