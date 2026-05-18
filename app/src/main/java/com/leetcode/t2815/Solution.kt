package com.leetcode.t2815

import com.leetcode.util.print

/**
 *  You are given a 0-indexed integer array nums.
 *  You have to find the maximum sum of a pair of numbers from nums
 *  such that the maximum digit in both numbers are equal.
 *
 *  Return the maximum sum or -1 if no such pair exists.
 */

fun main() {
    val a = 27
//    println(with(Solution()) { a.max() })
    Solution().maxSum(intArrayOf(51, 71, 17, 24, 42)).print()
    Solution().maxSum(intArrayOf(1, 2, 3, 4)).print()
}

class Solution {

    fun maxSum(nums: IntArray): Int =
        nums.groupBy { it.max() }
            .filter { it.value.size > 1 }
            .map { it.value.sorted().takeLast(2).sum() }
            .max() ?: -1 //maxOrNull

    private fun Int.max(): Int {
        var x = this
        var max = 0
        while (x != 0) {
            val t = x % 10
            max = maxOf(max, t)
            x /= 10
        }
        return max
    }
}