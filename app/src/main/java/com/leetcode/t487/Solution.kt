package com.leetcode.t487

import com.leetcode.util.print

fun main() {
    Solution().findMaxConsecutiveOnes(intArrayOf(1, 0, 1, 1, 0)).print()
}

/**
 * Given a binary array nums,
 * return the maximum number of consecutive 1's in the array
 * if you can flip at most one 0.
 */
class Solution {
    fun findMaxConsecutiveOnes(nums: IntArray): Int {
        var l = 0
        var r = 0
        var zeros = 1
        var max = 0
        while (r <= nums.lastIndex) {
            when {
                nums[r] == 1 -> r++
                zeros > 0 -> {
                    zeros--
                    r++
                }

                else -> {
                    while (nums[l] != 0) l++
                    l++
                    zeros++
                }
            }
            max = maxOf(max, r - l)
        }
        return max
    }
}