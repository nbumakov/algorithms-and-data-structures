package com.leetcode.t1630

class Solution {
    // O(m⋅n⋅logn)
    fun checkArithmeticSubarrays(nums: IntArray, l: IntArray, r: IntArray): List<Boolean> =
        l.zip(r).map { range ->
            nums.sliceArray(range.first..range.second)
                .sorted()
                .windowed(2)
                .map { it.last() - it.first() }
                .run { all { it == first() } }
        }

    fun checkArithmeticSubarrays2(nums: IntArray, l: IntArray, r: IntArray): List<Boolean> =
        l.zip(r).map { range ->
            val set = nums.sliceArray(range.first..range.second).toSet()
            val min = set.min()
            val max = set.max()
            when {
                min == max -> true
                (max - min) % (range.second - range.first) != 0 -> false
                else -> {
                    val diff = (max - min) / (range.second - range.first)
                    (min..max step diff).all(set::contains)
                }
            }
        }
}