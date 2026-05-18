package com.leatcode.t506

import com.leatcode.util.print

fun main() {
    Solution().findRelativeRanks(intArrayOf(10, 3, 8, 9, 4)).forEach {
        it.print()
    }
}

class Solution {
    fun findRelativeRanks(score: IntArray): Array<String> =
        score.withIndex()
            .sortedByDescending { it.value }
            .mapIndexed { index, indexedValue ->
                val value = when (index) {
                    0 -> "Gold Medal"
                    1 -> "Silver Medal"
                    2 -> "Bronze Medal"
                    else -> "${index + 1}"
                }
                IndexedValue(indexedValue.index, value)
            }
            .sortedBy { it.index }
            .map { it.value }
            .toTypedArray()
}