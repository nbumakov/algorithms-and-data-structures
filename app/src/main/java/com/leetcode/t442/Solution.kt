package com.leetcode.t442

import kotlin.math.abs

fun main() {
    Solution()
        .findDuplicates(
            intArrayOf(4, 3, 2, 7, 8, 2, 3, 1)
        )
}

class Solution {
    fun findDuplicates(nums: IntArray): List<Int> {

        fun mark(n: Int) {
            when {
                nums[n - 1] <= 0 -> nums[n - 1]--
                nums[n - 1] > 0 -> nums[n - 1].run {
                    nums[n - 1] = -1
                    mark(this)
                }
            }
        }

        for (i in nums.indices) {
            val n = nums[i]
            if (n < 0) continue
            nums[i] = 0
            mark(n)
        }

        return nums.withIndex()
            .filter { it.value == -2 }
            .map { it.index + 1 }
    }
}

class SolutionSD {
    fun findDuplicates(nums: IntArray) = buildList {
        for (n in nums) {
            if (nums[abs(n) - 1] < 0) add(abs(n))
            nums[abs(n) - 1] *= -1
        }
    }
}