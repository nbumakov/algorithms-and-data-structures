package com.leatcode.t73

import com.leatcode.util.print

fun main() {
    val a = arrayOf(
        intArrayOf(1, 2, 3, 4),
        intArrayOf(5, 0, 7, 8),
        intArrayOf(0, 10, 11, 12),
        intArrayOf(13, 14, 15, 0),
    )
    Solution().setZeroes(a)
    a.forEach { it.print() }
}

class Solution {
    fun setZeroes(matrix: Array<IntArray>) {
        var isCol = false

        for (i in matrix.indices) {

            if (matrix[i][0] == 0) isCol = true

            for (j in 1..matrix[i].lastIndex) {
                if (matrix[i][j] == 0) {
                    matrix[i][0] = 0
                    matrix[0][j] = 0
                }
            }
        }

        for (i in 1..matrix.lastIndex) {
            for (j in 1..matrix[i].lastIndex) {
                if (matrix[0][j] == 0 || matrix[i][0] == 0) matrix[i][j] = 0
            }
        }

        if (matrix[0][0] == 0) for (j in matrix[0].indices) matrix[0][j] = 0
        if (isCol) for (i in matrix.indices) matrix[i][0] = 0
    }

    fun setZeroes2(matrix: Array<IntArray>) {
        val columnSet = mutableSetOf<Int>()
        val rowSet = mutableSetOf<Int>()

        for (i in matrix.indices) {
            for (j in matrix[i].indices) {
                if (matrix[i][j] == 0) {
                    columnSet.add(j)
                    rowSet.add(i)
                }
            }
        }

        for (i in matrix.indices) {
            for (j in matrix[i].indices) {
                if (i in rowSet || j in columnSet) {
                    matrix[i][j] = 0
                }
            }
        }
    }
}