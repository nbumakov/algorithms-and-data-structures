package com.leetcode.t823

class Solution {

    fun numFactoredBinaryTrees(arr: IntArray): Int {
        arr.sort()
        val dp = LongArray(arr.size) { 1 }

        val indexes = hashMapOf<Int, Int>()
        arr.forEachIndexed { index, value -> indexes[value] = index }

        for (i in arr.indices) {
            for (leftIndex in 0 until i) {
                if (arr[i] % arr[leftIndex] == 0) {
                    val right = arr[i] / arr[leftIndex]
                    if (indexes.containsKey(right)) {
                        dp[i] = (dp[i] + dp[leftIndex] * dp[indexes[right]!!]) % MOD
                    }
                }
            }
        }

        return dp.reduce { acc, value ->
            (acc + value) % MOD
        }.toInt()
    }

    companion object {
        private const val MOD = 1_000_000_007
    }
}