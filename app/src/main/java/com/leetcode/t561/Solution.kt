package com.leetcode.t561

class Solution {
    fun arrayPairSum(nums: IntArray): Int {
        nums.sort()
        var sum = 0
        for (i in 0..nums.lastIndex step 2) {
            sum += nums[i]
        }
        return sum
    }
}