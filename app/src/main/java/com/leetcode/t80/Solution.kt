package com.leetcode.t80

import com.leetcode.util.print

fun main() {
    val a = intArrayOf(0, 0, 1, 1, 1, 1, 2, 3, 3)
    Solution().removeDuplicates(a).print()
    a.print()
}

class Solution {
    fun removeDuplicates(nums: IntArray): Int {
        var left = 1
        var count = 1

        for (i in 1..nums.lastIndex) {
            if (nums[i - 1] == nums[i]) count++ else count = 1
            if (count <= 2) nums[left++] = nums[i]
        }

        return left
    }
}