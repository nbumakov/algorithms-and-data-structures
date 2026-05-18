package com.leetcode.t403

import com.leetcode.util.print

fun main() {
    Solution().canCross(intArrayOf(0, 1, 3, 5, 6, 8, 12, 17)).print()
}

class Solution {

    fun canCross(stones: IntArray): Boolean {
        val dp = Array(stones.size) { BooleanArray(stones.size) }
        val stonesSet = stones.toSet()
        dp[0][0] = true

        for (stone in 1..dp.lastIndex) {
            for (speed in 1..dp.lastIndex) {
                dp[stone][speed] = stonesSet.contains(stones[stone] - speed + 1)
                        || stonesSet.contains(stones[stone] - speed - 1)
                        || stonesSet.contains(stones[stone] - speed)
            }
        }

        for (i in 1..dp.lastIndex) {
            if (dp[i].last()) return true
        }
        return false
    }

    // Top down + memo
    fun canCross1(stones: IntArray): Boolean {
        val visited = hashSetOf<Pair<Int, Int>>()
        fun dfs(p: Pair<Int, Int>): Boolean {
            val (i, k) = p
            if (i == stones.lastIndex) return true
            if (visited.contains(p)) return false
            return sequenceOf(k - 1, k, k + 1)
                .filter { it > 0 }
                .mapNotNull { distance ->
                    stones.binarySearch(stones[i] + distance, i + 1)
                        .takeIf { it > 0 }
                        ?.let { it to distance }
                }
                .any { dfs(it) }
                .also { visited.add(p) }
        }
        return dfs(0 to 0)
    }
}