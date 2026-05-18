package com.leetcode.t456

import kotlin.math.min

class Solution {

    // O(n)
    fun find132pattern(nums: IntArray): Boolean {
        val min = IntArray(nums.size).apply {
            nums.forEachIndexed { index, n ->
                this[index] = min(getOrElse(index - 1) { Int.MAX_VALUE }, n)
            }
        }

        val stack = ArrayDeque<Int>()
        for (j in nums.lastIndex downTo 0) {
            while (stack.isNotEmpty() && stack.last() < nums[j]) {
                if (stack.last() > min[j]) return true
                stack.removeLast()
            }
            stack.add(nums[j])
        }

        return false
    }

    // N2 TLE
    fun find132pattern2(nums: IntArray): Boolean {
        var min = nums[0]
        for (j in 1..nums.lastIndex) {
            for (k in j + 1..nums.lastIndex) {
                if (nums[j] > nums[k] && nums[k] > min) return true
            }

            min = min(min, nums[j])
        }

        return false
    }
}