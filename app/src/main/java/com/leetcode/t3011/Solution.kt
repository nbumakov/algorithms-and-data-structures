package com.leetcode.t3011

import kotlin.math.max

class Solution {
    fun canSortArray(nums: IntArray): Boolean {
        var currSegmentMax = Int.MIN_VALUE
        var prevSegmentMax = Int.MIN_VALUE
        var prevSegmentBitsCount = 0
        for (n in nums) {
            val bitsCount = n.countOneBits()
            if (prevSegmentBitsCount != bitsCount) {
                prevSegmentMax = currSegmentMax
                prevSegmentBitsCount = bitsCount
            }
            currSegmentMax = max(currSegmentMax, n)
            if (n < prevSegmentMax) return false
        }
        return true
    }
}