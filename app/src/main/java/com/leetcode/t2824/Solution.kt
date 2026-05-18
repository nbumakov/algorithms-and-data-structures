package com.leetcode.t2824

import com.leetcode.util.print

fun main() {
    Solution().countPairs(listOf(-1, 1, 2, 3, 1), 2).print()
}

class Solution {


    fun countPairs(nums: List<Int>, target: Int): Int {
        var count = 0
        for (i in nums.indices) {
            for (j in i + 1..nums.lastIndex) {
                if (nums[i] + nums[j] < target) count++
            }
        }

        return count
    }

    // WA nlogn
    fun countPairs2(nums: List<Int>, target: Int): Int {
        val sortedNums = nums.sorted()
        var count = 0
        sortedNums.forEachIndexed { index, n ->
            var jIndex = sortedNums.binarySearch(target - n - 1)
            if (jIndex < 0) jIndex = -jIndex - 1
            count += (jIndex - index).coerceAtLeast(0)
        }

        return count
    }
}