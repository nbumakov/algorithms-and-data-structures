package com.leetcode.t2529

import kotlin.math.max

class Solution {
    fun maximumCount(nums: IntArray): Int =
        max(nums.count { it > 0 }, nums.count { it < 0 })

    fun maximumCount2(nums: IntArray): Int {
        if (nums.first() > 0 || nums.last() < 0) return nums.size

        val neg = binarySearch(nums, 0)
        val pos = nums.size - binarySearch(nums, 1)

        return max(neg, pos)
    }

    private fun binarySearch(nums: IntArray, target: Int): Int {
        var left = 0
        var right = nums.size // important

        while (left < right) {
            val mid = (left + right) / 2

            if (nums[mid] < target) {
                left = mid + 1
            } else {
                right = mid
            }
        }
        return left
    }

}