package com.leetcode.t1493

class Solution {
    fun longestSubarray(nums: IntArray): Int {
        var zeroes = 0
        var start = 0
        var longestSubarray = 0

        for (i in nums.indices) {
            if (nums[i] == 0) {
                zeroes++
            }
            while (zeroes > 1) {
                if (nums[start] == 0) {
                    zeroes--
                }
                start++
            }
            longestSubarray = maxOf(longestSubarray, i - start)
        }
        return longestSubarray
    }
}