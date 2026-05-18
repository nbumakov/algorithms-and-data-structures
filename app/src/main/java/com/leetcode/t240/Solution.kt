package com.leetcode.t240

import com.leetcode.util.print
import kotlin.math.min

fun main() {
    Solution()
        .searchMatrix3(
            arrayOf(
                intArrayOf(-5)
//                intArrayOf(1, 4, 7, 11, 15),
//                intArrayOf(2, 5, 8, 12, 19),
//                intArrayOf(3, 6, 9, 16, 22),
//                intArrayOf(10, 13, 14, 17, 24),
//                intArrayOf(18, 21, 23, 26, 30)
            ), 3
        ).print()
}

class Solution {

    fun searchMatrix3(matrix: Array<IntArray>, target: Int): Boolean {
        var i = 0
        var j = 0

        while (i < matrix.size) {
            val x = matrix[i].binarySearch(target, fromIndex = j)
            if (x >= 0) return true else j = min(-x - 2, 0)
            i++
        }

        return false
    }

    fun searchMatrix(matrix: Array<IntArray>, target: Int): Boolean {
        var x = matrix.first().lastIndex
        var y = 0

        while (y < matrix.size) {
            // важно идти сзади иначе куча edje cases
            while (x >= 0 && matrix[y][x] > target) x--
            if (matrix[y][x] == target) return true
            y++
        }
        return false
    }

    // D&C (WA)
    fun searchMatrix_WA(matrix: Array<IntArray>, target: Int): Boolean {
        fun search(left: Int, top: Int, right: Int, bottom: Int): Boolean {
            if (left > right || top > bottom) return false
            if (left == right && top == bottom) return matrix[top][left] == target
            val midi = (top + bottom) / 2
            val midj = (left + right) / 2

            return when {
                (target < matrix[midi][midj]) -> search(left, top, midj, midi)
                (target > matrix[midi][midj]) -> search(midi, midj, right, bottom)
                else -> true
            }
        }
        return search(0, 0, matrix.first().lastIndex, matrix.lastIndex)
    }

    // nlogn
    fun searchMatrix2(matrix: Array<IntArray>, target: Int): Boolean {
        for (row in matrix) {
            var l = 0
            var r = row.lastIndex
            while (l <= r) {
                val mid = (r + l) / 2
                when {
                    row[mid] < target -> l = mid + 1
                    row[mid] > target -> r = mid - 1
                    else -> return true
                }
            }
        }
        return false
    }
}