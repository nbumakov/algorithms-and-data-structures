package com.leetcode.t799

import kotlin.math.min

class Solution {
    fun champagneTower(poured: Int, query_row: Int, query_glass: Int): Double {
        val tower = Array(query_row + 1) { DoubleArray(query_row + 1) }
        tower[0][0] = poured.toDouble()
        for (r in 0 until query_row) {
            for (c in 0..r) {
                val spillOut = (tower[r][c] - 1) / 2
                if (spillOut <= 0) continue

                tower[r + 1][c] += spillOut
                tower[r + 1][c + 1] += spillOut
            }
        }

        return min(1.0, tower[query_row][query_glass])
    }
}