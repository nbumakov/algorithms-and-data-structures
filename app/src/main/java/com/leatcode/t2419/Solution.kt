package com.leatcode.t2419

import kotlin.math.max

class Solution {
    fun longestSubarray(nums: IntArray): Int {
        val max = nums.max()
        var length = 0
        return nums.maxOf {
            if (it == max) length++ else length = 0
            length
        }
    }
}