package com.leatcode.t646

import com.leatcode.util.print

fun main() {
    //[[],[],[],[],[],[],[],[]]
    Solution()
        .findLongestChain(
            arrayOf(
                intArrayOf(-10, -8),
                intArrayOf(8, 9),
                intArrayOf(-5, 0),
                intArrayOf(6, 10),
                intArrayOf(-6, -4),
                intArrayOf(1, 7),
                intArrayOf(9, 10),
                intArrayOf(-4, 7),
            )
        ).print()
}

class Solution {
    fun findLongestChain(pairs: Array<IntArray>): Int {
        var count = 0
        var end = Int.MIN_VALUE
        for (pair in pairs.sortedBy { it[1] }) {
            if (end >= pair[0]) continue
            count++
            end = pair[1]
        }
        return count
    }
}