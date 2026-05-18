package com.leetcode.t1018

import com.leetcode.util.print

fun main() {
    Solution().prefixesDivBy5(intArrayOf(1, 0, 1)).print()
}

class Solution {
    fun prefixesDivBy5(nums: IntArray): List<Boolean> {
        var s = 0
        return List(nums.size) {
            s = (s shl 1 or nums[it]) % 5
            s == 0
        }
    }
}