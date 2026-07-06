package com.leetcode.t1288

import com.leetcode.util.print

/**
 * LeetCode 1288 - Remove Covered Intervals.
 *
 * [a, b) is covered by [c, d) when c <= a and b <= d. Return how many intervals
 * remain after removing every interval that is covered by another one.
 *
 * - [Solution]  : brute force, compare every pair. Time O(n^2), space O(1).
 * - [Solution2] : sort + greedy scan. Time O(n log n), space O(log n).
 */
class Solution {
    fun removeCoveredIntervals(intervals: Array<IntArray>): Int {
        val coveredCount = intervals.indices.count { i ->
            intervals.indices.any { j ->
                j != i && intervals[j][0] <= intervals[i][0] && intervals[j][1] >= intervals[i][1]
            }
        }
        return intervals.size - coveredCount
    }
}

class Solution2 {
    fun removeCoveredIntervals(intervals: Array<IntArray>): Int {
        val sorted = intervals.sortedWith(
            comparator = compareBy({ it[0] }, { -it[1] })
        )

        var count = 0
        var maxEndSoFar = 0
        for (interval in sorted) {
            val end = interval[1]
            if (end > maxEndSoFar) {
                count++
                maxEndSoFar = end
            }
        }
        return count
    }
}

fun main() {
    val intervals = arrayOf(
        intArrayOf(1, 2),
        intArrayOf(1, 4),
        intArrayOf(3, 4)
    )
    Solution().removeCoveredIntervals(intervals).print()
    Solution2().removeCoveredIntervals(intervals).print()
}
