package com.leetcode.t435

class Solution {
    fun eraseOverlapIntervals(intervals: Array<IntArray>): Int {
        intervals.sortBy { it[1] }
        var k = Int.MIN_VALUE
        return intervals.count { (from, to) ->
            if (from >= k) {
                k = to
                false
            } else {
                true
            }
        }
    }
}