package com.leetcode.t229

import com.leetcode.util.print

fun main() {
    Solution().majorityElement(intArrayOf(3, 1, 2, 1, 2)).print()
}

class Solution {

    // TODO(explore again) Boyer-Moore Voting Algorithm
    fun majorityElement(nums: IntArray): List<Int> {
        var x1: Int? = null
        var x2: Int? = null
        var count1 = 0
        var count2 = 0

        for (x in nums) {
            when {
                x1 == x -> count1++
                x2 == x -> count2++
                count1 == 0 -> {
                    x1 = x
                    count1++
                }
                count2 == 0 -> {
                    x2 = x
                    count2++
                }
                else -> {
                    count1--
                    count2--
                }
            }
        }

        return buildList {
            if (nums.count { it == x1 } > nums.size / 3) add(x1!!)
            if (nums.count { it == x2 } > nums.size / 3) add(x2!!)
        }
    }
}










