package com.leetcode.t688

import com.leetcode.util.print

fun main() {
    Solution().knightProbability(8, 30, 6, 4).print()
}

class Solution {

    fun knightProbability(n: Int, k: Int, row: Int, column: Int): Double {
        val cache: Array<Array<DoubleArray>> = Array(k + 1) {
            Array(n) { DoubleArray(n) { -1.0 } }
        }
        return trackPath(cache, n, k, row, column)
    }


    private fun trackPath(cache: Array<Array<DoubleArray>>, n: Int, k: Int, row: Int, column: Int): Double {
        if (row < 0 || row >= n || column < 0 || column >= n) return 0.0
        if (k == 0) {
            return 1.0
        }
        if(cache[k][row][column] > 0) return cache[k][row][column]

        return (listOf(
            trackPath(cache, n, k - 1, row - 2, column - 1),
            trackPath(cache,n, k - 1, row - 2, column + 1),
            trackPath(cache,n, k - 1, row + 2, column - 1),
            trackPath(cache,n, k - 1, row + 2, column + 1),
            trackPath(cache,n, k - 1, row + 1, column + 2),
            trackPath(cache,n, k - 1, row - 1, column + 2),
            trackPath(cache,n, k - 1, row + 1, column - 2),
            trackPath(cache,n, k - 1, row - 1, column - 2),
        ).sum() / 8.0).also {
            cache[k][row][column] = it
        }
    }

}