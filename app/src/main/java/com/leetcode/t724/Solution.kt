package com.leetcode.t724

import com.leetcode.util.print

fun main() {
    Solution().pivotIndex(intArrayOf(1, 7, 3, 6, 5, 6)).print()
}

class Solution {
    fun pivotIndex(nums: IntArray): Int {
        val sum = nums.sum()
        var currentSum = 0
        for (i in nums.indices) {
            if (currentSum == sum - currentSum - nums[i]) return i
            currentSum += nums[i]
        }
        return -1
    }
}