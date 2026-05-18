package com.leetcode.t1752

fun main() {
    Solution().check(intArrayOf(3, 4, 5, 1, 2)).let(::println)
}
class Solution {
    fun check(nums: IntArray): Boolean {
        var breakIndex = -1
        for (i in 1..nums.lastIndex) {
            if (nums[i] < nums[i - 1]) {
                if (breakIndex != -1) {
                    return false
                }
                breakIndex = i
            }
        }
        return nums.first() >= nums.last() || breakIndex == -1
    }
}