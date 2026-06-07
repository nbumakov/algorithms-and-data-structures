package com.leetcode.t2574

import kotlin.math.absoluteValue

class Solution {
    fun leftRightDifference(nums: IntArray): IntArray {
        val s = nums.sum()
        var l = 0
        return IntArray(nums.size) { i ->
            l += nums[i]
            (2 * l - s - nums[i]).absoluteValue
        }
    }
}