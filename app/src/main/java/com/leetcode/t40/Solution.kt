package com.leetcode.t40

import com.leetcode.util.print

fun main() {
//    Solution().combinationSum2(intArrayOf(10, 1, 2, 7, 6, 1, 5), 8).print()
//    Solution().combinationSum2(intArrayOf(1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1), 30).print()
    Solution().combinationSum2(intArrayOf(14, 6, 25, 9, 30, 20, 33, 34, 28, 30, 16, 12, 31, 9, 9, 12, 34, 16, 25, 32, 8, 7, 30, 12, 33, 20, 21, 29, 24, 17, 27, 34, 11, 17, 30, 6, 32, 21, 27, 17, 16, 8, 24, 12, 12, 28, 11, 33, 10, 32, 22, 13, 34, 18, 12), 27).print()
}

class Solution {
    fun combinationSum2(candidates: IntArray, target: Int): List<List<Int>> {
        val result = mutableSetOf<List<Int>>()
        val curr = mutableListOf<Int>()
        candidates.sort()

        fun backtrack(i: Int = 0, remain: Int = target) {
            if (remain == 0) result.add(curr.toList())
            if (remain <= 0 || i !in candidates.indices) return

            var candidateIndex: Int = i
            while (candidateIndex >= 0) {
                val candidate = candidates[candidateIndex]
                if (remain - candidate >= 0) {
                    curr += candidate
                    backtrack(candidateIndex + 1, remain - candidate)
                    curr.removeLast()
                }

                // вместо цикла вызываем функцию с следующим уникальным кандидатом
                candidateIndex = candidates.indexOfFirst { it > candidate }
            }
        }

        backtrack()

        return result.toList()
    }
}