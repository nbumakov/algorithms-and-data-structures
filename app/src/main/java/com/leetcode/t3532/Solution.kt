package com.leetcode.t3532

class Solution {
    fun pathExistenceQueries(
        n: Int,
        nums: IntArray,
        maxDiff: Int,
        queries: Array<IntArray>
    ): BooleanArray {
        var currentCluster = 0
        val clusters = IntArray(n)

        for (i in 1..nums.lastIndex) {
            if (nums[i] - nums[i - 1] > maxDiff) currentCluster++
            clusters[i] = currentCluster
        }

        return queries
            .map { (x, y) -> clusters[x] == clusters[y] }
            .toBooleanArray()
    }
}