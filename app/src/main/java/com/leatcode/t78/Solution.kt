package com.leatcode.t78

import com.leatcode.util.print

fun main() {
    Solution().subsets2(intArrayOf(1, 2, 3)).print()
}

class Solution {

    // https://leetcode.com/problems/subsets/solutions/1232996/easy-to-understand-kotlin-answer/
    fun subsets_gmale(nums: IntArray): List<List<Int>> =
        mutableListOf<List<Int>>(listOf())
            .apply { nums.forEach { n -> addAll(map { it + n }) } }

    // Very slow backtracking
    fun subsets(nums: IntArray): List<List<Int>> {
        val result = mutableSetOf<List<Int>>()
        val curr = hashSetOf<Int>()
        fun backtrack() {
            result.add(curr.sorted())
            for (n in nums) {
                if (curr.contains(n)) continue
                curr.add(n)
                backtrack()
                curr.remove(n)
            }
        }
        backtrack()
        return result.toList()
    }

    // normal backtracking
    fun subsets2(nums: IntArray): List<List<Int>> {
        val result = mutableListOf<List<Int>>()
        val curr = mutableListOf<Int>()

        fun backtrack(first: Int = 0) {
            result.add(curr.toList())
            if (first > nums.lastIndex) return

            for (j in first..nums.lastIndex) {
                curr.add(nums[j])
                backtrack(j + 1)
                curr.remove(nums[j])
            }
        }
        backtrack()
        return result
    }
}