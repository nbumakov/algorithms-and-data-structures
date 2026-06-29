package com.leetcode.t3737

class Solution {
    fun countMajoritySubarrays(nums: IntArray, target: Int): Int {
        var result = 0
        for (i in nums.indices) {
            var targets = 0
            for (j in i..nums.lastIndex) {
                if (nums[j] == target) targets++
                if (targets > (j - i + 1) / 2) result++
            }
        }
        return result
    }
}