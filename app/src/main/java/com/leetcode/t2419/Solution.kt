package com.leetcode.t2419

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