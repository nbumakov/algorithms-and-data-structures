package com.leetcode.t1631

import com.leetcode.util.print
import kotlin.math.abs

fun main() {
    Solution().minimumEffortPath(
        arrayOf(
            intArrayOf(1, 2, 3),
            intArrayOf(3, 8, 4),
            intArrayOf(5, 3, 5),
        )
    ).print()

//    Solution().minimumEffortPath(
//        arrayOf(
//            intArrayOf(1, 2, 1, 1, 1),
//            intArrayOf(1, 2, 1, 2, 1),
//            intArrayOf(1, 2, 1, 2, 1),
//            intArrayOf(1, 2, 1, 2, 1),
//            intArrayOf(1, 1, 1, 2, 1),
//        )
//    ).print()
}

class Solution {

    // TODO
    fun minimumEffortPath(heights: Array<IntArray>): Int {
        val visited = Array(heights.size) { BooleanArray(heights[it].size) }
        val cache = Array(heights.size) { IntArray(heights[it].size) { -1 } }

        var minDiff = MAX_HEIGHT

        fun dfs(i: Int, j: Int, diff: Int) {
            if (i == heights.lastIndex && j == heights[i].lastIndex) {
                minDiff = minOf(minDiff, diff)
            }

            fun run(i2: Int, j2: Int) {
                if (i !in heights.indices || j !in heights[i].indices) return
                if (visited[i2][j2]) return
                dfs(i2, j2, maxOf(diff, abs(heights[i][j] - heights[i2][j2])))
            }

            visited[i][j] = true
            run(i - 1, j)
            run(i + 1, j)
            run(i, j - 1)
            run(i, j + 1)
            visited[i][j] = false
        }

        dfs(0, 0, 0)

        return minDiff
    }

    companion object {
        private const val MAX_HEIGHT = 1_000_000
    }
}