package com.leatcode.t1428

import com.leatcode.util.print

fun main() {
    val bm = object : Solution.BinaryMatrix {
        val matrix = arrayOf(
            intArrayOf(0, 0),
            intArrayOf(1, 1),
        )

        override fun get(row: Int, col: Int): Int = matrix[row][col]

        override fun dimensions(): List<Int> = listOf(2, 2)

    }
    Solution().leftMostColumnWithOne(bm).print()
}

class Solution {

    // This is the BinaryMatrix's API interface.
    // You should not implement it, or speculate about its implementation
    interface BinaryMatrix {
        fun get(row: Int, col: Int): Int
        fun dimensions(): List<Int>
    }

    fun leftMostColumnWithOne(binaryMatrix: BinaryMatrix): Int {
        val (rows, columns) = binaryMatrix.dimensions()

        fun getIndexOfFirstOne(row: Int, end: Int): Int {
            var l = 0
            var r = end
            while (l <= r) {
                val mid = (l + r) / 2
                val value = binaryMatrix.get(row, mid)
                when {
                    value >= 1 -> r = mid - 1
                    else -> l = mid + 1
                }
            }
            return if (r + 1 <= end && binaryMatrix.get(row, r + 1) == 1) r + 1 else -1
        }

        var firstColumn = Int.MAX_VALUE
        for (row in 0 until rows) {
            val columnIndex = getIndexOfFirstOne(row, minOf(firstColumn, columns) - 1)
            if (columnIndex >= 0) {
                firstColumn = minOf(firstColumn, columnIndex)
            }
        }

        return if (firstColumn == Int.MAX_VALUE) -1 else firstColumn
    }


}