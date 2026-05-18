package com.leatcode.t1770

import com.leatcode.util.print

fun main() {
    Solution().maximumScore(
        intArrayOf(1, 2, 3),
        intArrayOf(3, 2, 1)
    ).print()
}

class Solution {

    // top down (TLE with array as a cache)
    fun maximumScore1(nums: IntArray, multipliers: IntArray): Int {

        val cache = hashMapOf<Pair<Int, Int>, Int>()

        fun dfs(i: Int, left: Int): Int {
            val right = nums.lastIndex + left - i
            if (i == multipliers.size) return 0
            return cache.getOrPut(i to left) {
                maxOf(
                    nums[left] * multipliers[i] + dfs(i + 1, left + 1),
                    nums[right] * multipliers[i] + dfs(i + 1, left),
                )
            }
        }

        return dfs(0, 0)
    }

    // bottom up
    fun maximumScore(nums: IntArray, multipliers: IntArray): Int {

        val dp = Array(multipliers.size + 1) { IntArray(multipliers.size + 1) }

        for (i in multipliers.lastIndex downTo 0) {
            for (left in i downTo 0) {
                val right = nums.lastIndex + left - i

                dp[i][left] = maxOf(
                    nums[left] * multipliers[i] + dp[i + 1][left + 1],
                    nums[right] * multipliers[i] + dp[i + 1][left],
                )
            }
        }
        return dp[0][0]
    }
}