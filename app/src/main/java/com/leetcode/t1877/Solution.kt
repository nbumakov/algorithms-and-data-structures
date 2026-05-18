package com.leetcode.t1877

import com.leetcode.util.print

fun main() {
    Solution().minPairSum(intArrayOf(3, 5, 4, 2, 4, 6)).print()
}

class Solution {
    fun minPairSum(nums: IntArray): Int {
        nums.sort()

        var sum = 0
        for (i in 0 until nums.size / 2) {
            sum = maxOf(sum, nums[i] + nums[nums.lastIndex - i])
        }

        return sum
    }

    fun minPairSum2(nums: IntArray): Int = nums.run {
        sort()
        take(size / 2)
            .zip(takeLast(size / 2).asReversed()) { a, b -> a + b }
            .max()
    }
}