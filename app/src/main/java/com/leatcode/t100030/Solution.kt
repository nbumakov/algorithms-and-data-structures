package com.leatcode.t100030

import com.leatcode.util.print
import java.lang.IllegalStateException
import java.util.LinkedList
import java.util.Queue
import kotlin.math.abs

fun main() {
//    Solution().minimumMoves(
//        arrayOf(
//            intArrayOf(1, 2, 2),
//            intArrayOf(1, 1, 0),
//            intArrayOf(0, 1, 1),
//        )
//    ).print()
//
//    Solution().minimumMoves(
//        arrayOf(
//            intArrayOf(0, 1, 2),
//            intArrayOf(1, 1, 0),
//            intArrayOf(1, 1, 2),
//        )
//    ).print()
//
//    Solution().minimumMoves(
//        arrayOf(
//            intArrayOf(0, 2, 3),
//            intArrayOf(2, 0, 1),
//            intArrayOf(0, 1, 0),
//        )
//    ).print()
    Solution().minimumMoves(
        arrayOf(
            intArrayOf(1, 3, 3),
            intArrayOf(1, 0, 0),
            intArrayOf(0, 1, 0),
        )
    ).print()
}

class Solution {

    // 1, 2, 2
    // 1, 1, 0
    // 0, 1, 1
    fun minimumMoves(grid: Array<IntArray>): Int {
        var min = Int.MAX_VALUE

        fun backtrack(steps: Int) {
            if (grid.balanced()) {
                min = minOf(min, steps)
                return
            }

            for (i in 0..2) {
                for (j in 0..2) {
                    if (grid[i][j] == 0) {
                        for (i2 in 0..2) {
                            for (j2 in 0..2) {
                                if (grid[i2][j2] > 1) {
                                    grid[i2][j2]--
                                    grid[i][j]++
                                    backtrack(abs(i - i2) + abs(j - j2) + steps)
                                    grid[i2][j2]++
                                    grid[i][j]--
                                }
                            }
                        }
                    }
                }
            }
        }
        backtrack(0)
        return min
    }

    private fun Array<IntArray>.balanced(): Boolean = all { it.all { it == 1 } }
}