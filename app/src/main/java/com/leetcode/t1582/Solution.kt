package com.leetcode.t1582

import com.leetcode.util.print

fun main() {
    // [[1,0,0],[0,0,1],[1,0,0]]
    Solution()
        .numSpecial2(
            arrayOf(
                intArrayOf(1, 0, 0),
                intArrayOf(0, 0, 1),
                intArrayOf(1, 0, 0),
            )
        )
        .print()
}

class Solution {
    fun numSpecial(mat: Array<IntArray>): Int {
        val rowsSet = mat.indices
            .filter { i -> mat[i].sum() == 1 }
            .toSet()

        val columnsSet = mat[0].indices
            .filter { j -> mat.indices.sumOf { mat[it][j] } == 1 }
            .toSet()

        return mat.indices
            .filter { it in rowsSet }
            .sumOf { i ->
                mat[i].indices
                    .filter { j -> mat[i][j] == 1 }
                    .count { it in columnsSet }
            }
    }

    fun numSpecial2(mat: Array<IntArray>): Int {
        val rowsOnesCount = mat.map { it.sum() }
        val columnsOnesCount = mat[0].indices.map { j -> mat.indices.sumOf { mat[it][j] } }

        var ans = 0
        for (i in mat.indices) {
            if (rowsOnesCount[i] == 1) {
                for (j in mat[i].indices) {
                    if (mat[i][j] == 1 && columnsOnesCount[j] == 1) {
                        ans++
                    }
                }
            }
        }
        return ans
    }
}