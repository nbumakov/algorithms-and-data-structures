package com.leetcode.t643

class Solution {
    fun findMaxAverage(nums: IntArray, k: Int): Double {
        var sum: Double = nums.take(k).sum().toDouble()
        var maxSum: Double = sum.toDouble()
        for (i in k..nums.lastIndex) {
            sum += nums[i] - nums[i - k]
            maxSum = maxOf(sum, maxSum)
        }
        return maxSum / k
    }
}