package com.leatcode.t221

import kotlin.math.min

class Solution {

    // [["1","1","1","1","1","1","1","1"]
    // ,["1","1","1","1","1","1","1","0"]
    // ,["1","1","1","1","1","1","1","0"]
    // ,["1","1","1","1","1","0","0","0"]
    // ,["0","1","1","1","1","0","0","0"]]
    fun maximalSquare(matrix: Array<CharArray>): Int {
        val dp = Array(matrix.size + 1) { IntArray(matrix.first().size + 1) }

        for (i in matrix.size downTo 0) {
            for (j in matrix[i].size downTo 0) {
                if (i > matrix.lastIndex || j > matrix[i].lastIndex || matrix[i][j] == '0') {
                    dp[i][j] = 0
                } else {
                    dp[i][j] = minOf(dp[i + 1][j], dp[i][j + 1], dp[i + 1][j + 1]) + 1
                }
            }
        }

        return dp.asSequence().map { it.max()!! }.max()!!.let { it * it }
    }
}