package com.leetcode.t179

import com.leetcode.util.print

fun main() {
    Solution().largestNumber(intArrayOf(10, 2)).print()
    Solution().largestNumber(intArrayOf(3, 30, 34, 5, 9)).print()
}

class Solution {
    fun largestNumber(nums: IntArray): String = nums.map(Int::toString)
        .sortedWith { a, b -> (b + a).compareTo(a + b) }
        .takeIf { it.first() != "0" }
        ?.joinToString("") ?: "0"
}