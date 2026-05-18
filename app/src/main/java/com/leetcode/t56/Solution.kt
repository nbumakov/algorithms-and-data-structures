package com.leetcode.t56

class Solution {
    fun merge(intervals: Array<IntArray>): Array<IntArray> {
        intervals.sortBy { it.first() }
        var end = intervals.first().last()
        var start = intervals.first().first()
        val result = mutableListOf<IntArray>()
        for (i in 1..intervals.lastIndex) {
            if (intervals[i].first() > end) {
                result.add(intArrayOf(start, end))
                start = intervals[i].first()
            }
            end = maxOf(end, intervals[i].last())
        }
        result.add(intArrayOf(start, end))
        return result.toTypedArray()
    }
}


class Solution2 {
    fun merge(intervals: Array<IntArray>): Array<IntArray> {
        intervals.sortBy { it[0] }
        val merged = mutableListOf<IntArray>()

        for (interval in intervals) {
            if(merged.isEmpty() || interval[0] > merged.last()[1]) {
                merged.add(interval)
            } else {
                merged.last()[1] = maxOf(merged.last()[1], interval[1])
            }
        }
        return merged.toTypedArray()
    }
}