package com.leetcode.t1752

fun main() {
    Solution().check(intArrayOf(3, 4, 5, 1, 2)).let(::println)
}

class Solution {
    fun check(nums: IntArray): Boolean {
        var pivotPoint = -1
        for (i in 0 until nums.lastIndex) {
            if (nums[i] > nums[i + 1]) {
                if (pivotPoint >= 0) return false
                pivotPoint = i
            }
        }

        return pivotPoint == -1 || nums.first() >= nums.last()
    }
}

class Solution2 {
    fun check(nums: IntArray): Boolean {
        var count = 0
        val n = nums.size
        for (i in 0 until n) {
            if (nums[i] > nums[(i + 1) % n]) {
                if (++count > 1) return false
            }
        }
        return true
    }
}