package com.leetcode.t57

import com.leetcode.util.print
import kotlin.math.max
import kotlin.math.min

fun main() {
    Solution().insert(
        arrayOf(
            intArrayOf(1, 2),
            intArrayOf(3, 5),
            intArrayOf(6, 7),
            intArrayOf(8, 10),
            intArrayOf(12, 16),
        ),
        intArrayOf(4, 8),
    ).forEach {
        it.print()
    }
}

class Solution {
    fun insert(intervals: Array<IntArray>, newInterval: IntArray): Array<IntArray> {
        val result = mutableListOf<IntArray>()
        var p = 0

        while (p < intervals.size && intervals[p][1] < newInterval[0]) result.add(intervals[p++])

        var start = newInterval[0]
        var end = newInterval[1]

        while (p < intervals.size && intervals[p][0] <= end) {
            start = min(intervals[p][0], start)
            end = max(intervals[p][1], end)
            p++
        }
        result.add(intArrayOf(start, end))

        while (p < intervals.size) result.add(intervals[p++])

        return result.toTypedArray()
    }

}