package com.leetcode.t74

import com.leetcode.util.print

fun main() {
    Solution().searchMatrix(
        arrayOf(
            intArrayOf(1),
            intArrayOf(2),
        ),
        2
    ).print()
}

class Solution {

    // 1D BS
    fun searchMatrix(matrix: Array<IntArray>, target: Int): Boolean {
        val n = matrix.size
        val m = matrix.first().size
        var l = 0
        var r = n * m - 1

        while (l <= r) {
            val mid = (l + r) / 2
            val i = mid / m
            val j = mid % m

            when {
                target < matrix[i][j] -> r = mid - 1
                target > matrix[i][j] -> l = mid + 1
                else -> return true
            }
        }
        return false
    }

    fun searchMatrix_2D(matrix: Array<IntArray>, target: Int): Boolean {
        var b = matrix.lastIndex
        var t = 0

        while (t < b) {
            val mid = t + (b - t + 1) / 2
            when {
                matrix[mid].first() <= target -> t = mid
                else -> b = mid - 1
            }
        }

        val row = t
        var l = 0
        var r = matrix[row].lastIndex

        while (l <= r) {
            val mid = (l + r) / 2
            when {
                target > matrix[row][mid] -> l = mid + 1
                target < matrix[row][mid] -> r = mid - 1
                else -> return true
            }
        }
        return false
    }
}