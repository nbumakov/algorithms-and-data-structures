package com.leetcode.t1727

import kotlin.math.max

class Solution {
    fun largestSubmatrix(matrix: Array<IntArray>): Int {
        var ans = 0
        for (i in matrix.indices) {
            for (j in matrix[i].indices) {
                if (matrix[i][j] > 0) matrix[i][j] = matrix.getOrNull(i - 1)?.get(j)?.inc() ?: 1
            }

            val row = matrix[i].sortedDescending()
            for (j in row.indices) {
                val area = row[j] * (j + 1)
                ans = max(ans, area)
            }
        }

        return ans
    }
}