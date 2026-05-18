package com.leatcode.t977

import kotlin.math.abs

class Solution {
    fun sortedSquares(nums: IntArray): IntArray {
        var l = 0
        var r = nums.lastIndex
        return IntArray(nums.size) {
            val n = if (abs(nums[l]) > abs(nums[r])) nums[l++] else nums[r--]
            n * n
        }.apply { reverse() }
    }
}