package com.leetcode.t2971

import com.leetcode.util.print

fun main() {
    Solution().largestPerimeter(intArrayOf(6,5,50)).print()
    SolutionSD().largestPerimeter(intArrayOf(6,5,50)).print()
}

class Solution {
    fun largestPerimeter(nums: IntArray): Long {
        var maxSum = -1L
        nums.sort()
        nums.foldIndexed(0L) { i, acc, n ->
            (acc + n).also { if (acc > n) maxSum = it }
        }
        return maxSum
    }
}

class SolutionSD {
    fun largestPerimeter(nums: IntArray): Long = nums
        .sorted()
        .fold(0L to -1L) { (s, r), x ->
            s + x to if (s > x) s + x else r
        }.second
}