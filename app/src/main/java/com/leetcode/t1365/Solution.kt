package com.leetcode.t1365

// Counting sort: nums[i] is bounded by 0..100, so count occurrences per
// value and turn it into a prefix sum where count[v] = amount of numbers <= v.
class Solution {
    fun smallerNumbersThanCurrent(nums: IntArray): IntArray {
        val count = IntArray(101)
        for (v in nums) count[v]++
        for (i in 1..100) count[i] += count[i - 1]
        return IntArray(nums.size) { i -> if (nums[i] == 0) 0 else count[nums[i] - 1] }
    }
}

// Sort a copy of the array and remember the first index at which each
// value appears — that index equals the amount of strictly smaller numbers.
class Solution2 {
    fun smallerNumbersThanCurrent(nums: IntArray): IntArray {
        val firstIndex = mutableMapOf<Int, Int>()
        nums.sorted().forEachIndexed { index, value -> firstIndex.putIfAbsent(value, index) }
        return IntArray(nums.size) { i -> firstIndex.getValue(nums[i]) }
    }
}

fun main() {
    println(Solution().smallerNumbersThanCurrent(intArrayOf(8, 1, 2, 2, 3)).toList())
    println(Solution().smallerNumbersThanCurrent(intArrayOf(6, 5, 4, 8)).toList())
    println(Solution().smallerNumbersThanCurrent(intArrayOf(7, 7, 7, 7)).toList())
}
