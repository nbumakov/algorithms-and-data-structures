package com.leetcode.t48

fun main() {
    Solution().rotate(
        arrayOf(
            intArrayOf(1, 2, 3),
            intArrayOf(4, 5, 6),
            intArrayOf(7, 8, 9),
        )
    )
}

class Solution {
    fun rotate(matrix: Array<IntArray>) {
        val n = matrix.lastIndex
        for (i in 0 .. n / 2 ) {
            for (j in 0 until (n+1) / 2 ) {
                val temp = matrix[i][j]
                matrix[i][j] = matrix[n - j][i]
                matrix[n - j][i] = matrix[n - i][n - j]
                matrix[n - i][n - j] = matrix[j][n - i]
                matrix[j][n - i] = temp
            }
        }
    }
}