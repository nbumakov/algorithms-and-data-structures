package com.leetcode.t39

import com.leetcode.util.print


fun main() {
    Solution().combinationSum(intArrayOf(2, 3, 6, 7), 7).print()
}

class Solution {
    fun combinationSum(candidates: IntArray, target: Int): List<List<Int>> {
        val result = mutableListOf<List<Int>>()
        val curr = mutableListOf<Int>()

        fun backtrack(i: Int = 0, t: Int = target) {
            if (t == 0) result.add(curr.toList())
            if (t <= 0) return

            for (j in i..candidates.lastIndex) {
                curr.add(candidates[j])
                backtrack(j, t - candidates[j])
                curr.removeLast()
            }
        }

        backtrack()

        return result
    }
}