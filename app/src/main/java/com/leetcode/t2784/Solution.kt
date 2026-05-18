package com.leetcode.t2784

import com.leetcode.util.print

fun main() {
    Solution().isGood(intArrayOf(1, 2, 3, 3, 3)).print()
    Solution().isGood2(intArrayOf(1, 2, 3, 3, 3)).print()
}

class Solution {

    fun isGood(nums: IntArray): Boolean {
        val set = hashSetOf<Int>().apply {
            for (i in 1 until nums.size) add(i)
        }
        return nums.size == set.size + 1
                && nums.count { it == nums.size - 1 } == 2
                && nums.toSet() == set
    }

    fun isGood2(nums: IntArray): Boolean {
        val counts = IntArray(nums.size)
        for (n in nums) {
            if (n >= nums.size) return false
            counts[n]++
        }
        for (n in 1 until nums.size - 1) if (counts[n] != 1) return false
        if (counts[nums.size - 1] != 2) return false
        return true
    }
}