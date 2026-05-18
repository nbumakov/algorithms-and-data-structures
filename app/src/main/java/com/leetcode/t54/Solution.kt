package com.leetcode.t54

import com.leetcode.util.print

fun main() {
    Solution().spiralOrder(
        arrayOf(
            intArrayOf(1, 2, 3),
            intArrayOf(4, 5, 6),
            intArrayOf(7, 8, 9),
        )
    ).print()
}

class Solution {
    fun spiralOrder(matrix: Array<IntArray>): List<Int> {
        var top = 0
        var bottom = matrix.lastIndex
        var left = 0
        var right = matrix.first().lastIndex

        var direction = Direction.Right

        val result = ArrayList<Int>(matrix.size * matrix.first().size)
        while (left <= right && top <= bottom) {
            when (direction) {
                Direction.Right -> {
                    for (j in left..right) result.add(matrix[top][j])
                    top++
                    direction = Direction.Bottom
                }
                Direction.Bottom -> {
                    for (i in top..bottom) result.add(matrix[i][right])
                    right--
                    direction = Direction.Left
                }
                Direction.Left -> {
                    for (j in right downTo left) result.add(matrix[bottom][j])
                    bottom--
                    direction = Direction.Top
                }
                Direction.Top -> {
                    for (i in bottom downTo top) result.add(matrix[i][left])
                    left++
                    direction = Direction.Right
                }
            }
        }
        return result
    }

    private enum class Direction {
        Right, Bottom, Left, Top
    }

}