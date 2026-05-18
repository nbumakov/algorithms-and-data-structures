package com.leatcode.t2352

import com.leatcode.util.print

fun main() {
    Solution().equalPairs(
        arrayOf(
            intArrayOf(3, 1, 2, 2),
            intArrayOf(1, 4, 4, 5),
            intArrayOf(2, 4, 2, 2),
            intArrayOf(2, 4, 2, 2),
        )
    ).print()

    Solution().equalPairs(
        arrayOf(
            intArrayOf(13, 13),
            intArrayOf(13, 13),
        )
    ).print()

    Solution().equalPairs(
        arrayOf(
            intArrayOf(11, 1),
            intArrayOf(1, 11),
        )
    ).print()

    Solution().equalPairs(
        arrayOf(
            intArrayOf(2, 1),
            intArrayOf(3, 32),
        )
    ).print()
}

class Solution {

    fun equalPairs(rows: Array<IntArray>): Int {
        val columns = Array(rows.size) { j ->
            IntArray(rows.size) { i -> rows[i][j] }
        }
        val rowHashes = IntArray(rows.size) { rows[it].contentHashCode() }
        val columnHashes = IntArray(rows.size) { columns[it].contentHashCode() }

        var counter = 0

        for (i in rows.indices) {
            for (j in columns.indices) {
                if (rowHashes[i] == columnHashes[j] && rows[i].contentEquals(columns[j])) {
                    counter++
                }
            }
        }

        return counter
    }

}